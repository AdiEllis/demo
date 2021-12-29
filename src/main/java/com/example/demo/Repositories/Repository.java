package com.example.demo.Repositories;

import com.example.demo.Models.File;
import com.example.demo.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {
    public User loginUser = new User("adi.ellis3@gmail.com", "12345678Ae", "masdam6masdkhadamasdnuas");
    public List<File> filesList = new ArrayList<File>(){{
       add(new File(1, "MyFirstFile.txt", "7/12/2018"));
       add(new File(2, "MyFirstFile2.txt", "7/13/2018"));
    }};
}
