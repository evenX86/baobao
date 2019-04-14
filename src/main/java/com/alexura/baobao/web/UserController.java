package com.alexura.baobao.web;

import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-14 5:13 PM
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getAllUser")
    public List<UserEntity> getAllUser() {
        return userMapper.getAll();
    }
    @RequestMapping("/add")
    public void save(UserEntity user) {
        user = new UserEntity();
        user.setName("admin");
        user.setTel("1342");
        userMapper.insert(user);
    }
}
