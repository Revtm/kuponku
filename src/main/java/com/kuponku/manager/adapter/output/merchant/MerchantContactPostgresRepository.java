package com.kuponku.manager.adapter.output.merchant;

import com.kuponku.manager.adapter.output.merchant.data.MerchantContactPostgres;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

public interface MerchantContactPostgresRepository extends ReactiveCrudRepository<MerchantContactPostgres, BigInteger> {
    Flux<MerchantContactPostgres> findAllByMerchantId(BigInteger merchantId);
}
