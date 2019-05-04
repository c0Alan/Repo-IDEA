package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.domain.Person;
import com.springboot.support.CustomRepository;

public interface PersonRepository extends CustomRepository<Person, Long> {
    /**
     * 使用方法名查询，接受一个name 参数，返回值为列表。
     * @param address
     * @return
     */
    List<Person> findByAddress(String address);

    /**
     * 使用方法名查询，接受name 和address ，返回值为单个对象。
     * @param name
     * @param address
     * @return
     */
    Person findByNameAndAddress(String name, String address);

    /**
     * 使用@Query 查询，参数按照名称绑定。
     * @param name
     * @param address
     * @return
     */
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    /**
     * 使用@NamedQuery 查询，请注意我们在实体类中做的@NamedQuery 的定义。
     * @param name
     * @param address
     * @return
     */
    Person withNameAndAddressNamedQuery(String name, String address);

}
