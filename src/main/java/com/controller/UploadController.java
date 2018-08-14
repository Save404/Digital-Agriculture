package com.controller;

import com.result.Result;
import com.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(path = "/upload")
public class UploadController{

    @Value("${web.upload-path}")
    private String uploadDir;

    @Value("${web.host-name}")
    private String hostName;

    @Autowired
    UploadService service;

    @PostMapping(path = "/images")
    @ResponseBody
    public Result<List<String>> uploadImages(HttpServletRequest request){
        List<MultipartFile> list = ((MultipartHttpServletRequest)request).getFiles("images");
        List<String>urls = service.UploadFiles(uploadDir + "/images", list, hostName + "/images");
        return Result.success(urls);
    }
}
