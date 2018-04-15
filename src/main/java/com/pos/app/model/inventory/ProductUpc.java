package com.pos.app.model.inventory;

import com.pos.app.model.core.AuditCommonBaseModel;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 4/13/2018.
 */

@Entity
@Table(name = "product_upc")
public class ProductUpc extends AuditCommonBaseModel {

    @ManyToOne
    @JoinColumn(name = "product_sku_id", nullable = false)
    private ProductSku productSku;

    @Column(unique = true)
    private String upc;

    @OneToOne
    @JoinColumn(name = "product_price_id", nullable = false)
    private ProductPrice productPrice;

    private Integer inventoryStock;

    public ProductSku getProductSku() {
        return productSku;
    }

    public void setProductSku(ProductSku productSku) {
        this.productSku = productSku;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getInventoryStock() {
        return inventoryStock;
    }

    public void setInventoryStock(Integer inventoryStock) {
        this.inventoryStock = inventoryStock;
    }

}
