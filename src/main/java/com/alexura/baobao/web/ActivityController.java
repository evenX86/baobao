package com.alexura.baobao.web;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.service.DataService;
import com.alexura.baobao.service.ImageUploadService;
import com.alexura.baobao.service.UserService;
import com.alexura.baobao.utils.JsonUtil;
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
        if(session == null || session.getAttribute(SESSION_KEY) == null) {
            return "login";
        }
        Integer uid = Integer.valueOf((String) session.getAttribute(SESSION_UID_KEY));
        model.addAttribute("name", session.getAttribute(SESSION_KEY));
        UserEntity entity =  userService.getUserByAccount(uid);
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setGroupName(entity.getGroupName());
        model.addAttribute("activity", activityEntity);
        return "add-act";
    }
    @PostMapping("/saveActivity")
    public String saveActivity(@ModelAttribute ActivityEntity activityEntity, MultipartFile file1,
                               MultipartFile file2, MultipartFile file3, MultipartFile file4) {

        log.error("xuyifei debug activity : " + JsonUtil.write2JsonStr(activityEntity));
        // 服务器上上传文件的相对路径
        String uploadPath = "static/img";
        // 服务器上上传文件的物理路径
        String path = getClass().getClassLoader().getResource(uploadPath).getPath();
        log.error("xuyifei debug path : " + path);
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
        log.error("xuyifei debug activityEntity : " + JsonUtil.write2JsonStr(activityEntity));
        dataService.addActivity(activityEntity);
        return "redirect:/act-detail";
    }
}
