package com.company.springmvc;

import com.company.springmvc.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by alt-hanny on 07.11.2016.
 */
@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);
    }
}
