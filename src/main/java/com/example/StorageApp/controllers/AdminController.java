package com.example.StorageApp.controllers;

import com.example.StorageApp.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserDAO userDAO;
    @Autowired
    public AdminController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String getUsers(Model model){
        model.addAttribute("users", userDAO.getUsers());
        return "admin/index";
    }
    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.getOneUser(id));
        return "admin/personInfo";
    }
    /*@GetMapping("/addUser")
    public String addUserPage(){
        return "addUser";
    }*/
    @GetMapping("/addUser")
    public String addUserPage(Model model){
        model.addAttribute("message", "");
        return "admin/addUser";
    }
    @PostMapping("/addUser")
    public String auth(
            @RequestParam String loginInput, @RequestParam String passInput, @RequestParam String roleInput, Model model
    ){
        String message = userDAO.addUser(loginInput, passInput, roleInput);
        model.addAttribute("message", message);
        return "admin/addUser";
    }

    /*List<User> listUser = new ArrayList<>();*/
    /*@GetMapping("/addUser")
    public String userAuthPage(Map<String, List<User>> model){
        model.put("users", listUser);
        return "storage";
    }
    @PostMapping("/addUser")
    public String auth(
            @RequestParam String loginInput, @RequestParam String passInput, @RequestParam String roleInput, Map<String, List<User>> model
    ){
        *//*User users = new User(loginInput, passInput, roleInput);
        if (users.getRole().equals(""))
            users.setRole("User");

        if (users.getPassword().equals(""))
            users.setPassword("pass");

        if (users.getLogin().equals(""))
            users.setLogin("Default");

        listUser.add(users);
        model.put("users", listUser);
        return "storage";*//*
        return null;
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
        return "/admin";
    }*/
}
