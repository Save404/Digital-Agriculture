package com.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
    List<String> UploadFiles(String dir, List<MultipartFile>files, String prefix);
}
