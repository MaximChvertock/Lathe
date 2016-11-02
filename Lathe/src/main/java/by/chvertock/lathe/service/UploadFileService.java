/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service;

import by.chvertock.lathe.service.exceptions.EmptyFileException;
import by.chvertock.lathe.service.exceptions.UploadFileException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

@Component
public class UploadFileService {

    private static final Logger logger = Logger.getLogger(UploadFileService.class);


    @Value("${temp.directory}")
    private String tempDirName;

    public File uploadExcelFileToTemp(MultipartFile file) {

        String fileName = UUID.randomUUID().toString();

        return uploadFile(file, fileName, tempDirName);
    }

    public File uploadFile(MultipartFile file, String fileName, String destination) {

        try {
            validate(file);

            String fileExtension = getFileExtensionFromContentType(file.getContentType());
            if (!fileExtension.equalsIgnoreCase("vnd.ms-excel")) {
                throw new IllegalArgumentException("Wrong file extension '" + fileExtension + "'");
            }

            // file data
            byte[] bytes = file.getBytes();

            String path = destination + File.separator + fileName;
            File resultFile = new File(path);

            // create destination directory
            File destinationDir = new File(destination);
            if (!destinationDir.exists()) {
                destinationDir.mkdirs();
            }

            // write file data
            OutputStream out = new BufferedOutputStream(new FileOutputStream(resultFile));
            out.write(bytes);
            out.close();

            return resultFile;
        } catch (Exception e) {
            throw new UploadFileException("Can't upload file", e);
        }
    }

    private String getFileExtensionFromContentType(String contentType) {
        if (contentType == null) {
            return "";
        }

        String[] strings = contentType.split("/");

        if (strings == null || strings.length == 0) {
            return "";
        }

        return strings[strings.length - 1];
    }

    private void validate(MultipartFile file) {
        if (file == null) {
            throw new NullPointerException("File is null");
        }

        if (file.isEmpty()) {
            throw new EmptyFileException("File is empty");
        }
    }

}

