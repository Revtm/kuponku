package com.kuponku.manager.application.port.input.coupon;

import com.kuponku.manager.application.port.output.CouponDatabase;
import com.kuponku.manager.application.usecase.CouponCommand;
import com.kuponku.manager.domain.entity.coupon.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class CouponCommandImpl implements CouponCommand {

    private final CouponDatabase couponDatabase;

    @Autowired
    public CouponCommandImpl(CouponDatabase couponDatabase) {
        this.couponDatabase = couponDatabase;
    }

    @Override
    public Flux<Coupon> getAllCoupon(BigInteger merchantId) {
        return couponDatabase.findAllCouponByMerchantId(merchantId)
                .flatMap(coupon -> {
                    Boolean expireStatus = LocalDateTime.now()
                            .atZone(ZoneId.of("Asia/Jakarta"))
                            .isAfter(coupon.getExpiredAt().atZone(ZoneId.of("Asia/Jakarta")));
                    coupon.setExpireStatus(expireStatus);

                    Boolean soldOutStatus = coupon.getStockTotal() <= 0;
                    coupon.setSoldOutStatus(soldOutStatus);

                    return Mono.just(coupon);
                });
    }
}
