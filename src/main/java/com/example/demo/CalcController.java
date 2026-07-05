package com.example.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalcController {
    
    //GET = add
    //POST = sub
    //PUT = mul
    //DELETE = div

    @GetMapping("/calc")
    public int add(@RequestParam(value="a") int a, @RequestParam(value = "b") int b) {
        return (a + b);
    }

    @PostMapping("/calc")
    public int sub(@RequestBody Map<String, Integer> request) {
        int a = request.get("a");
        int b = request.get("b");
        return (a - b);
    }

    @PutMapping("/calc")
    public int mul(@RequestBody Map<String, Integer> request) {
        int a = request.get("a");
        int b = request.get("b");
        return (a * b);
    }

    @DeleteMapping("/calc")
    public int div(@RequestBody Map<String, Integer> request) {
        int a = request.get("a");
        int b = request.get("b");
        return (a / b);
    }

}
