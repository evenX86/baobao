package com.alexura.baobao.web;

import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.UserService;
import com.alexura.baobao.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-15 9:17 PM
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private static final String SESSION_KEY = "user";

    private static final String SESSION_UID_KEY = "userId";


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userEntity", new UserEntity());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute UserEntity userEntity, HttpSession session) {
        userService.addUser(userEntity);
        session.setAttribute(SESSION_KEY, userEntity.getAccount());
        session.setAttribute(SESSION_UID_KEY, userEntity.getId());
        return "redirect:/";
    }

    @PostMapping("/doLogin")
    public String doLogin(String account, String passwd, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        log.error("xuyifei debug account : " + account);
        log.error("xuyifei debug passwd : " + passwd);
        if (!"123456".equals(passwd)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return login();
        }
        // 设置session
        session.setAttribute(SESSION_KEY, account);
        session.setAttribute(SESSION_UID_KEY, 1);

        map.put("success", true);
        map.put("message", "登录成功");
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(SESSION_KEY);
        return "redirect:/login";
    }
}
