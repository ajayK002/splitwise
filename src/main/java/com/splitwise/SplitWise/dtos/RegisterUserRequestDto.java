package com.splitwise.SplitWise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String name;
    private String mobileNumber;
    private String password;
}
