package com.kuponku.manager.adapter.input.user;

import com.kuponku.manager.adapter.input.user.converter.UserRestConverter;
import com.kuponku.manager.adapter.input.user.data.UserLoginRequest;
import com.kuponku.manager.adapter.input.user.data.UserRequest;
import com.kuponku.manager.application.usecase.UserCommand;
import com.kuponku.manager.domain.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class UserHandler {
    private final UserCommand userCommand;
    private final UserRestConverter userRestConverter;

    @Autowired
    public UserHandler(UserCommand userCommand, UserRestConverter userRestConverter) {
        this.userCommand = userCommand;
        this.userRestConverter = userRestConverter;
    }

    public Mono<ServerResponse> signUp(ServerRequest request){
        return request.bodyToMono(UserRequest.class)
                .flatMap(userRestConverter::convertUserRequestToUserDomain)
                .flatMap(userCommand::signUp)
                .flatMap(createdUser -> {
                    return ServerResponse
                            .status(HttpStatus.CREATED)
                            .contentType(MediaType.APPLICATION_JSON).build();
                }).onErrorResume(e -> {
                    if(e instanceof RuntimeException){
                        log.error("error: {}", e.getMessage());
                        return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
                                .bodyValue("Username or email is already used");
                    }
                    return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(e.getMessage());
                });
    }

    public Mono<ServerResponse> login(ServerRequest request){
        return request.bodyToMono(UserLoginRequest.class)
                .flatMap(userRestConverter::convertUserLoginRequestToUserDomain)
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
