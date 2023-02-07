package com.kuponku.manager.adapter.output.coupon.data;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Table("coupon")
public class CouponPostgres {
    private BigInteger id;
    private BigInteger merchantId;
    private String title;
    private String code;
    private String rules;
    private Boolean publishStatus;
    private Integer stockTotal;
    private Integer ownerRedeemTotal;
    private Boolean expiredStatus;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
