package com.alexura.baobao.service.impl;

import com.alexura.baobao.domain.User;
import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.UserService;
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


    @Override
    public void addUser(UserEntity userEntity) {
        int size = 1;
        if (userEntityList == null) {
            userEntityList = new ArrayList<>();
        } else {
            size = userEntityList.size();
        }
        userEntity.setId(size+1);
        userEntityList.add(userEntity);
    }

    @Override
    public void addUser(User user) {
        int size = userEntityList.size();
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setId(size+1);
        userEntityList.add(userEntity);
    }

    @Override
    public List<UserEntity> listUser() {
        return userEntityList;

    }
}