package com.kuponku.manager.application.port.output;

import com.kuponku.manager.domain.entity.coupon.Coupon;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

public interface CouponDatabase {
    Flux<Coupon> findAllCouponByMerchantId(BigInteger merchantId);
}
