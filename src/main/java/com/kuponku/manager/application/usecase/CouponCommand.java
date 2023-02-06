package com.kuponku.manager.application.usecase;

import com.kuponku.manager.domain.entity.coupon.Coupon;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

public interface CouponCommand {
    Flux<Coupon> getAllCoupon(BigInteger merchantId);
}
