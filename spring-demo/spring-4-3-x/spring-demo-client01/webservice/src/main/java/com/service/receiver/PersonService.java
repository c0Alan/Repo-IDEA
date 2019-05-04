package com.service.receiver;

import com.service.model.Person;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * 类名称：PersonService.java<br>
 * 类描述：<br>
 * 创建时间：2016年11月11日, 下午2:43:36
 * 
 * @version 1.0 
 * @since JDK版本
 * @author flx 
 */

@WebService
public interface PersonService {

		public List<Person> findAll(@WebParam(name = "arg0") String name);

}