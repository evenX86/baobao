package com.alexura.baobao.service.impl;

import com.alexura.baobao.service.ImageUploadService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 10:32 PM
 */
@Service
public class ImageUploadServiceImpl implements ImageUploadService {
    private static final Logger log = LoggerFactory.getLogger(ImageUploadServiceImpl.class);

    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Override
    public String uploadImage(MultipartFile file, String uploadPath, String physicalUploadPath, Integer uid) {
        String newName = uid + "-"+ System.currentTimeMillis()+ "-" + new Random().nextInt(10) + ".jpeg";
        String filePath = uploadFolder + newName;
        try {
            File targetFile=new File(filePath);
            FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newName;
    }
}
