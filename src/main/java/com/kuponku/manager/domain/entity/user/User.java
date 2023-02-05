package com.kuponku.manager.domain.entity.user;


import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class User {
    private BigInteger id;
    private String userName;
    private String email;
    private short role;
    private String password;
    private String token;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
