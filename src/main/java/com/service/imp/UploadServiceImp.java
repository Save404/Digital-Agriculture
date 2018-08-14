package com.service.imp;

import com.common.commonUtils.StringUtils;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UploadServiceImp implements UploadService{

    public List<String> UploadFiles(String dir, List<MultipartFile>files, String prefix){
        //初始化文件目录
        File folder = new File(dir);
        if (folder.exists() == false){
            folder.mkdirs();
        }
        List<String>list = new ArrayList<String>();

        for (MultipartFile file: files){
            String fileName = file.getOriginalFilename();
            if (StringUtils.isEmpty(fileName)){
                continue;
            }
            //生成新的文件名
            String finalFileName = new Date().getTime() + Math.round(Math.random() * 1000) + fileName;
            File newFile = new File(dir + "/" +finalFileName);
            try{
                file.transferTo(newFile);
            }catch (Exception e){
                e.printStackTrace();
                throw new GlobalException(CodeMsg.FILE_UPLOAD_ERROR);
            }
            list.add(prefix + "/" + finalFileName);
        }
        return list;
    }
}
