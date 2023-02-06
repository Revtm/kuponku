package com.kuponku.manager.application.port.output;

import com.kuponku.manager.domain.entity.merchant.MerchantContact;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

public interface MerchantContactDatabase {
    Flux<MerchantContact> findAllByMerchantId(BigInteger merchantId);
}
