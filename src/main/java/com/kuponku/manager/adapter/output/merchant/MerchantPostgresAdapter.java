package com.kuponku.manager.adapter.output.merchant;

import com.kuponku.manager.adapter.output.merchant.converter.MerchantPostgresConverter;
import com.kuponku.manager.application.port.output.MerchantDatabase;
import com.kuponku.manager.domain.entity.merchant.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Repository
public class MerchantPostgresAdapter implements MerchantDatabase {
    private final MerchantPostgresRepository merchantPostgresRepository;
    private final MerchantPostgresConverter merchantPostgresConverter;

    @Autowired
    public MerchantPostgresAdapter(MerchantPostgresRepository merchantPostgresRepository, MerchantPostgresConverter merchantPostgresConverter) {
        this.merchantPostgresRepository = merchantPostgresRepository;
        this.merchantPostgresConverter = merchantPostgresConverter;
    }

    @Override
    public Mono<Merchant> findByUserAccountId(BigInteger userAccountId) {
        return merchantPostgresRepository
                .findByUserAccountId(userAccountId)
                .flatMap(merchantPostgresConverter::convertMerchantPostgresToMerchantDomain);
    }
}
