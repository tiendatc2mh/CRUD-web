package com.example.springboot_hibernate.Controller;

import com.example.springboot_hibernate.Repository.UserRepository;
import com.example.springboot_hibernate.SpringbootHibernateApplication;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4000")
@RestController
@RequestMapping("/api/v1")
public class UserController {
    private static Logger logger= Logger.getLogger(SpringbootHibernateApplication.class);

    @Autowired
    private UserRepository userRepository;


}
