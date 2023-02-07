package com.kuponku.manager.adapter.input.user.data;

import lombok.Data;

@Data
public class UserLoginResponse {
    private String userName;
    private String email;
    private short role;
    private String token;
    private Boolean status;
}
