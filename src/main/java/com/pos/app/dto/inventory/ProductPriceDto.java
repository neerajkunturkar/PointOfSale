package com.pos.app.dto.inventory;

import com.pos.app.dto.BaseDto;

/**
 * Created by admin on 4/14/18.
 */
public class ProductPriceDto extends BaseDto {

    private Double price;


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
