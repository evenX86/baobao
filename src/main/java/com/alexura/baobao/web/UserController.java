package com.alexura.baobao.web;

import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping("/edit")
    public ResponseEntity<?> edit(String uid, String userName, String userTel, String passwd, Model model) {
        Integer uuid = Integer.valueOf(uid);
        UserEntity userEntity =  userService.getUserByAccount(uuid);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("uid", uid);
        result.put("userName", userName);
        result.put("userTel", userTel);
        if (userEntity == null) {
            result.put("success", false);
            log.error("用户不存在: " + uid);
        }
        return ResponseEntity.ok(result);
    }
}
