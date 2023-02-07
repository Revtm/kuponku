package com.kuponku.manager.adapter.output.coupon;

import com.kuponku.manager.adapter.output.coupon.data.CouponPostgres;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

public interface CouponPostgresRepository extends ReactiveCrudRepository<CouponPostgres, BigInteger> {
    Flux<CouponPostgres> findAllByMerchantId(BigInteger merchantId);
}
