package com.springboot.ch8_3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springboot.ch8_3.domain.Person;

//	http://localhost:8080/api/people
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

//	http://localhost:8080/api/people/search/nameStartsWith?name=汪
//	http://localhost:8080/api/people?page=0&size=9&sort=age,desc
	@RestResource(path = "nameStartsWith", rel = "nameStartsWith")
	Person findByNameStartsWith(@Param("name")String name);

}
