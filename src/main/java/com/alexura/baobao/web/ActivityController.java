package com.alexura.baobao.web;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.DataService;
import com.alexura.baobao.service.ImageUploadService;
import com.alexura.baobao.service.UserService;
import com.alexura.baobao.utils.ExcelUtils;
import com.alexura.baobao.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    @Autowired
    private DataService dataService;
    @Autowired
    private UserService userService;

    @Autowired
    private ImageUploadService imageUploadService;

    private static final String SESSION_KEY = "user";
    private static final String SESSION_UID_KEY = "userId";

    @RequestMapping("addActivity")
    public String add(Model model, HttpSession session) {
        Integer uid = (Integer) session.getAttribute(SESSION_UID_KEY);
        UserEntity entity =  userService.getUserByAccount(uid);
        ActivityEntity activityEntity = new ActivityEntity();
        if (entity == null) {
            activityEntity.setGroupName("默认社团");
        } else {
            activityEntity.setGroupName(entity.getGroupName());
            if (StringUtils.isBlank(entity.getGroupName())) {
                activityEntity.setGroupName("默认社团");
            }
        }
        model.addAttribute("activity", activityEntity);
        model.addAttribute("groupName", activityEntity.getGroupName());
        return "add-act";
    }

    @RequestMapping("exportActivity")
    public void export(HttpServletResponse response, HttpSession session) {
        List<ActivityEntity> activityEntityList = dataService.listActivity();
        LocalDateTime localDateTime = LocalDateTime.now();
        String datetime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        ExcelUtils.exportExcel(activityEntityList, "社团活动信息","活动", ActivityEntity.class, "活动记录"+datetime+".xls", response);
    }


    @PostMapping("/saveActivity")
    public String saveActivity(@ModelAttribute ActivityEntity activityEntity, MultipartFile file1,
                               MultipartFile file2, MultipartFile file3, MultipartFile file4, HttpSession session) {
        if (activityEntity.getActDate() == null) {
            return "redirect:/add-act";
        }
        Integer uid = (Integer) session.getAttribute(SESSION_UID_KEY);
        UserEntity entity =  userService.getUserByAccount(uid);
        activityEntity.setGroupName(StringUtils.isBlank(entity.getGroupName())?"默认社团":entity.getGroupName());
        // 服务器上上传文件的相对路径
        String uploadPath = "static/img";
        // 服务器上上传文件的物理路径
        String path = getClass().getClassLoader().getResource(uploadPath).getPath();
        if (file1 != null && !file1.isEmpty()) {
            String imageURL1 = imageUploadService.uploadImage( file1, uploadPath, path, entity.getId());
            activityEntity.setActImg1(imageURL1);
        }
        if (file2 != null && !file2.isEmpty()) {
            String imageURL2 = imageUploadService.uploadImage( file2, uploadPath, path, entity.getId());
            activityEntity.setActImg2(imageURL2);
        }
        if (file3 != null && !file3.isEmpty()) {
            String imageURL3 = imageUploadService.uploadImage( file3, uploadPath, path, entity.getId());
            activityEntity.setActImg3(imageURL3);
        }
        if (file4 != null && !file4.isEmpty()) {
            String imageURL4 = imageUploadService.uploadImage( file4, uploadPath, path, entity.getId());
            activityEntity.setActImg4(imageURL4);
        }
        dataService.addActivity(activityEntity);
        return "redirect:/act-detail";
    }
    @PostMapping("/activityData")
    @ResponseBody
    public ResponseEntity<?> activityData() {
        List<ActivityEntity> activityEntityList = dataService.listActivity();
        List<String> dateList = new ArrayList<>(30);
        List<Integer> actList = new ArrayList<>(30);
        List<Integer> groupList = new ArrayList<>(30);
        Map<String, Map<String, Integer>> numMap = new HashMap<>();
        for (ActivityEntity activityEntity : activityEntityList) {
            String actDate = activityEntity.getActDate();
            actDate = actDate.replace(" 00:00:00","");
            if (numMap.containsKey(actDate)) {
                Map<String,Integer> tmpMap = numMap.get(actDate);
                tmpMap.put("act", tmpMap.get("act")+1);
                tmpMap.put("grp", tmpMap.get("grp")+1);
            } else {
                Map<String,Integer> tmpMap = new HashMap<>();
                tmpMap.put("act", 1);
                tmpMap.put("grp", 1);
                numMap.put(actDate, tmpMap);
            }
        }
        for (int i=30;i>0;i--) {
            Date date = DateUtils.addDays(new Date(), -i);
            String dateWithFormat = DateFormatUtils.format(date, "yyyy-MM-dd");
            dateList.add(dateWithFormat);
            if (numMap.containsKey(dateWithFormat)) {
                actList.add(numMap.get(dateWithFormat).get("act"));
                groupList.add(numMap.get(dateWithFormat).get("grp"));
            } else {
                actList.add(0);
                groupList.add(0);
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("date", dateList);
        result.put("act", actList);
        result.put("grp", groupList);
        return ResponseEntity.ok(result);
    }
}
