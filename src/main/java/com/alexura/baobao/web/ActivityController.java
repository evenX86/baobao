package com.alexura.baobao.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public String add(Model model, HttpSession session) {
        model.addAttribute("name", "admin");
        return "add-act";
    }
    @PostMapping("/saveActivity")
    public String saveActivity(String name, String addr, String num, String contacts, String tel, String desc, String file1
            , String file2, String file3, String file4, HttpSession session) {
        log.error("xuyifei debug name" + name);
        log.error("xuyifei debug name" + addr);
        log.error("xuyifei debug name" + num);
        log.error("xuyifei debug name" + contacts);
        log.error("xuyifei debug name" + tel);
        log.error("xuyifei debug name" + desc);
        log.error("xuyifei debug name" + file1);
        log.error("xuyifei debug name" + file2);
        log.error("xuyifei debug name" + file3);
        log.error("xuyifei debug name" + file4);
        return "redirect:/index";
    }
}
