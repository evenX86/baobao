package com.alexura.baobao.web;

import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-14 5:13 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String save(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("userEntity", userEntity);
        return "user/add";

    }

    @PostMapping("/doAddUser")
    public String doAddUser(@ModelAttribute UserEntity userEntity) {
        userService.addUser(userEntity);
        return "redirect:/user/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<UserEntity> userEntityList = userService.listUser();
        model.addAttribute("dataList", userEntityList);
        return "user/list";
    }

    @RequestMapping("/edit")
    public String edit(String uid,String userName,String userTel,String passwd, Model model) {
        log.error("xuyifei debug account : " + uid);
        log.error("xuyifei debug account : " + userTel);
        log.error("xuyifei debug account : " + userName);
        log.error("xuyifei debug account : " + passwd);
        return list(model);
    }
}
