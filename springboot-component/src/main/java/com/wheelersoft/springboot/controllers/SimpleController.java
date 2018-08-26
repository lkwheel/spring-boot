package com.wheelersoft.springboot.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SimpleController {
    private static final String API_ROOT = "http://localhost:8090/status";

    @Value("${spring.application.name}")
    private String appName;
    private Response response;

    @GetMapping("/")
    public String homePage(Model model) {
        Response response = RestAssured.get(API_ROOT);
        model.addAttribute("appName", response.getBody());
        return "home";
    }
}
