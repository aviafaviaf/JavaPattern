package com.example.practice10;

import com.example.practice10.programmers.Junior;
import com.example.practice10.programmers.Middle;
import com.example.practice10.programmers.Senior;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Practice10Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Junior junior = context.getBean(Junior.class);
        Middle middle = context.getBean(Middle.class);
        Senior senior = context.getBean(Senior.class);

        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
    }
}
