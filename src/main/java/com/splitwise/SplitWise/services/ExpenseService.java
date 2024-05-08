package com.splitwise.SplitWise.services;

import com.splitwise.SplitWise.dtos.SettleUpGroupResponseDto;
import com.splitwise.SplitWise.dtos.SettleUpUserResponseDto;
import com.splitwise.SplitWise.models.User;
import com.splitwise.SplitWise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    UserRepository userRepository;
    public SettleUpUserResponseDto settleUpUser(Long userId) throws Exception {

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new Exception();
        }

        User user = optionalUser.get();



        return null;
    }

    public SettleUpGroupResponseDto settleUpGroup(Long userId, Long groupId) {
        return null;
    }
}
