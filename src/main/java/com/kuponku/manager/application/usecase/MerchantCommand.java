package com.kuponku.manager.application.usecase;

import com.kuponku.manager.domain.entity.merchant.Merchant;
import com.kuponku.manager.domain.entity.merchant.MerchantContact;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface MerchantCommand {
    Mono<Merchant> getMerchant(String userName);
    Flux<MerchantContact> getMerchantContact(BigInteger merchantId);
}
