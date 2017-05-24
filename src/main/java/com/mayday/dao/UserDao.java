package com.mayday.dao;

import com.mayday.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by EricAi on 2017/5/22.
 */

@Repository
public class UserDao {

    @Resource
    private UserRepository userRepository;

    public void addUser(UserModel userModel){
        userRepository.save(userModel);
    }

    public void login(UserModel userModel){


    }

}
