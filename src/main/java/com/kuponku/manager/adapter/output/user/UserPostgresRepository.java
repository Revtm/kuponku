package com.kuponku.manager.adapter.output.user;

import com.kuponku.manager.adapter.output.user.data.UserPostgres;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface UserPostgresRepository extends R2dbcRepository<UserPostgres, BigInteger> {
    Mono<UserPostgres> findByUserName(String userName);
}
