package com.prav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.service.BackEndService;

@RestController
public class BackEndController {

	@Autowired
	BackEndService backendService;
	
	@GetMapping("/")
	public String printName() {
		return backendService.printName();
	}
}
