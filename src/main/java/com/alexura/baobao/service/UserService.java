package com.alexura.baobao.service;

import com.alexura.baobao.domain.User;
import com.alexura.baobao.entity.UserEntity;

import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-18 11:38 PM
 */
public interface UserService {
    public void addUser(UserEntity userEntity);
    public void addUser(User user);
    public List<UserEntity> listUser();
}