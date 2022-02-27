package com.example.springboot_hibernate.Repository;

import com.example.springboot_hibernate.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
