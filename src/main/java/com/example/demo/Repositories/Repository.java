package com.example.demo.Repositories;

import com.example.demo.Models.Product;
import com.example.demo.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {
    public User loginUser = new User("209298454", "adi", "123", "masdam6masdkhadamasdnuas");
    public List<Product> productList = new ArrayList<Product>(){{
       add(new Product("Shampo", 120));
       add(new Product("Kefli", 120));
       add(new Product("Bamba", 120));
       add(new Product("Chitos", 120));
    }};
}
