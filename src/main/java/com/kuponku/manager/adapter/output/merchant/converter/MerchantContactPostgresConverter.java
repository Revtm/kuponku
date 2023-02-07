package com.kuponku.manager.adapter.output.merchant.converter;

import com.kuponku.manager.adapter.output.merchant.data.MerchantContactPostgres;
import com.kuponku.manager.domain.entity.merchant.MerchantContact;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MerchantContactPostgresConverter {
    public Mono<MerchantContact> convertMerchantContactPostgresToDomain(MerchantContactPostgres contactPostgres){
        MerchantContact contact = new MerchantContact();
        contact.setId(contactPostgres.getId());
        contact.setPlatform(contactPostgres.getPlatform());
        contact.setLink(contactPostgres.getLink());

        return Mono.just(contact);
    }
}
