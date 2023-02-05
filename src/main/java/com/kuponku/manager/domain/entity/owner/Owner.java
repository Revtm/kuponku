package com.kuponku.manager.domain.entity.owner;

import com.kuponku.manager.domain.entity.coupon.Coupon;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class Owner {
    private BigInteger id;
    private String ownerUserName;
    private String email;
    private short role;
    private Boolean status;
    private List<Coupon> couponList;
}
