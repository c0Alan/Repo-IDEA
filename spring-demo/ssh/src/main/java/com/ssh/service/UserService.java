package com.ssh.service;

import com.ssh.entity.TUser;
import com.ssh.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepositoryImpl userRepository;
    public TUser getUserById(Integer id){
        return userRepository.get(id);
    }

    public List<Map<String, Object>> getNameAndAddressByState(Integer state){
        List<Map<String, Object>> result = userRepository.getNameAndAddressByState(state);
        return result;
    }
}
