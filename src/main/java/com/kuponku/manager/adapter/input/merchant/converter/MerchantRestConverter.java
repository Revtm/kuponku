package com.kuponku.manager.adapter.input.merchant.converter;

import com.kuponku.manager.adapter.input.merchant.data.MerchantContactResponse;
import com.kuponku.manager.adapter.input.merchant.data.MerchantCouponResponse;
import com.kuponku.manager.adapter.input.merchant.data.MerchantResponse;
import com.kuponku.manager.adapter.input.user.converter.UserRestConverter;
import com.kuponku.manager.domain.entity.coupon.Coupon;
import com.kuponku.manager.domain.entity.coupon.CouponRule;
import com.kuponku.manager.domain.entity.merchant.Merchant;
import com.kuponku.manager.domain.entity.merchant.MerchantContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class MerchantRestConverter {
    private final UserRestConverter userRestConverter;

    @Autowired
    public MerchantRestConverter(UserRestConverter userRestConverter) {
        this.userRestConverter = userRestConverter;
    }

    public Mono<MerchantResponse> convertMerchantToMerchantResponse(Merchant merchant){
        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
        response.setUser(userRestConverter.convertUserDomainToUserResponse(merchant.getUser()));
        response.setName(merchant.getName());
        response.setLogo(merchant.getLogo());
        response.setDescription(merchant.getDescription());
        response.setAddress(merchant.getAddress());
        response.setContact(convertContactListToContactResponseList(merchant.getContact()));
        response.setFollower(merchant.getFollower());
        response.setCouponList(convertCouponListToCouponResponseList(merchant.getCouponList(), merchant.getId()));
        response.setCreatedAt(merchant.getCreatedAt());
        response.setUpdatedAt(merchant.getUpdatedAt());

        return Mono.just(response);
    }

    private List<MerchantContactResponse> convertContactListToContactResponseList(List<MerchantContact> contact){
        List<MerchantContactResponse> contactResponseList = new ArrayList<>();

        for(MerchantContact mC : contact){
            MerchantContactResponse response = new MerchantContactResponse();
            response.setId(mC.getId());
            response.setPlatform(mC.getPlatform());
            response.setLink(mC.getLink());

            contactResponseList.add(response);
        }

        return contactResponseList;
    }

    private List<MerchantCouponResponse> convertCouponListToCouponResponseList(List<Coupon> coupons, BigInteger merchantId){
        List<MerchantCouponResponse> couponResponseList = new ArrayList<>();

        for(Coupon c : coupons){
            MerchantCouponResponse response = new MerchantCouponResponse();
            response.setId(c.getId());
            response.setMerchantId(merchantId);
            response.setTitle(c.getTitle());
            response.setCode(c.getCode());
            response.setCouponRuleList(extractRuleList(c.getCouponRuleList()));
            response.setPublishStatus(c.getPublishStatus());
            response.setStockTotal(c.getStockTotal());
            response.setOwnerRedeemTotal(c.getOwnerRedeemTotal());
            response.setSoldOutStatus(c.getSoldOutStatus());
            response.setExpireStatus(c.getExpireStatus());
            response.setExpiredAt(c.getExpiredAt());
            response.setCreatedAt(c.getCreatedAt());
            response.setUpdatedAt(c.getUpdatedAt());

            couponResponseList.add(response);
        }

        return couponResponseList;
    }

    private List<String> extractRuleList(List<CouponRule> rules){
        List<String> strRules = new ArrayList<>();

        for(CouponRule c : rules){
            strRules.add(c.getRule());
        }

        return strRules;
    }
}
