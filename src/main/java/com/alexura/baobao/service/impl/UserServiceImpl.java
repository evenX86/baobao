package com.alexura.baobao.service.impl;

import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.mapper.UserMapper;
import com.alexura.baobao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-18 11:39 PM
 */
@Service
public class UserServiceImpl  implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserEntity userEntity) {
        UserEntity old = getUser(userEntity.getAccount());
        if (old != null) {
            return;
        }
        userMapper.insert(userEntity);
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

    @Override
    public UserEntity getUser(String account) {
        return userMapper.getUser(account);
    }


    @Override
    public UserEntity login(String account, String passwd) {
        return userMapper.getUserByAccountAndPasswd(account, passwd);

    }

    @Override
    public void updateUser(UserEntity userEntity) {

        userMapper.updateUser(userEntity);
    }

    @Override
    public void deleteUser(UserEntity entity) {
        userMapper.deleteUser(entity);

    }

    @Override
    public List<String> getGrpNameList() {
        return userMapper.getGrpNameList();
    }
}
