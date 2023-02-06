package com.kuponku.manager.adapter.input.user.data;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String userName;
    private String password;
}
