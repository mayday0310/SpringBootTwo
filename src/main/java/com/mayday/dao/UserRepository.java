package com.mayday.dao;

import com.mayday.model.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by EricAi on 2017/5/22.
 * 这是一个接口，主要实现了curdRepository接口
 */
public interface UserRepository  extends CrudRepository<UserModel,Long>{

}
