package com.alexura.baobao.web;

import com.alexura.baobao.domain.Activity;
import com.alexura.baobao.service.DataService;
import com.alexura.baobao.service.ImageUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private ImageUploadService imageUploadService;

    @RequestMapping("addActivity")
    public String add(Model model, HttpSession session) {
        model.addAttribute("name", "admin");
        return "add-act";
    }
    @PostMapping("/saveActivity")
    public String saveActivity(String name, String addr, String num, String contacts, String tel, String desc, MultipartFile file1, String date) {
        // 服务器上上传文件的相对路径
        String uploadPath = "static/img/";
        // 服务器上上传文件的物理路径
        String path = getClass().getClassLoader().getResource(uploadPath).getPath();
        String imageURL = imageUploadService.uploadImage( file1, uploadPath, path);
        imageURL = "http://localhost:8080/"+imageURL;
        Activity activity = new Activity(name,addr, num, contacts,tel, desc, imageURL, date);
        dataService.addActivity(activity);
        return "redirect:/index";
    }
}
