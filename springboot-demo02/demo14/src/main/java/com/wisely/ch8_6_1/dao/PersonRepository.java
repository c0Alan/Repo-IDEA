package com.springboot.ch8_6_1.dao;

import com.springboot.ch8_6_1.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
	/**
	 * 支持方法名查询。
	 * @param name
	 * @return
	 */
	 Person findByName(String name);

	/**
	 * 支持 @Query 查询，查询参数构造JSON 字符串即可。
	 * @param age
	 * @return
	 */
	 @Query("{'age': ?0}")
	 List<Person> withQueryFindByAge(Integer age);

}
