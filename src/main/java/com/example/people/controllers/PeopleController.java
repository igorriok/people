package com.example.people.controllers;

import com.example.people.entities.Person;
import com.example.people.services.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@CrossOrigin
public class PeopleController {
	
	private static final Logger log = LoggerFactory.getLogger(PeopleController.class);
	private final PeopleService peopleService;
	
	
	@Autowired
	public PeopleController(PeopleService peopleService) {
		this.peopleService = peopleService;
	}
	
	
	@GetMapping(value = "/getallpeople")
	public ResponseEntity<Page<Person>> getAllPeople(@Param("fullname") String fullname, Pageable pageable) {
		
		log.info("Get all people");
		
		return ResponseEntity.ok(peopleService.getAllPeople(fullname, pageable));
	}
}
