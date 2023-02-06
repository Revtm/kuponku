package com.kuponku.manager.adapter.output.user;

import com.kuponku.manager.adapter.output.user.converter.UserPostgresConverter;
import com.kuponku.manager.application.port.output.UserDatabase;
import com.kuponku.manager.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserPostgresAdapter implements UserDatabase {

    private final UserPostgresRepository userPostgresRepository;
    private final UserPostgresConverter userPostgresConverter;

    @Autowired
    public UserPostgresAdapter(UserPostgresRepository userPostgresRepository, UserPostgresConverter userPostgresConverter) {
        this.userPostgresRepository = userPostgresRepository;
        this.userPostgresConverter = userPostgresConverter;
    }

    @Override
    public Mono<User> findByUserName(String userName) {
        return userPostgresRepository.findByUserName(userName)
                .flatMap(userPostgresConverter::convertUserPostgresToUserDomain);
    }

    @Override
    public Mono<User> save(User user) {
        return userPostgresConverter.convertUserDomainToUserPostgres(user)
                .flatMap(userPostgresRepository::save)
                .flatMap(userPostgresConverter::convertUserPostgresToUserDomain);
    }

    @Override
    public Mono<Boolean> checkUser(String userName, String email) {
        return userPostgresRepository.findByUserNameOrEmail(userName, email)
                .flatMap(userData -> Mono.just(true))
                .switchIfEmpty(Mono.defer(() -> Mono.just(false)));
    }
}
