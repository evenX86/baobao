package com.alexura.baobao.web;

import com.alexura.baobao.service.DataService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DataService dataService;
    private static final String SESSION_KEY = "user";
    @RequestMapping("/index")
    public String index(HttpSession session, ModelMap model) {
        if(session == null || session.getAttribute(SESSION_KEY) == null) {
            return login();
        }
        String account = (String) session.getAttribute(SESSION_KEY);
        model.addAttribute("name", account);
        model.addAttribute("dataList", dataService.listActivity());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
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

        map.put("success", true);
        map.put("message", "登录成功");
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(SESSION_KEY);
        return "redirect:/login";
    }
}
