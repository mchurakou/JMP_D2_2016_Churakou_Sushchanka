package com.company.springmvc.configuration;

import com.company.springmvc.interfaces.UserRepository;
import com.company.springmvc.model.beans.User;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


/**
 * Created by alt-hanny on 07.11.2016.
 */
public class DummyDataInitializer {
    private final UserRepository userRepository;

    @Inject
    public  DummyDataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Value("${spring.datasource.url}")
    private String databaseURI;

    @PostConstruct
    public void initDummyBeans() {
        List<User> users = userRepository.save(Arrays.asList(
                new User("Hanna", "Sushchanka", LocalDate.parse("1986-07-20",DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                new User("Yauhen", "Qwerty", LocalDate.parse("1988-09-07",DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        ));
    }
}
