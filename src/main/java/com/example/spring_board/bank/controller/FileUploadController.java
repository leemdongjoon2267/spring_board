package com.example.spring_board.bank.controller;

import com.example.spring_board.bank.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("file/create")
    public String fileUpload(@RequestParam("files")MultipartFile file,
                             @RequestParam("user_email")String email) throws IOException {
        fileUploadService.fileSave(file, email);

        return "ok";
    }
}
