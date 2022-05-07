package com.example.StorageApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class StorageController {

    @GetMapping("/storage")
    public String getText(
            @RequestParam(name = "name", required = false, defaultValue = "Admin") String name,
            Map<String, Object> model
    ){
        model.put("name", name);
        return "storage";
    }
}
