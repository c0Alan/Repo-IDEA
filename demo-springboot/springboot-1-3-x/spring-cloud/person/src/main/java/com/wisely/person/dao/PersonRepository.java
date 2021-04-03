package com.springboot.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
