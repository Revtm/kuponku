package com.kuponku.manager.adapter.output.merchant.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Table("merchant_contact")
public class MerchantContactPostgres {
    @Id
    private BigInteger id;
    private BigInteger merchantId;
    private String platform;
    private String link;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
