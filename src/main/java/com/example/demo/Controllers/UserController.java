package com.example.demo.Controllers;

import com.example.demo.Entities.BasicResponseModel;
import com.example.demo.Models.File;
import com.example.demo.Repositories.Repository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    public Repository repository;
    EmailValidator validator = EmailValidator.getInstance();

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public BasicResponseModel login(@RequestParam String email, @RequestParam String password) {
        BasicResponseModel basicResponseModel = null;
        if (!email.isEmpty() && !password.isEmpty()) {
            if (validator.isValid(email)) {
                if (email.equals(repository.loginUser.getEmail())) {
                    if (password.length() > 7 &&
                            password.matches("(.*[A-Z].*)") &&
                            password.matches("(.*[a-z].*)") &&
                            password.matches("(.*[0-9].*)") &&
                            password.matches((".*[@,#,$,%].*$"))) {
                        basicResponseModel = new BasicResponseModel("success!");
                    } else {
                        basicResponseModel = new BasicResponseModel(100, "Invalid password");
                    }
                }
            }
        }
        return basicResponseModel;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/api/getFiles", method = RequestMethod.GET)
    public BasicResponseModel getFiles(@RequestParam String filter) {
        BasicResponseModel basicResponseModel;
        List<File> filterList;
        filterList = repository.filesList.stream().filter((file ->
                filter.equals(file.getFileName())
                )).collect(Collectors.toList());
        if (filterList.isEmpty()) {
            basicResponseModel = new BasicResponseModel("File not found!");
        } else {
            basicResponseModel = new BasicResponseModel(filterList);
        }
        return basicResponseModel;
    }


//    @CrossOrigin(origins = "http://localhost:3000")
//    @RequestMapping(value = "/api/getFiles", method = RequestMethod.GET)
//    public BasicResponseModel getFiles(@RequestParam String sortBy, @RequestParam String sortType) {
//        BasicResponseModel basicResponseModel;
//
//
//        return basicResponseModel;
//    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/api/verifyLogin", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String email, @RequestParam String token) {
        String success = "failed";
        if (email.equals(repository.loginUser.getEmail()) &&
                token.equals(repository.loginUser.getToken())) {
            success = repository.loginUser.getToken();
        }
        return success;
    }
}
