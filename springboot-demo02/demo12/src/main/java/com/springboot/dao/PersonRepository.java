package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
