package com.alexura.baobao.web;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.DataService;
import com.alexura.baobao.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-20 10:21 PM
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    private static final String SESSION_KEY = "user";
    private static final String SESSION_UID_KEY = "userId";
    @Autowired
    private DataService dataService;
    @Autowired
    private UserService userService;
    private AtomicInteger atomicInteger = new AtomicInteger();

    @RequestMapping("/")
    public String index(HttpSession session, ModelMap model) {
        String account = (String) session.getAttribute(SESSION_KEY);
        model.addAttribute("name", account);
        model.addAttribute("actCnt", dataService.countAll());
        model.addAttribute("grpCnt", dataService.countAllGroup());
        model.addAttribute("userCnt", userService.countAll());
        model.addAttribute("dataList", dataService.listActivity());
        model.addAttribute("visitCnt", atomicInteger.incrementAndGet());
        return "index";
    }
    @RequestMapping("/act-list")
    public String index(ModelMap model, HttpSession session, @RequestParam(value = "grpName", required = false, defaultValue = "") String grpName) {
        String account = (String) session.getAttribute(SESSION_KEY);
        log.error("xuyifei debug name : " + grpName);
        UserEntity userEntity = userService.getUser(account);
        if (userEntity == null) {
            return "error";
        }
        List<String>communityList = dataService.getCommunityList();
        List<String>grpNameList = new ArrayList<>();
        if (StringUtils.isBlank(grpName)) {
            grpNameList = userService.getGrpNameList();
        } else {
            grpNameList.add(grpName);
        }
        model.addAttribute("communityList", communityList);
        model.addAttribute("grpName", grpName);
        model.addAttribute("grpNameList", grpNameList);
        return "act-list";
    }

    @RequestMapping("/feedback")
    public String feedback(ModelMap model, HttpSession session) {
        return "issues";
    }
}
