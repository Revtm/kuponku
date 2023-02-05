package com.kuponku.manager.application.usecase;

import com.kuponku.manager.domain.entity.user.User;
import reactor.core.publisher.Mono;

public interface UserCommand {
    Mono<User> signUp(User user);
    Mono<User> login(User user);
}
