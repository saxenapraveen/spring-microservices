package com.prav.frontend.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FrontEndService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getBackEndServiceData() {
		String backendResponse = restTemplate.getForObject("http://BACKEND-SERVICE/", String.class);
		return (backendResponse);
	}
}
