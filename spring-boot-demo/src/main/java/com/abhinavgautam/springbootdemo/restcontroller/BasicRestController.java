package com.abhinavgautam.springbootdemo.restcontroller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {
	@GetMapping("/")
	public String index() {
		return "Hello from Spring Boot Rest Controller. Time on server is - " + LocalDateTime.now();
	}
}
