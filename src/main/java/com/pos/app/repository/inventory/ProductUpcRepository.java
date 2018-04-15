package com.pos.app.repository.inventory;

import com.pos.app.model.inventory.ProductUpc;
import com.pos.app.repository.CommonBaseRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by admin on 4/13/2018.
 */
public interface ProductUpcRepository extends CommonBaseRepository<ProductUpc, Long> {

    ProductUpc findByUpc(@Param("code") String code);
}
