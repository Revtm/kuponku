package com.kuponku.manager.domain.entity.coupon;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CouponRule {
    private BigInteger couponId;
    private String rule;
    private Boolean checked;
}
