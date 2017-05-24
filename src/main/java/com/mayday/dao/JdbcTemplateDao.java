package com.mayday.dao;

import com.mayday.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by EricAi on 2017/5/22.
 */
@Repository
public class JdbcTemplateDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询用户
    public UserModel queryUser(Long id){
        String sql="select * from user_model where id=?";
        RowMapper <UserModel>mapper=new BeanPropertyRowMapper<UserModel>(UserModel.class);

        return jdbcTemplate.queryForObject(sql,mapper,id);

    }





}
