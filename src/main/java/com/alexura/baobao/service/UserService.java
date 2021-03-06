package com.alexura.baobao.service;

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
    public List<UserEntity> listUser();
    public Long countAll();

    UserEntity getUserByAccount(Integer uid);

    UserEntity getUser(String account);

    UserEntity login(String account, String passwd);

    public void updateUser(UserEntity userEntity);

    void deleteUser(UserEntity entity);

    List<String> getGrpNameList();
}
