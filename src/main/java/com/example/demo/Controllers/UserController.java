package com.example.demo.Controllers;

import com.example.demo.Repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired public Repository repository;


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/demo/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password) {
        String success = "failed";
        if (username.equals(repository.loginUser.getUsername()) &&
                password.equals(repository.loginUser.getPassword())) {
            success = repository.loginUser.getToken();
        }
        return success;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/demo/verifyLogin", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String username, @RequestParam String token) {
        String success = "failed";
        if (username.equals(repository.loginUser.getUsername()) &&
                token.equals(repository.loginUser.getToken())) {
            success = repository.loginUser.getToken();
        }
        return success;
    }
}
