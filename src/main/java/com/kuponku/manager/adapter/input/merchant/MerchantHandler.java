package com.kuponku.manager.adapter.input.merchant;

import com.kuponku.manager.adapter.input.merchant.converter.MerchantRestConverter;
import com.kuponku.manager.adapter.input.merchant.data.MerchantResponse;
import com.kuponku.manager.application.usecase.MerchantCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class MerchantHandler {
    private final MerchantCommand merchantCommand;
    private final MerchantRestConverter merchantRestConverter;

    @Autowired
    public MerchantHandler(MerchantCommand merchantCommand, MerchantRestConverter merchantRestConverter) {
        this.merchantCommand = merchantCommand;
        this.merchantRestConverter = merchantRestConverter;
    }

    public Mono<ServerResponse> getMerchant(ServerRequest request){
        String userName = request.pathVariable("userName");

        return merchantCommand.getMerchant(userName)
                .flatMap(merchantRestConverter::convertMerchantToMerchantResponse)
                .flatMap(merchantResponse -> {
                    return ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(Mono.just(merchantResponse), MerchantResponse.class);
                }).switchIfEmpty(ServerResponse.notFound().build());
    }
}
