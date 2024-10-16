package com.ideafactory.valida.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/express")
public class ExpressController {

    @GetMapping
    public String express() {
        return "Hello from Express!";
    }
}
