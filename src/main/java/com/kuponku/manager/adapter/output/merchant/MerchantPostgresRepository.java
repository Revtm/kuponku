package com.kuponku.manager.adapter.output.merchant;

import com.kuponku.manager.adapter.output.merchant.data.MerchantPostgres;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface MerchantPostgresRepository extends ReactiveCrudRepository<MerchantPostgres, BigInteger> {
    Mono<MerchantPostgres> findByUserAccountId(BigInteger userAccountId);
}
