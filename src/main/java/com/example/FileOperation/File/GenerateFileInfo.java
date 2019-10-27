package com.example.FileOperation.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyu
 * @description ${description}
 * @date 2019-10-27 13:57
 */
@Configuration
public class GenerateFileInfo {

    @Bean
    public FileInfo generateFile(){
        FileInfo fileInfo = new FileInfoImpl();
        System.out.println(fileInfo);
        return fileInfo;
    }
}
