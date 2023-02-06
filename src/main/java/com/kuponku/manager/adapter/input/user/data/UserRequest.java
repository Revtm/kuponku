package com.kuponku.manager.adapter.input.user.data;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserRequest {
    private BigInteger id;
    private String userName;
    private String email;
    private short role;
    private String password;
    private Boolean status;
}
