package com.pos.app.services;

import com.pos.app.model.inventory.Product;
import com.pos.app.repository.inventory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 4/12/2018.
 */
@Service
public class TestService {

    @Autowired
    ProductRepository testRepository;

    public List<Product> getAll(){
        List<Product> tests =  testRepository.findAll();
        return tests;
    }
}
