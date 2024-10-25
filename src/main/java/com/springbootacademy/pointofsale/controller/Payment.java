package com.springbootacademy.pointofsale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("v1/api/payment")
public class Payment {
    @GetMapping("firstname")
    public String print() {
        String name = "Dhananjaya";
        System.out.println("Dhananjaya");
        return name;
    }

    @GetMapping("/lastname")
    public String lastname() {
        String name = "Madhusankha";
//        System.out.println("Madhusankha");
        return name;
    }
}
