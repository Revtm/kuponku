package com.kuponku.manager.adapter.input.user.converter;

import com.kuponku.manager.adapter.input.user.data.UserRequest;
import com.kuponku.manager.domain.entity.user.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserRestConverter {
    public Mono<User> convertUserRequestToUserDomain(UserRequest userRequest){
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        return Mono.just(user);
    }
}
