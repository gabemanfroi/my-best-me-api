package com.example.mybestme;

import com.example.mybestme.domain.interfaces.services.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBestMeApplication {

    @Autowired
    private LearningResourceService learningResourceService;

    public static void main(String[] args) {
        SpringApplication.run(MyBestMeApplication.class, args);
    }


}
