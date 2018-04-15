package com.pos.app.dto.order;

import com.pos.app.dto.BaseDto;

/**
 * Created by admin on 4/14/18.
 */
public class CartProductDto extends BaseDto {

    private Integer quantity;
    private String upc;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }
}
