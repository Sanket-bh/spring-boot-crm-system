package org.example.employee.controller;


import org.example.employee.model.User;
import org.example.employee.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @GetMapping
    public String userSecurity(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h1>My First Heading</h1>\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
    @GetMapping("public/about")
    public String about(){
        return "About public page";
    }
    @PostMapping("admin/register")
    public User createUser(@RequestBody User user){
        return customUserDetailsService.createUser(user);
    }
}