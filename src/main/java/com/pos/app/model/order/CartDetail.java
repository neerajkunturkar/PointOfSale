package com.pos.app.model.order;

import com.pos.app.model.core.AuditCommonBaseModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

/**
 * Created by admin on 4/13/2018.
 */
@Entity
@Table(name = "cart_detail")
public class CartDetail extends AuditCommonBaseModel {

    private final String invoiceNo = generateBillNo();

    private String generateBillNo() {

        Random random = new Random(System.nanoTime() % 100000);
        String billNumber = "ORD" + random.nextInt(1000000000);
        return billNumber;
    }

    @Enumerated(EnumType.STRING)
    private Status status;
    private Date billDate;
    private Double totalAmount;
    private Integer totalItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartDetail")
    private Collection<CartProductDetail> cartProductDetails;
    public enum Status{
        INPROGRESS, DISCARD, COMPLETED
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Collection<CartProductDetail> getCartProductDetails() {
        if(this.cartProductDetails == null){
            this.cartProductDetails = new ArrayList<CartProductDetail>();
        }
        return cartProductDetails;
    }

    public void setCartProductDetails(Collection<CartProductDetail> cartProductDetails) {
        this.cartProductDetails = cartProductDetails;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }
}
