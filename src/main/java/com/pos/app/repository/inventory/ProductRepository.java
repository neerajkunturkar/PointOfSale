package com.pos.app.repository.inventory;

import com.pos.app.model.inventory.Product;
import com.pos.app.repository.CommonBaseRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by admin on 4/12/2018.
 */
public interface ProductRepository extends CommonBaseRepository<Product, Long> {

    List<Product> findAll();

    Product findByCode(@Param("code") String code);
}
