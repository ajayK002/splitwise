package com.splitwise.SplitWise.controllers;

import com.splitwise.SplitWise.dtos.RegisterUserRequestDto;
import com.splitwise.SplitWise.dtos.RegisterUserResponseDto;
import com.splitwise.SplitWise.dtos.ResponseStatus;
import com.splitwise.SplitWise.models.User;
import com.splitwise.SplitWise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    public RegisterUserResponseDto RegisterUser(RegisterUserRequestDto registerUserRequestDto) {
        User user = userService.RegisterUser(registerUserRequestDto);

        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUserId(user.getId());
        registerUserResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        return registerUserResponseDto;
    }
}
