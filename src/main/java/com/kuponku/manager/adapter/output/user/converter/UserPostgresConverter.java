package com.kuponku.manager.adapter.output.user.converter;

import com.kuponku.manager.adapter.output.user.data.UserPostgres;
import com.kuponku.manager.domain.entity.user.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserPostgresConverter {

    public Mono<User> convertUserPostgresToUserDomain(UserPostgres userPostgres){
        User user = new User();
        user.setId(userPostgres.getId());
        user.setUserName(userPostgres.getUserName());
        user.setPassword(userPostgres.getPassword());
        user.setEmail(userPostgres.getEmail());
        user.setRole(userPostgres.getRole());
        user.setStatus(userPostgres.getStatus());
        user.setCreatedAt(userPostgres.getCreatedAt());
        user.setUpdatedAt(userPostgres.getUpdatedAt());

        return Mono.just(user);
    }

    public Mono<UserPostgres> convertUserDomainToUserPostgres(User user){
        UserPostgres userPostgres = new UserPostgres();
        userPostgres.setId(user.getId());
        userPostgres.setUserName(user.getUserName());
        userPostgres.setPassword(user.getPassword());
        userPostgres.setEmail(user.getEmail());
        userPostgres.setRole(user.getRole());
        userPostgres.setStatus(user.getStatus());
        userPostgres.setCreatedAt(user.getCreatedAt());
        userPostgres.setUpdatedAt(user.getUpdatedAt());

        return Mono.just(userPostgres);
    }
}
