package com.alexura.baobao.web;

import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.mapper.UserMapper;
import com.alexura.baobao.utils.JsonUtil;
import com.alibaba.druid.support.json.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getAllUser")
    public List<UserEntity> getAllUser() {
        return userMapper.getAll();
    }
    @RequestMapping("/add")
    public void save(UserEntity user) {

        log.error(JsonUtil.write2JsonStr(user));

        user = new UserEntity();

        user.setName("admin");
        user.setTel("1342");

        //userMapper.insert(user);
    }
}
