package com.splitwise.SplitWise.commands;

import com.splitwise.SplitWise.controllers.UserController;
import com.splitwise.SplitWise.dtos.RegisterUserRequestDto;
import com.splitwise.SplitWise.dtos.RegisterUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command{

    @Autowired
    UserController userController;
    @Override
    public boolean matches(String inputs) {
        List<String> inputWords = List.of(inputs.split(" "));
        System.out.println(inputWords);
        return inputWords.get(0).equals("Register") &&
                inputWords.size()==4;
    }

    @Override
    public void execute(String inputs) throws Exception {
        List<String> inputWords = List.of(inputs.split(" "));

        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
        registerUserRequestDto.setName(inputWords.get(1));
        registerUserRequestDto.setMobileNumber(inputWords.get(2));
        registerUserRequestDto.setPassword(inputWords.get(3));

        RegisterUserResponseDto registerUserResponseDto = userController.RegisterUser(registerUserRequestDto);
        System.out.println("User registered with id : " + registerUserResponseDto.getUserId());
        System.out.println("With response status : " + registerUserResponseDto.getResponseStatus());
    }
}
