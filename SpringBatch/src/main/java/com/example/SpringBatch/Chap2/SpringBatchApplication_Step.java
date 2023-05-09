package com.example.SpringBatch.Chap2;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchApplication_Step {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication_Step.class, args);
    }

}

