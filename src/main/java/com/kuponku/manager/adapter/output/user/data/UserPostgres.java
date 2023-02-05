package com.kuponku.manager.adapter.output.user.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Table("userdata")
public class UserPostgres {
    @Id
    private BigInteger id;
    private String userName;
    private String email;
    private short role;
    private String password;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
