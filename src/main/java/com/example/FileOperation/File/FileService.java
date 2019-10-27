package com.example.FileOperation.File;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author liyu
 * @description ${description}
 * @date 2019-10-25 00:09
 */
@Service
public class FileService {
    public void exportFile(HttpServletResponse response){
        String path1 = "/Users/liyu/Downloads/zplaxy.zip";
        String path2 = "/Users/liyu/Downloads/orderpool.zip";
        List<String> paths = new ArrayList<>();
        paths.add(path1);
        paths.add(path2);
        File file1 = new File(path1);
        File file2 = new File(path2);
        try{
            byte[] buffer = new byte[4096];
            OutputStream outputStream = response.getOutputStream();
//            FileOutputStream fos = new FileOutputStream("result.zip");
            ZipOutputStream zos = new ZipOutputStream(outputStream);
            for(String path : paths){
                FileInputStream fis = new FileInputStream(path);
                zos.putNextEntry(new ZipEntry("kk"));
                int length;
                while((length = fis.read(buffer)) > 0){
                    zos.write(buffer, 0, length);
                }
                zos.flush();
                zos.closeEntry();
                fis.close();
            }
            outputStream.flush();
            outputStream.close();
            zos.flush();
            zos.close();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
