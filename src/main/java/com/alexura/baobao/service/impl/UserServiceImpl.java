package com.alexura.baobao.service.impl;

import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.mapper.UserMapper;
import com.alexura.baobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-18 11:39 PM
 */
@Service
public class UserServiceImpl  implements UserService {
    public List<UserEntity> userEntityList;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserEntity userEntity) {
        int size = 1;
        if (userEntityList == null) {
            userEntityList = new ArrayList<>();
        } else {
            size = userEntityList.size();
        }
        userMapper.insert(userEntity);
        userEntity.setId(size + 1);
        userEntityList.add(userEntity);
    }

    @Override
    public List<UserEntity> listUser() {
        return userMapper.getAll();

    }

    @Override
    public Long countAll() {
        return userMapper.countAll();
    }

    @Override
    public UserEntity getUserByAccount(Integer id) {
        return userMapper.getUserByAccount(id);

    }
}
