package com.example.FileOperation.File;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author liyu
 * @description ${description}
 * @date 2019-10-25 00:05
 */
@RequestMapping("file")
@RestController
public class FileController implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired


    private FileInfo fileInfo;

//    @Autowired
    public void setFileInfo(FileInfo fileInfo){
        System.out.println("set fileinfo ....");
        this.fileInfo = fileInfo;
    }


//    public FileController(FileInfo fileInfo) {
//        this.fileInfo = fileInfo;
//    }

    @GetMapping("/getBeans")
    public void getBean(){
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(item -> {
            System.out.println(item);
                }
        );
        System.out.println("=========");
       //here return "FileInfoImpl"
        System.out.println(applicationContext.getBean("generateFile").getClass());
        System.out.println("+++++");
        System.out.println(fileInfo.toString());
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }



    @Autowired
    private FileService fileService;


    @GetMapping("/export")
    public void exportFile(HttpServletResponse response){
        fileService.exportFile(response);
    }
}
