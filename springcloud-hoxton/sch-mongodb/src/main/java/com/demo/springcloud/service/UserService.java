package com.demo.springcloud.service;

import com.demo.springcloud.document.User;
import com.demo.springcloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // 新增
    public User saveUser(User user) {
        // 批量插入
        // List<User> users = new ArrayList<>();
        // users.add(...);
        // mongoTemplate.save(users, User.class);

        // 单个新增
        return mongoTemplate.save(user);
    }

    // 精确查询
    public User getUserById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    // 模糊查询
    public List<User> getUserByCondition(String name) {
        String param = (null == name) ? "" : name.trim();
        Criteria criteria = Criteria.where("name").regex(".*" + param + ".*");
        /** 上面正则匹配包含param的情况，
         下面是匹配以param为开头的情况*/
        //Criteria criteria = Criteria.where("name").regex("^" + param);
        Query query = new Query(criteria);
        List<User> result = mongoTemplate.find(query, User.class);
        return result;
    }

    // 模糊分页并排序查询
    public List<User> getUserByCondition(int pageNum, int pageSize) {
        // 创建各种查询条件
        Criteria criteria = new Criteria()
                .andOperator(
                        Criteria.where("age").gte(40),
                        Criteria.where("salary").gt(500)
                ).orOperator(
                        Criteria.where("name").regex("a"),
                        Criteria.where("name").regex("b")
                );

        // 创建查询对象
        Query query = new Query(criteria);

        // 并指定排序方式
        query.with(
                        Sort.by(
                                Sort.Order.desc("age"),
                                Sort.Order.asc("name")
                        )
                )
                // 分页处理
                .skip(pageNum * pageSize).limit(pageSize);
        List<User> result = mongoTemplate.find(query, User.class);
        return result;
    }

    // 全部查询
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 精确更新操作
    public void update(User user) {
        if (null == user) {
            return;
        }
        Criteria criteria = Criteria.where("id").is(user.getId());
        Query query = new Query(criteria);
        Update updateObj = new Update().set("age", user.getAge());
        mongoTemplate.updateFirst(query, updateObj, User.class);
    }

    // 批量更新操作
    /*public void update(User user) {
        if (null == user) {
            return;
        }
        Criteria criteria = Criteria.where("salary").gt(300);
        Query query = new Query(criteria);
        Update updateObj = new Update()
                .set("salary", 600)
                .set("deptName", "工程部");
        // 仅更新第一条
        mongoTemplate.updateFirst(query, updateObj, User.class);

        // 全部更新
        mongoTemplate.updateMulti(query, updateObj, User.class);
    }*/

    // 删除
    public void deleteUserById(String id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, User.class);

    }
}