package com.kuponku.manager.domain.entity.merchant;

import com.kuponku.manager.domain.entity.coupon.Coupon;
import com.kuponku.manager.domain.entity.user.User;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Merchant {
    private BigInteger id;
    private User user;
    private String name;
    private String logo;
    private String description;
    private String address;
    private List<MerchantContact> contact;
    private BigInteger follower;
    private List<Coupon> couponList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
