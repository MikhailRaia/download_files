package com.test.download.service;

import com.test.download.entity.FileEntity;
import com.test.download.repository.FileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@Slf4j
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public void saveFile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileEntity fileEntity = new FileEntity(fileName, file.getContentType(), file.getBytes());
        fileRepository.save(fileEntity);
        log.info("File " + fileName + " saved");
    }
}

