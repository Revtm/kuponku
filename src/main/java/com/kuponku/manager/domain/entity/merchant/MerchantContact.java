package com.kuponku.manager.domain.entity.merchant;

import lombok.Data;

import java.math.BigInteger;

@Data
public class MerchantContact {
    private String merchantUserName;
    private String platform;
    private String description;
}
