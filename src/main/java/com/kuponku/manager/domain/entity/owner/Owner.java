package com.kuponku.manager.domain.entity.owner;

import com.kuponku.manager.domain.entity.coupon.Coupon;
import com.kuponku.manager.domain.entity.user.User;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class Owner {
    private BigInteger id;
    private User user;
    private List<Coupon> couponList;
}
