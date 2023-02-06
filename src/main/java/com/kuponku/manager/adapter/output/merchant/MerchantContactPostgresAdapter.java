package com.kuponku.manager.adapter.output.merchant;

import com.kuponku.manager.adapter.output.merchant.converter.MerchantContactPostgresConverter;
import com.kuponku.manager.application.port.output.MerchantContactDatabase;
import com.kuponku.manager.domain.entity.merchant.MerchantContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

@Repository
public class MerchantContactPostgresAdapter implements MerchantContactDatabase {
    private final MerchantContactPostgresRepository merchantContactPostgresRepository;
    private final MerchantContactPostgresConverter merchantContactPostgresConverter;

    @Autowired
    public MerchantContactPostgresAdapter(MerchantContactPostgresRepository merchantContactPostgresRepository, MerchantContactPostgresConverter merchantContactPostgresConverter) {
        this.merchantContactPostgresRepository = merchantContactPostgresRepository;
        this.merchantContactPostgresConverter = merchantContactPostgresConverter;
    }

    @Override
    public Flux<MerchantContact> findAllByMerchantId(BigInteger merchantId) {
        return merchantContactPostgresRepository.findAllByMerchantId(merchantId)
                .flatMap(merchantContactPostgresConverter::convertMerchantContactPostgresToDomain);
    }
}
