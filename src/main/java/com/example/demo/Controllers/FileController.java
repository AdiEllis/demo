package com.example.demo.Controllers;

import com.example.demo.Entities.BasicResponseModel;
import com.example.demo.Models.File;
import com.example.demo.Repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

public class FileController {
    @Autowired
    public Repository repository;

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

}
