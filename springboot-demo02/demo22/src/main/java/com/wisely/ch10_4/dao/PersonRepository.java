package com.springboot.ch10_4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ch10_4.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
