package com.kuponku.manager.adapter.output.merchant.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Data
@Table("merchant")
public class MerchantPostgres {
    @Id
    private BigInteger id;
    private BigInteger userAccountId;
    private String name;
    private String logo;
    private String description;
    private String address;
    private BigInteger follower;
}
