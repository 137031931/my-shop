package com.damiza.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传控制器
 */
@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/static/upload/";

    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropFile, MultipartFile editorFile,HttpServletRequest request) {
        Map<String,Object> result = new HashMap<>();

        MultipartFile myFile = dropFile == null ? editorFile : dropFile;
        //获取文件名
        String fileName = myFile.getOriginalFilename();

        //获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        File file = new File(filePath);

        //判断路径是否存在,如果存在创建文件夹
        if(!file.exists()){
            file.mkdir();
        }
        file = new File(filePath, UUID.randomUUID()+fileSuffix);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (dropFile != null){
            result.put("fileName",UPLOAD_PATH+file.getName());
        }
        else {

            /**
             * scheme:服务端提供的协议http/https
             * ServerName:服务器名称 localhost/ip/domain
             * serverPort:服务器端口
             */
            String serverPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();

            result.put("errno",0);
            result.put("data",new String[]{serverPath + UPLOAD_PATH + file.getName()});
        }

        return result;
    }
}
