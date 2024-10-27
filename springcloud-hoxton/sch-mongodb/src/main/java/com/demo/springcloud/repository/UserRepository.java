package com.demo.springcloud.repository;

import com.demo.springcloud.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
 
public interface UserRepository extends MongoRepository<User, String> {
 
    // 这里MongoRepository提供了基本的CRUD方法，也可以自定义查询方法
	
}