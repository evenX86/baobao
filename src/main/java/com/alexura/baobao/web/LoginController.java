package com.alexura.baobao.web;

import com.alexura.baobao.config.AuthInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-15 9:17 PM
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/index")
    public String index(ModelMap model) {
        log.error("request index");
        model.addAttribute("name", "xuyifei3");
        return "index";

    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
