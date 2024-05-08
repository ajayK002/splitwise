package com.splitwise.SplitWise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
