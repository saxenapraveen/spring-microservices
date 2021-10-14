package com.prav.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BackEndService {
	
	@Value("${my.name: Praveen}")
	private String myName;

	public String printName() {
		return ("Hello" + " " + myName);
	}
}
