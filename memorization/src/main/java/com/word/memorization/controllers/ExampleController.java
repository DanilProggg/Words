package com.word.memorization.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Тестовый эндпоинт")
public class ExampleController {
    @GetMapping
    @Operation(summary = "Проверка OAuth2")
    public String greeting(){
        return "Hello from memorization";
    }
}
