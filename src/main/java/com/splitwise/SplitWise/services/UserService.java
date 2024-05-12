package com.splitwise.SplitWise.services;

import com.splitwise.SplitWise.dtos.RegisterUserRequestDto;
import com.splitwise.SplitWise.models.User;
import com.splitwise.SplitWise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User RegisterUser(RegisterUserRequestDto registerUserRequestDto) {
        User newUser = new User();
        newUser.setName(registerUserRequestDto.getName());
        newUser.setMobileNumber(registerUserRequestDto.getMobileNumber());
        newUser.setPassword(registerUserRequestDto.getPassword());
        newUser.setCreatedAt(new Date());
        newUser.setLastUpdatedAt(new Date());

        return userRepository.save(newUser);
    }
}
