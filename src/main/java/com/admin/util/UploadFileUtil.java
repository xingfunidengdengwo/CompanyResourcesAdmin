package com.admin.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.admin.config.Config.STATIC_DRI;

public class UploadFileUtil {
//    private static final String UPLOAD_DRI="D:\\uploadfile\\";


    static {
        File file=new File(STATIC_DRI);
        if(!file.exists()) {
            file.mkdirs();
        }
    }

    public static String uploadfile(MultipartFile file) {
        //生成一个新的文件名
        String fileName=file.getOriginalFilename();//获取上传文件的原文件名
        String lastName=fileName.substring(fileName.lastIndexOf("."));//获取文件后缀名
        String newName=UUID.randomUUID()+lastName;
        //将file文件保存到UPLOAD_DRI路径中
        File newFile=new File(STATIC_DRI+newName);//D:\\uploadfile\\XXX.jpg
        try {
            file.transferTo(newFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回文件路径以及文件名
        return newName;

    }

}