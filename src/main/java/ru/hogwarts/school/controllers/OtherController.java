package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.services.impl.OtherServiceImpl;

@RestController
@RequestMapping("/other")
public class OtherController {

    private final OtherServiceImpl otherService;

    public OtherController(OtherServiceImpl otherService) {
        this.otherService = otherService;
    }

    @GetMapping
    public Integer getInteger() throws InterruptedException {
        return otherService.getInteger();
    }
}
