package com.kuponku.manager.adapter.output.merchant.converter;

import com.kuponku.manager.adapter.output.merchant.data.MerchantPostgres;
import com.kuponku.manager.domain.entity.merchant.Merchant;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MerchantPostgresConverter {
    public Mono<Merchant> convertMerchantPostgresToMerchantDomain(MerchantPostgres merchantPostgres){
        Merchant merchant = new Merchant();
        merchant.setId(merchantPostgres.getId());
        merchant.setName(merchantPostgres.getName());
        merchant.setLogo(merchantPostgres.getLogo());
        merchant.setDescription(merchantPostgres.getDescription());
        merchant.setAddress(merchantPostgres.getAddress());
        merchant.setFollower(merchantPostgres.getFollower());
        merchant.setCreatedAt(merchantPostgres.getCreatedAt());
        merchant.setUpdatedAt(merchantPostgres.getUpdatedAt());

        return Mono.just(merchant);
    }
}
