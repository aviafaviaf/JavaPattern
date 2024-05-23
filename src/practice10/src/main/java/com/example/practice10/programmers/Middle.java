package com.example.practice10.programmers;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle coding...");
    }
}
