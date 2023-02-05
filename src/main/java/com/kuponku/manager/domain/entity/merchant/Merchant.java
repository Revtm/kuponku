package com.kuponku.manager.domain.entity.merchant;

import com.kuponku.manager.domain.entity.coupon.Coupon;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class Merchant {
    private BigInteger id;
    private String merchantUserName;
    private String email;
    private short role;
    private String name;
    private String logo;
    private String description;
    private String address;
    private List<MerchantContact> contact;
    private BigInteger follower;
    private Boolean status;
    private List<Coupon> couponList;
}
