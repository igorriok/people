package com.example.people.controllers;

import com.example.people.entities.Person;
import com.example.people.services.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@CrossOrigin
public class PeopleController {
	
	private static final Logger log = LoggerFactory.getLogger(PeopleController.class);
	private final PeopleService peopleService;
	
	
	@Autowired
	public PeopleController(PeopleService peopleService) {
		this.peopleService = peopleService;
	}
	
	
	@GetMapping(value = "/getpeople")
	public ResponseEntity<Page<Person>> getPeople(
			@RequestParam(name="name", required = false) String fullname,
			@RequestParam("page") Integer pageNo,
			@RequestParam("size") Integer pageSize) {
		
		log.info("Get people with name: {}, pageNo: {}, pageSize: {}", fullname, pageNo, pageSize);
		
		if (fullname == null) {
			fullname = "";
		}
		
		return ResponseEntity.ok(peopleService.getPage(fullname, pageNo, pageSize));
	}
}
