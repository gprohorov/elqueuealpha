package com.med.elqueuealpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ElqueuealphaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElqueuealphaApplication.class, args);
    }

}
