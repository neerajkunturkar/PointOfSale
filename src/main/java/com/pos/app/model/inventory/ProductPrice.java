package com.pos.app.model.inventory;

import com.pos.app.model.core.AuditCommonBaseModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by admin on 4/13/2018.
 */

@Entity
@Table(name = "product_price")
public class ProductPrice extends AuditCommonBaseModel {

    @NotNull
    private Double price;


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
