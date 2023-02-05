package com.kuponku.manager.adapter.input.user.filter;

import com.kuponku.manager.domain.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class UserFIlter implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    private final UserService userService;

    @Autowired
    public UserFIlter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Mono<ServerResponse> filter(ServerRequest request, HandlerFunction<ServerResponse> next) {
        String authorization = request.headers().header("Authorization").get(0);
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7, authorization.length());
            if(userService.validateToken(token)){
                return next.handle(request);
            }
        }
        return ServerResponse.status(HttpStatus.FORBIDDEN).build();
    }
}
