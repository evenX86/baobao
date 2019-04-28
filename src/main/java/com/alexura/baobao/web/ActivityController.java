package com.alexura.baobao.web;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.DataService;
import com.alexura.baobao.service.ImageUploadService;
import com.alexura.baobao.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

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
    @PostMapping("/saveActivity")
    public String saveActivity(@ModelAttribute ActivityEntity activityEntity, MultipartFile file1,
                               MultipartFile file2, MultipartFile file3, MultipartFile file4, HttpSession session) {
        if (StringUtils.isBlank(activityEntity.getActDate())) {
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
            String imageURL1 = imageUploadService.uploadImage( file1, uploadPath, path);
            activityEntity.setActImg1(imageURL1);
        }
        if (file2 != null && !file2.isEmpty()) {
            String imageURL2 = imageUploadService.uploadImage( file2, uploadPath, path);
            activityEntity.setActImg2(imageURL2);
        }
        if (file3 != null && !file3.isEmpty()) {
            String imageURL3 = imageUploadService.uploadImage( file3, uploadPath, path);
            activityEntity.setActImg3(imageURL3);
        }
        if (file4 != null && !file4.isEmpty()) {
            String imageURL4 = imageUploadService.uploadImage( file4, uploadPath, path);
            activityEntity.setActImg4(imageURL4);
        }
        dataService.addActivity(activityEntity);
        return "redirect:/act-detail";
    }
}
