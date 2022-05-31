package com.ciclo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ciclo.Entities.User;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u")
    List<User> getAllUsers();
    @Query(value = "SELECT u FROM User u WHERE u.idUser = :idUser")
    User getUserById(@Param("idUser") Long idUser);
}
