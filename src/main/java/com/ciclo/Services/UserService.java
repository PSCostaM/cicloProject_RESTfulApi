package com.ciclo.Services;
import com.ciclo.Util.UserValidator;
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
        UserValidator.validateCreate(userRequest);
        User userNew = initUser(userRequest);
        return userRepository.save(userNew);
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() { return userRepository.getAllUsers(); }

    @Transactional(readOnly = true)
    public User getUserById(Long idUser) { return userRepository.getUserById(idUser); }
    @Transactional(readOnly = true)
    public User getUserByLogIn(String email, String password) { return userRepository.getUserByLogIn(email, password); }

    private User initUser(UserRequest userRequest) {
        User userObj = new User();
        userObj.setUsername(userRequest.getUsername());
        userObj.setEmail(userRequest.getEmail());
        userObj.setImageurl(userRequest.getImageurl());
        userObj.setPassword(userRequest.getPassword());
        userObj.setCryptmethod("text");
        return userObj;
    }
}
