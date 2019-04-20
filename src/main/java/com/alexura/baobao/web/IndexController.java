package com.alexura.baobao.web;

import com.alexura.baobao.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-20 10:21 PM
 */
@Controller
public class IndexController {
    private static final String SESSION_KEY = "user";
    @Autowired
    private DataService dataService;

    @RequestMapping("/")
    public String index(HttpSession session, ModelMap model) {
        String account = (String) session.getAttribute(SESSION_KEY);
        model.addAttribute("name", account);
        model.addAttribute("dataList", dataService.listActivity());
        return "index";
    }
    @RequestMapping("/act-detail")
    public String index(ModelMap model) {
        return "act-detail";
    }
}
