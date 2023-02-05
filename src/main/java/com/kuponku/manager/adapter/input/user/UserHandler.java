package com.kuponku.manager.adapter.input.user;

import com.kuponku.manager.adapter.input.user.converter.UserRestConverter;
import com.kuponku.manager.adapter.input.user.data.UserRequest;
import com.kuponku.manager.application.usecase.UserCommand;
import com.kuponku.manager.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {
    private final UserCommand userCommand;
    private final UserRestConverter userRestConverter;

    @Autowired
    public UserHandler(UserCommand userCommand, UserRestConverter userRestConverter) {
        this.userCommand = userCommand;
        this.userRestConverter = userRestConverter;
    }

    public Mono<ServerResponse> login(ServerRequest request){
        return request.bodyToMono(UserRequest.class)
                .flatMap(userRestConverter::convertUserRequestToUserDomain)
                .flatMap(userCommand::login)
                .flatMap(userData -> {
                    return ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(Mono.just(userData), User.class);
                }).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> logout(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("logout success"), String.class);
    }
}
