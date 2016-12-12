package com.mycompany.model;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
    
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileUpload{" + "file=" + file + '}';
    }
    
    
    
}
