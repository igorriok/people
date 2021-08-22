package com.example.people.services;

import com.example.people.dao.PeopleRepository;
import com.example.people.entities.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
	
	private static final Logger log = LoggerFactory.getLogger(PeopleService.class);
	private final PeopleRepository peopleRepository;
	
	
	@Autowired
	public PeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	
	public Page<Person> getPeople(Integer pageNo, Integer pageSize) {
		
		log.debug("Get people");
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		Page<Person> page = peopleRepository.findAll(pageable);
		
		log.info("Page: {}", page.toString());
		
		return page;
	}
	
	public Page<Person> getPeople(String name, Integer pageNo, Integer pageSize) {
		
		log.debug("Get people");
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		Page<Person> page = peopleRepository.findAllByFullName(name, pageable);
		
		log.info("Page: {}", page);
		
		return page;
	}
}
