package com.company.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by alt-hanny on 23.10.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.company.springmvc")
public class AppConfiguration {

}
