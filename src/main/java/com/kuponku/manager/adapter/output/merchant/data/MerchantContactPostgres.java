package com.kuponku.manager.adapter.output.merchant.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Data
@Table("merchant-contact")
public class MerchantContactPostgres {
    @Id
    private BigInteger id;
    private BigInteger merchantId;
    private String platform;
    private String description;
}
