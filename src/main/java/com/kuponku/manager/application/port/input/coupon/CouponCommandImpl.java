package com.kuponku.manager.application.port.input.coupon;

import com.kuponku.manager.application.usecase.CouponCommand;
import com.kuponku.manager.domain.entity.coupon.Coupon;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

@Component
public class CouponCommandImpl implements CouponCommand {
    @Override
    public Flux<Coupon> getAllCoupon(BigInteger merchantId) {
        return null;
    }
}
