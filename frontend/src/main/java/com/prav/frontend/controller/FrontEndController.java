package com.prav.frontend.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.frontend.service.FrontEndService;

@RestController
public class FrontEndController {
	
	@Autowired
	private FrontEndService frontendService;
	
	@GetMapping("/")
	public String getData() {
		String backendServiceResp = frontendService.getBackEndServiceData();
				
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
		df.setTimeZone(TimeZone.getDefault());
		return (df.format(date) + " " + backendServiceResp);
	}
	
}
