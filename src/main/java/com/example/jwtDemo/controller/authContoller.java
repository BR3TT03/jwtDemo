package com.example.jwtDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtDemo.model.userInfo;
import com.example.jwtDemo.service.AuthService;

@RestController 
@RequestMapping("/")
public class authContoller {
	@Autowired
	AuthService authService;
	@PostMapping("/auth")
	public String getUserInfo( @RequestBody userInfo UserInfo) {
		return authService.jwtCreate(UserInfo);
	}

}
