package com.tcs.attendance.controller;

import com.tcs.attendance.entity.User;
import com.tcs.attendance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "success";
    }

}
