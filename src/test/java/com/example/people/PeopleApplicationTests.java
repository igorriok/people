package com.example.people;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.people.controllers.PeopleController;
import com.example.people.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.logging.Logger;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PeopleApplicationTests {
	
	@Autowired
	private PeopleController controller;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	void getAllPeople() throws Exception {
		
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getpeople?page=0&size=10", Object.class)).isNotNull();
	}
	
}
