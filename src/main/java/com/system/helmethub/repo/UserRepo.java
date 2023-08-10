package com.system.helmethub.repo;

import com.system.helmethub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.OptionalInt;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM users WHERE user_email = ?1",nativeQuery = true)
    Optional<User> findByEmail(String email);
}
