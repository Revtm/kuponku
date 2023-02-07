package com.kuponku.manager.application.port.input.merchant;

import com.kuponku.manager.application.port.output.MerchantContactDatabase;
import com.kuponku.manager.application.port.output.MerchantDatabase;
import com.kuponku.manager.application.usecase.CouponCommand;
import com.kuponku.manager.application.usecase.MerchantCommand;
import com.kuponku.manager.application.usecase.UserCommand;
import com.kuponku.manager.domain.entity.merchant.Merchant;
import com.kuponku.manager.domain.entity.merchant.MerchantContact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Component
@Slf4j
public class MerchantCommandImpl implements MerchantCommand {
    private final MerchantDatabase merchantDatabase;
    private final MerchantContactDatabase merchantContactDatabase;
    private final UserCommand userCommand;
    private final CouponCommand couponCommand;

    @Autowired
    public MerchantCommandImpl(MerchantDatabase merchantDatabase, MerchantContactDatabase merchantContactDatabase, UserCommand userCommand, CouponCommand couponCommand) {
        this.merchantDatabase = merchantDatabase;
        this.merchantContactDatabase = merchantContactDatabase;
        this.userCommand = userCommand;
        this.couponCommand = couponCommand;
    }

    @Override
    public Mono<Merchant> getMerchant(String userName) {
        return userCommand.getUser(userName)
                .flatMap(user -> merchantDatabase.findByUserAccountId(user.getId())
                        .flatMap(merchant -> {
                            merchant.setUser(user);
                            return Mono.just(merchant);
                        }))
                .flatMap(merchant -> couponCommand.getAllCoupon(merchant.getId())
                        .collectList()
                        .flatMap(couponList -> {
                            merchant.setCouponList(couponList);
                            return Mono.just(merchant);
                        }))
                .flatMap(merchant -> getMerchantContact(merchant.getId())
                        .collectList()
                        .flatMap(contactList -> {
                            merchant.setContact(contactList);
                            return Mono.just(merchant);
                        }));
    }

    @Override
    public Flux<MerchantContact> getMerchantContact(BigInteger merchantId) {
        return merchantContactDatabase.findAllByMerchantId(merchantId);
    }
}
