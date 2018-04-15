package com.pos.app.dto.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pos.app.dto.BaseDto;
import com.pos.core.util.json.CustomDateDeserializer;
import com.pos.core.util.json.CustomDateSerializer;

import java.util.Collection;
import java.util.Date;

/**
 * Created by admin on 4/14/18.
 */
public class CartDetailDto extends BaseDto {

    private String invoiceNo;
    private String status;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date billDate;
    private Double totalAmount;
    private Integer totalItems;
    private Collection<CartProductDetailDto> cartProductDetails;

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
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

    public Collection<CartProductDetailDto> getCartProductDetails() {
        return cartProductDetails;
    }

    public void setCartProductDetails(Collection<CartProductDetailDto> cartProductDetails) {
        this.cartProductDetails = cartProductDetails;
    }
}
