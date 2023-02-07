package com.kuponku.manager.adapter.input.merchant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MerchantRouter {
    @Bean
    RouterFunction<ServerResponse> publicMerchantRoutes(MerchantHandler handler){
        return route(GET("/merchant/u/{userName}").and(accept(MediaType.APPLICATION_JSON)), handler::getMerchant);
    }
}
