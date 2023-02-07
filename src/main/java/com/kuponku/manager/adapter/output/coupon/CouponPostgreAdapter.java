package com.kuponku.manager.adapter.output.coupon;

import com.kuponku.manager.adapter.output.coupon.converter.CouponPostgresConverter;
import com.kuponku.manager.application.port.output.CouponDatabase;
import com.kuponku.manager.domain.entity.coupon.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

@Repository
public class CouponPostgreAdapter implements CouponDatabase {

    private final CouponPostgresRepository couponPostgresRepository;
    private final CouponPostgresConverter couponPostgresConverter;

    @Autowired
    public CouponPostgreAdapter(CouponPostgresRepository couponPostgresRepository, CouponPostgresConverter couponPostgresConverter) {
        this.couponPostgresRepository = couponPostgresRepository;
        this.couponPostgresConverter = couponPostgresConverter;
    }

    @Override
    public Flux<Coupon> findAllCouponByMerchantId(BigInteger merchantId) {
        return couponPostgresRepository.findAllByMerchantId(merchantId)
                .flatMap(couponPostgresConverter::convertCouponPostgresToDomain);
    }
}
