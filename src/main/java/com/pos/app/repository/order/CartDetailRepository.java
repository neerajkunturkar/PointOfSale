package com.pos.app.repository.order;

import com.pos.app.model.order.CartDetail;
import com.pos.app.repository.CommonBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by admin on 4/14/18.
 */
public interface CartDetailRepository extends CommonBaseRepository<CartDetail, Long> {

    @Query(nativeQuery = true, value = "select c.* from cart_detail c where c.status=:status")
    CartDetail findByStatus(@Param("status") String status);

    @Query(nativeQuery = true, value = "select c.* from cart_detail c where c.status=:status and c.created_by=:createdBy ")
    List<CartDetail> findAllByStatusAndCreatedBy(@Param("status") String status, @Param("createdBy") Long createdBy);

    @Query(nativeQuery = true, value = "select c.* from cart_detail c where c.id =:id and c.status=:status and c.created_by=:createdBy ")
    CartDetail findByStatusAndCreatedByAndId(@Param("id") Long id, @Param("status") String status, @Param("createdBy") Long createdBy);
}
