package com.company.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alt-hanny on 23.10.2016.
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap modelMap) {
        modelMap.addAttribute("greeting", "HelloWorld from SpringMVC 4");
        return "welcome";
    }
    @RequestMapping(value= "/helloAgain",method = RequestMethod.GET)
    public String sayHelloAgain (ModelMap modelMap) {
        modelMap.addAttribute("greeting", "Hello World Again, from Spring MVC 4");
        return "welcome";
    }
}
