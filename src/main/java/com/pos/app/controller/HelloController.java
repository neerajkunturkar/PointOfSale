package com.pos.app.controller;

import com.pos.app.model.inventory.Product;
import com.pos.app.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 4/12/2018.
 * This is a test class
 */

@RestController
@RequestMapping(value = "/hello")

public class HelloController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public ResponseEntity<?> sayHello()throws
            Exception{
        List<Product> testList = testService.getAll();

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(testList);
    }
}
