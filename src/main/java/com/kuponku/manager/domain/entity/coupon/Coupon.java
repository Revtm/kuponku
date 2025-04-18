package com.kuponku.manager.domain.entity.coupon;

import com.kuponku.manager.domain.entity.merchant.Merchant;
import com.kuponku.manager.domain.entity.user.User;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Coupon {
    private BigInteger id;
    private String title;
    private String code;
    private String redeemCode;
    private Merchant merchant;
    private List<CouponRule> couponRuleList;
    private Boolean publishStatus;
    private Integer stockTotal;
    private Integer ownerRedeemTotal;
    private Boolean redeemStatus;
    private Boolean soldOutStatus;
    private Boolean expireStatus;
    private User owner;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
