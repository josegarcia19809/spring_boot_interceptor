package com.example.spring_boot_interceptor.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class TimeController {

    @GetMapping("/timer")
    public Map<String, String> timer() {
        return Collections.singletonMap("message", "Handler timer started");
    }

    @GetMapping("/timer_bar")
    public Map<String, String> timerBar() {
        return Collections.singletonMap("message", "Handler timerBar started");
    }

    @GetMapping("/timer_baz")
    public Map<String, String> timerBaz() {
        return Collections.singletonMap("message", "Handler timerBaz started");
    }
}
