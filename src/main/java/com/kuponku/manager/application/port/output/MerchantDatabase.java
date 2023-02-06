package com.kuponku.manager.application.port.output;

import com.kuponku.manager.domain.entity.merchant.Merchant;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface MerchantDatabase {
    Mono<Merchant> findByUserAccountId(BigInteger userAccountId);
}
