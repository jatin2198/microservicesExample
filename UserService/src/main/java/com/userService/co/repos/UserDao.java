package com.userService.co.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.userService.co.entities.User;

@Component
public interface UserDao extends JpaRepository<User, String> {

}
