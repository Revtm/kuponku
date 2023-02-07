package com.kuponku.manager.adapter.input.merchant.data;

import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MerchantCouponResponse {
    private BigInteger id;
    private BigInteger merchantId;
    private String title;
    private String code;
    private List<String> couponRuleList;
    private Boolean publishStatus;
    private Integer stockTotal;
    private Integer ownerRedeemTotal;
    private Boolean soldOutStatus;
    private Boolean expireStatus;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
