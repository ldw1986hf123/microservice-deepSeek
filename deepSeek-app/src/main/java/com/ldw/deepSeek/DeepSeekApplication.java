package com.ldw.deepSeek;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepSeekApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(DeepSeekApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
