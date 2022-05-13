package com.example.StorageApp.dao;

import com.example.StorageApp.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAO {
    private static int USERID_COUNT;
    List<User> user;

    {
        user = new ArrayList<>();

        user.add(new User(++USERID_COUNT, "Admin", "123", "Admin"));
        user.add(new User(++USERID_COUNT, "Tom", "123", "User"));
        user.add(new User(++USERID_COUNT, "Vova", "123", "User"));
        user.add(new User(++USERID_COUNT, "Vera", "123", "User"));
    }

    public List<User> getUsers(){
        return user;
    }

    public User getOneUser(int id){
        return user.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public String addUser(String login, String pass, String role){
        User people = new User();
        people.setLogin(login);
        people.setPassword(pass);
        people.setRole(role);
        if (people.getLogin().equals("") ||
                people.getPassword().equals("") ||
                people.getRole().equals("")){
            System.out.println("there is not enough data to fill the user");
            return "Fill in all fields";
        }
        people.setId(++USERID_COUNT);
        user.add(people);
        return "User added";
    }


}
