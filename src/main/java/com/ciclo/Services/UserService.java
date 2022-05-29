package com.ciclo.Services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.ciclo.Dto.UserRequest;
import com.ciclo.Entities.User;
import com.ciclo.Repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository repository) { this.userRepository = repository; }

    @Transactional
    public User createUser(UserRequest userRequest) {
        User userNew = initUser(userRequest);
        return userRepository.save(userNew);
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() { return userRepository.getAllUsers(); }

    private User initUser(UserRequest userRequest) {
        User userObj = new User();
        userObj.setUsername(userRequest.getUsername());
        userObj.setEmail(userRequest.getEmail());
        userObj.setImageurl(userRequest.getImageurl());
        userObj.setPassword(userRequest.getPassword());
        userObj.setCryptmethod(userRequest.getCryptmethod());
        return userObj;
    }
}
