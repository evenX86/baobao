package com.alexura.baobao.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 10:32 PM
 */
public interface ImageUploadService {
    public String uploadImage(MultipartFile file, String uploadPath, String physicalUploadPath,Integer uid );
}

