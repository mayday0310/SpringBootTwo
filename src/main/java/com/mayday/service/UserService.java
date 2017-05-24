package com.mayday.service;

import com.mayday.dao.JdbcTemplateDao;
import com.mayday.dao.UserDao;
import com.mayday.dao.UserRepository;
import com.mayday.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by EricAi on 2017/5/22.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JdbcTemplateDao jdbcTemplateDao;

    //新增用户
    @Transactional  //申明事物控制
    public void addUser(UserModel userModel){
          userDao.addUser(userModel);
    }
   //通过jsbcTemlateDao查询学生
    public UserModel queryUser(Long id){
      return   jdbcTemplateDao.queryUser(id);

    }

}
