package com.kuponku.manager.adapter.input.merchant.data;

import lombok.Data;

import java.math.BigInteger;

@Data
public class MerchantContactResponse {
    private BigInteger id;
    private String platform;
    private String link;
}
