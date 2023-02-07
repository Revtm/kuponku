package com.kuponku.manager.adapter.output.coupon.converter;

import com.kuponku.manager.adapter.output.coupon.data.CouponPostgres;
import com.kuponku.manager.domain.entity.coupon.Coupon;
import com.kuponku.manager.domain.entity.coupon.CouponRule;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class CouponPostgresConverter {

    public Mono<Coupon> convertCouponPostgresToDomain(CouponPostgres couponPostgres){
        Coupon coupon = new Coupon();
        coupon.setId(couponPostgres.getId());
        coupon.setTitle(couponPostgres.getTitle());
        coupon.setCode(couponPostgres.getCode());
        coupon.setCouponRuleList(parseCouponRule(couponPostgres.getRules()));
        coupon.setPublishStatus(couponPostgres.getPublishStatus());
        coupon.setStockTotal(couponPostgres.getStockTotal());
        coupon.setOwnerRedeemTotal(couponPostgres.getOwnerRedeemTotal());
        coupon.setExpireStatus(couponPostgres.getExpiredStatus());
        coupon.setExpiredAt(couponPostgres.getExpiredAt());
        coupon.setCreatedAt(couponPostgres.getCreatedAt());
        coupon.setUpdatedAt(couponPostgres.getUpdatedAt());

        return Mono.just(coupon);
    }

    private List<CouponRule> parseCouponRule(String rules){
        List<CouponRule> ruleList = new ArrayList<>();
        String[] ruleArray = rules.split(",");

        for (String r : ruleArray){
            CouponRule rule = new CouponRule();
            rule.setRule(r.trim());
            ruleList.add(rule);
        }

        return ruleList;
    }
}
