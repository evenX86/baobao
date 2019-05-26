package com.alexura.baobao.web;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.DataService;
import com.alexura.baobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<Map<String, Object>> mapList = dataService.queryGroupNum();
        int id = 1;
        for (Map<String, Object> map : mapList) {
            map.put("id", id ++);
        }
        model.addAttribute("groupDataList",  mapList);
        return "index";
    }
    @RequestMapping("/act-detail")
    public String index(ModelMap model, HttpSession session) {
        String account = (String) session.getAttribute(SESSION_KEY);
        UserEntity userEntity = userService.getUser(account);
        if (userEntity == null) {
            return "error";
        }
        List<ActivityEntity> activityEntityList = new ArrayList<>();
        if ("admin".equals(account)) {
            activityEntityList = dataService.listActivity();
        } else {
            activityEntityList  = dataService.listActivity(userEntity.getGroupName());
        }
        model.addAttribute("dataList", activityEntityList);
        return "act-detail";
    }
}
