package com.example.netflix.dto;

import com.example.netflix.enums.MembershipType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String userName;
    private String email;
    private String password;
    private boolean premium;
    private MembershipType membershipType;
}
