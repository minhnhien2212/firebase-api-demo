package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/")
public class RestDemoController {
    @Autowired
    private FirebaseService firebaseService;

    @GetMapping("getUserDetails")
    public User getExample(@RequestHeader() String name) throws InterruptedException, ExecutionException {
        return new User(name, "hnlinhtkdddd@gmail.com");
    }

    @PostMapping("createUser")
    public String postExample(@RequestBody User user) throws InterruptedException, ExecutionException {
        return "Created User " + user.getName();
    }

    @PutMapping("updateUser")
    public String putExample(@RequestBody User user) throws InterruptedException, ExecutionException {
        return "Updated User" + user.getName();
    }

    @DeleteMapping("deleteUser")
    public String deleteExample(@RequestHeader String name) {
        return "Deleted User " + name;
    }

}
