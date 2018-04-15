package com.pos.app.model.order;

import com.pos.app.model.core.AuditCommonBaseModel;
import com.pos.app.model.inventory.Product;

import javax.persistence.*;

/**
 * Created by admin on 4/14/18.
 */
@Entity
@Table(name = "cart_product_detail")
public class CartProductDetail extends AuditCommonBaseModel {

    @ManyToOne
    @JoinColumn(name = "cart_detail_id", nullable = false)
    private CartDetail cartDetail;

    private Integer quantity;
    private Double unitPrice;
    private Double unitTax;
    private Double totalPrice;
    private Double totalTax;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    public CartDetail getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(CartDetail cartDetail) {
        this.cartDetail = cartDetail;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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

    public void setTotalAmount() {
        Double totalAmount = this.unitPrice * this.getQuantity();
        this.totalPrice = totalAmount;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax() {
        Double totalTax = this.unitTax * this.getQuantity();
        this.totalTax = totalTax;
    }
}
