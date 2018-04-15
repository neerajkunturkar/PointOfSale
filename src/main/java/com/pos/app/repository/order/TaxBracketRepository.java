package com.pos.app.repository.order;

import com.pos.app.model.order.TaxBracket;
import com.pos.app.repository.CommonBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by admin on 4/14/18.
 */
public interface TaxBracketRepository extends CommonBaseRepository<TaxBracket, Long> {

    @Query(nativeQuery = true, value = "select t.* from tax_bracket t where t.product_id =:productId")
    TaxBracket findByProductId(@Param("productId") Long productId);
}
