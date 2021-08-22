package com.example.people.dao;

import com.example.people.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeopleRepository extends PagingAndSortingRepository<Person, Integer> {
	
	Page<Person> findAll(Pageable pageable);
	
	Page<Person> findAllByFullName(String name, Pageable pageable);

}
