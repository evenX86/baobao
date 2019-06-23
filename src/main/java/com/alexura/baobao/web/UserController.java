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

import javax.servlet.http.HttpSession;
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
    public ResponseEntity<?> edit(String uid, String userName, String userTel, String passwd, String community1,String community2) {
        Map<String, Object> result = new HashMap<>();
        if (!StringUtils.isNumeric(uid)) {
            result.put("success",false);
            result.put("msg", "用户数据异常");
            return ResponseEntity.ok(result);
        }
        Integer uuid = Integer.valueOf(uid);
        try {
            UserEntity oldUserEntity =  userService.getUserByAccount(uuid);
            result.put("success", true);
            result.put("uid", uid);
            result.put("userName", userName);
            result.put("userTel", userTel);
            if (oldUserEntity == null) {
                result.put("success", false);
                result.put("msg", "用户不存在");
                log.error("用户不存在: " + uid);
                return ResponseEntity.ok(result);
            }
            UserEntity entity = new UserEntity();
            entity.setId(uuid);
            entity.setUserName(userName);
            entity.setUserTel(userTel);
            entity.setPasswd(passwd);
            entity.setCommunity1(community1);
            entity.setCommunity2(community2);
            userService.updateUser(entity);
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "系统异常");
            log.error("修改用户信息异常", e);
        }

        return ResponseEntity.ok(result);
    }


    @ResponseBody
    @RequestMapping("/del")
    public ResponseEntity<?> del(String uid, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        if (!StringUtils.isNumeric(uid)) {
            result.put("success",false);
            result.put("msg", "用户数据异常");
            return ResponseEntity.ok(result);
        }
        Integer uuid = Integer.valueOf(uid);
        try {
            UserEntity oldUserEntity =  userService.getUserByAccount(uuid);
            result.put("success", true);
            result.put("uid", uid);
            if (oldUserEntity == null) {
                result.put("success", false);
                result.put("msg", "用户不存在");
                log.error("用户不存在: " + uid);
                return ResponseEntity.ok(result);
            }
            UserEntity entity = new UserEntity();
            entity.setId(uuid);
            userService.deleteUser(entity);
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "系统异常");
            log.error("修改用户信息异常", e);
        }

        return ResponseEntity.ok(result);
    }
}
