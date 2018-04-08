package com.ssh.service;

import com.ssh.entity.TUser;
import com.ssh.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepositoryImpl userRepository;
    public TUser getUserById(Integer id){
        return userRepository.get(id);
    }

    public TUser getUser(TUser user){
//        TUser u = userRepository.selectUser(user);
        return null;
    }
}
