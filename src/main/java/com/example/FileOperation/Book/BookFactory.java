package com.example.FileOperation.Book;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author liyu
 * @description ${description}
 * @date 2019-10-27 19:23
 */
@Component
public class BookFactory implements FactoryBean<Book>, EnvironmentAware {

    private Environment env;

    @Override
    public Book getObject(){
        String type = env.getProperty("type");
        if("A".equals(type)){
            return new BookA();
        }
        return new BookB();
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
