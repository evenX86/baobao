package com.alexura.baobao.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @RequestMapping("/index")
    public String index(@SessionAttribute(SESSION_KEY) String account, ModelMap model) {
        log.error("request index");
        model.addAttribute("name", account);
        return "index";

    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/doLogin")
    public @ResponseBody Map<String, Object> doLogin(String account, String passwd, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        log.error("xuyifei debug account : " + account);
        log.error("xuyifei debug passwd : " + passwd);
        if (!"123456".equals(passwd)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }

        // 设置session
        session.setAttribute(SESSION_KEY, account);

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }
}
