package com.kuponku.manager.adapter.input.user;

import com.kuponku.manager.adapter.input.user.filter.UserFIlter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRouter {
    private final UserFIlter userFIlter;

    @Autowired
    public UserRouter(UserFIlter userFIlter) {
        this.userFIlter = userFIlter;
    }

    @Bean
    RouterFunction<ServerResponse> publicRoutes(UserHandler handler){
        return route(POST("/login").and(accept(MediaType.APPLICATION_JSON)), handler::login);
    }

    @Bean
    RouterFunction<ServerResponse> privateRoutes(UserHandler handler){
        return route(POST("/admin/logout").and(accept(MediaType.APPLICATION_JSON)), handler::logout)
                .filter(userFIlter);
    }
}
