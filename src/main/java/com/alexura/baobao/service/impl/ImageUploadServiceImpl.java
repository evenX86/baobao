package com.alexura.baobao.service.impl;

import com.alexura.baobao.service.ImageUploadService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 10:32 PM
 */
@Service
public class ImageUploadServiceImpl implements ImageUploadService {
    @Override
    public String uploadImage(MultipartFile file, String uploadPath, String physicalUploadPath) {
        String filePath = physicalUploadPath + file.getOriginalFilename();
        try {
            File targetFile=new File(filePath);
            FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadPath + "/" + file.getOriginalFilename();
    }
}
