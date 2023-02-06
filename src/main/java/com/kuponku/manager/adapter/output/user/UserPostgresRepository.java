package com.kuponku.manager.adapter.output.user;

import com.kuponku.manager.adapter.output.user.data.UserPostgres;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface UserPostgresRepository extends ReactiveCrudRepository<UserPostgres, BigInteger> {
    Mono<UserPostgres> findByUserName(String userName);
    Mono<UserPostgres> findByUserNameOrEmail(String userName, String email);
}
