package com.kuponku.manager.adapter.input.user.data;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private String userName;
    private String email;
    private short role;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
