package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.service.SeedService;

@RestController
@CrossOrigin(allowedHeaders = "*", methods = RequestMethod.GET)
public class SeedController {

	@Autowired
	private SeedService seedService;

	@GetMapping("/seed")
	public String updateData() {
		
		return seedService.seedData();

	}

	public void setSeedService(SeedService seedService) {
		this.seedService = seedService;
	}
	
}
