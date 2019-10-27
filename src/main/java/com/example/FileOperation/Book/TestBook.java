package com.example.FileOperation.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liyu
 * @description ${description}
 * @date 2019-10-27 19:27
 */
@Component
public class TestBook {

    @Autowired
    private Book book;

    @PostConstruct
    public void getBook(){
        System.out.println(book);
    }
}
