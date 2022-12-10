package com.example.assignment_forum.service;

import com.example.assignment_forum.entity.UserEntity;
import com.example.assignment_forum.model.InputUserRegisterModel;
import com.example.assignment_forum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserRegisterService {
    private UserRepository userRepository;

    public String isExistUser(InputUserRegisterModel registerModel){

        //Optional.ofNullable Optional객체로 포장해줌
        Optional<UserEntity> result = Optional.ofNullable(
                userRepository.findByUserId(registerModel.getUserId()));

        //존재할 경우 -> userRegister로 넘어감(alert)
        if(result.isPresent()){
            return "true";
        }
        //존재하지 않을 경우 -> actionUserRegister로 넘어감
        return "false";
    }

    public void actionUserRegister(InputUserRegisterModel registerModel){

        UserEntity userEntity = UserEntity.builder()
                .userId(registerModel.getUserId())
                .userPwd(registerModel.getUserPwd())
                .userEmail(registerModel.getUserEmail())
                .userPhone(registerModel.getUserPhone())
                .build();

        userRepository.save(userEntity);
    }
}
