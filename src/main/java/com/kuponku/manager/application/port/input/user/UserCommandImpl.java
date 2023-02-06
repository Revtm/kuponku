package com.kuponku.manager.application.port.input.user;

import com.kuponku.manager.application.port.output.coupon.UserDatabase;
import com.kuponku.manager.application.usecase.UserCommand;
import com.kuponku.manager.domain.entity.user.User;
import com.kuponku.manager.domain.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@Slf4j
public class UserCommandImpl implements UserCommand {

    private final UserDatabase userDatabase;
    private final UserService userService;

    @Autowired
    public UserCommandImpl(UserDatabase userDatabase, UserService userService) {
        this.userDatabase = userDatabase;
        this.userService = userService;
    }

    @Override
    public Mono<User> signUp(User user) {
        return userDatabase.checkUser(user.getUserName(), user.getEmail())
                .flatMap(check -> {
                    if(check){
                        return Mono.error(new RuntimeException());
                    }

                    LocalDateTime time = LocalDateTime.now(ZoneId.of("Asia/Jakarta"));
                    user.setPassword(userService.hashPassword(user.getPassword()));
                    user.setStatus(Boolean.TRUE);
                    user.setCreatedAt(time);
                    user.setUpdatedAt(time);

                    return userDatabase.save(user);
                });
    }

    @Override
    public Mono<User> login(User user) {
        return userDatabase.findByUserName(user.getUserName())
                .flatMap(userData -> {
                    if(userService.checkPassword(user.getPassword(), userData.getPassword())){
                        return Mono.just(userData);
                    }
                    return Mono.empty();
                }).flatMap(loginUser -> {
                    String token = userService.generateToken(loginUser);
                    loginUser.setToken(token);
                    return Mono.just(loginUser);
                });
    }
}
