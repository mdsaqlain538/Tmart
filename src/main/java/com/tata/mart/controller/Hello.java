package com.tata.mart.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("htttp://localhost:4200")
public class Hello {
	@PostMapping("api/hello")
	  public String hello() {
	    StringBuilder message = new StringBuilder("Hello Google App Engine!");
	    try {
	      InetAddress ip = InetAddress.getLocalHost();
	      message.append(" From host: " + ip);
	    } catch (UnknownHostException e) {
	      e.printStackTrace();
	    }
	      return message.toString();
	    }
}
