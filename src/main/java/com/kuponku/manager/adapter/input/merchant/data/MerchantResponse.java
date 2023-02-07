package com.kuponku.manager.adapter.input.merchant.data;

import com.kuponku.manager.adapter.input.user.data.UserResponse;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MerchantResponse {
    private BigInteger id;
    private UserResponse user;
    private String name;
    private String logo;
    private String description;
    private String address;
    private List<MerchantContactResponse> contact;
    private BigInteger follower;
    private List<MerchantCouponResponse> couponList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
