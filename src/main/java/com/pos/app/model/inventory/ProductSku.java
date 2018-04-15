package com.pos.app.model.inventory;

import com.pos.app.model.core.AuditCommonBaseModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

/**
 * Created by admin on 4/13/2018.
 */

@Entity
@Table(name = "product_sku")
public class ProductSku extends AuditCommonBaseModel {

    @NotNull
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private String sku;
    private String skuCode;
    private String skuDescription;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "productSku")
    private Set<ProductUpc> productUpcs;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuDescription() {
        return skuDescription;
    }

    public void setSkuDescription(String skuDescription) {
        this.skuDescription = skuDescription;
    }

    public Set<ProductUpc> getProductUpcs() {
        return productUpcs;
    }

    public void setProductUpcs(Set<ProductUpc> productUpcs) {
        this.productUpcs = productUpcs;
    }
}
