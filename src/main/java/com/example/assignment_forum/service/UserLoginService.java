package com.example.assignment_forum.service;

import com.example.assignment_forum.entity.UserEntity;
import com.example.assignment_forum.model.InputLoginModel;
import com.example.assignment_forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    public UserLoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String actionLogin(InputLoginModel loginModel){

        //Optional.ofNullable Optional객체로 포장해줌
        Optional<UserEntity> result = Optional.ofNullable(
                userRepository.findByUserIdAndUserPwd(loginModel.getLoginId(),
                        loginModel.getLoginPwd()));


        if(result.isEmpty()){
            //error
            System.out.println("error");
            return "";
        }
        ;
        //내용이 존재하면 내용을 프린트함
        return loginModel.getLoginId();


    }
}
