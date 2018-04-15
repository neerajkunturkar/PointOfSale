package com.pos.app.model.order;

import com.pos.app.model.core.AuditCommonBaseModel;
import com.pos.app.model.inventory.Product;

import javax.persistence.*;

/**
 * Created by admin on 4/14/18.
 */
@Entity
@Table(name = "tax_bracket")
public class TaxBracket extends AuditCommonBaseModel {

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private Double applicableTax;
    @Enumerated(EnumType.STRING)
    private Unit unit;

    public enum Unit{
        PERCENTAGE, ABSOLUTE
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getApplicableTax() {
        return applicableTax;
    }

    public void setApplicableTax(Double applicableTax) {
        this.applicableTax = applicableTax;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
