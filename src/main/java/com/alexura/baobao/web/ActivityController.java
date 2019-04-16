package com.alexura.baobao.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-15 11:06 PM
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("addActivity")
    public String add(Model model) {
        return "addActivity";
    }
}
