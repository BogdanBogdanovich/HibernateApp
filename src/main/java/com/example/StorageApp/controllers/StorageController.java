package com.example.StorageApp.controllers;

import com.example.StorageApp.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller()
public class StorageController {
    List<User> listUser = new ArrayList<>();
    @GetMapping("/main")
    public String main(
            @RequestParam(name = "name", required = false, defaultValue = "Admin") String name,
            Map<String, Object> model
    ){
        model.put("name", name);
        return "main";
    }
    @GetMapping("/addUser")
    public String userAuthPage(Map<String, List<User>> model){
        model.put("users", listUser);
        return "storage";
    }
    @PostMapping("/addUser")
    public String auth(
            @RequestParam String loginInput, @RequestParam String passInput, @RequestParam String roleInput, Map<String, List<User>> model
    ){
        User users = new User(loginInput, passInput, roleInput);
        if (users.getRole().equals(""))
            users.setRole("User");

        if (users.getPassword().equals(""))
            users.setPassword("pass");

        if (users.getLogin().equals(""))
            users.setLogin("Default");

        listUser.add(users);
        model.put("users", listUser);
        return "storage";
    }

    @GetMapping("/admin")
    public String adminPage(Map<String, List<User>> model){
        model.put("users", listUser);
        return "adminPage";
    }
    @GetMapping("/deleteUser")
    public String deleteUser(){
        if (listUser != null)
            listUser.clear();
        return "/addUser";
    }
}
