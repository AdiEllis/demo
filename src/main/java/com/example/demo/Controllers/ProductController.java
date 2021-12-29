package com.example.demo.Controllers;

import com.example.demo.Repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public Repository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/demo/getProducts", method = RequestMethod.GET)
    public List getProducts(){
        return repository.productList;
    }
}
