package com.ciclo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ciclo.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u")
    List<User> getAllUsers();
}
