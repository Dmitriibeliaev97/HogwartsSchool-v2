package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/getPort")
    public Integer getPort (){
        return 8080;
    }
}
