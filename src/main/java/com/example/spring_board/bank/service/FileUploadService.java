package com.example.spring_board.bank.service;

import com.example.spring_board.bank.domain.FileUpload;
import com.example.spring_board.bank.domain.User;
import com.example.spring_board.bank.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class FileUploadService {

    @Autowired
    FileUploadRepository fileUploadRepository;

    public void fileSave( MultipartFile file, String email) throws IOException {
//        서버의 디스크의 실제저장위치를 지정 : FileUploadTest
//        String  folder = "C:\\FileUploadTest\\"+email;
//        해당 폴더가 있는지 검사후, 없으면 폴더생성
        File folder = new File("C:\\FileUploadTest\\"+email);
        if(!folder.exists()){
            folder.mkdirs();
        }
        File uploadFolder = new File(folder, file.getOriginalFilename());
        file.transferTo(uploadFolder);
//        fileupload DB save
        FileUpload fileUpload =
        FileUpload.builder()
                        .file_path(uploadFolder.toString())
                .user((User) fileUploadRepository.findByEmail(email).orElse(null))
                                .build();
        fileUploadRepository.save(fileUpload);
//        고객정보 : upload여부
    }
}
