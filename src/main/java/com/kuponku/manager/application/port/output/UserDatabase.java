package com.kuponku.manager.application.port.output;

import com.kuponku.manager.domain.entity.user.User;
import reactor.core.publisher.Mono;

public interface UserDatabase {
    Mono<User> findByUserName(String userName);
    Mono<User> save(User user);
    Mono<Boolean> checkUser(String userName, String email);
}
