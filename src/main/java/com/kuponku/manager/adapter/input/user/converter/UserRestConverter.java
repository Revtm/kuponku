package com.kuponku.manager.adapter.input.user.converter;

import com.kuponku.manager.adapter.input.user.data.UserLoginRequest;
import com.kuponku.manager.adapter.input.user.data.UserLoginResponse;
import com.kuponku.manager.adapter.input.user.data.UserRequest;
import com.kuponku.manager.adapter.input.user.data.UserResponse;
import com.kuponku.manager.domain.entity.user.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserRestConverter {
    public Mono<User> convertUserLoginRequestToUserDomain(UserLoginRequest userLoginRequest){
        User user = new User();
        user.setUserName(userLoginRequest.getUserName().toLowerCase());
        user.setPassword(userLoginRequest.getPassword());
        return Mono.just(user);
    }

    public Mono<User> convertUserRequestToUserDomain(UserRequest userRequest){
        User user = new User();
        user.setUserName(userRequest.getUserName().toLowerCase());
        user.setEmail(userRequest.getEmail().toLowerCase());
        user.setRole(userRequest.getRole());
        user.setPassword(userRequest.getPassword());
        return Mono.just(user);
    }

    public Mono<UserResponse> convertUserToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setUserName(user.getUserName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setStatus(user.getStatus());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());

        return Mono.just(response);
    }

    public UserResponse convertUserDomainToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setUserName(user.getUserName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setStatus(user.getStatus());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());

        return response;
    }

    public Mono<UserLoginResponse> convertUserToUserLoginResponse(User user){
        UserLoginResponse response = new UserLoginResponse();
        response.setUserName(user.getUserName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setToken(user.getToken());
        response.setStatus(user.getStatus());

        return Mono.just(response);
    }
}
