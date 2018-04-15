package com.pos.app.dto.order;

import com.pos.app.dto.BaseDto;
import com.pos.app.dto.inventory.ProductDto;

/**
 * Created by admin on 4/14/18.
 */
public class CartProductDetailDto extends BaseDto {

//    private CartDetailDto cartDetail;
    private Integer quantity;
    private Double unitPrice;
    private Double unitTax;
    private Double totalPrice;
    private Double totalTax;
    private ProductDto product;

//    public CartDetailDto getCartDetail() {
//        return cartDetail;
//    }
//
//    public void setCartDetail(CartDetailDto cartDetail) {
//        this.cartDetail = cartDetail;
//    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getUnitTax() {
        return unitTax;
    }

    public void setUnitTax(Double unitTax) {
        this.unitTax = unitTax;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
