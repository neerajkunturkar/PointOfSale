package com.pos.app.dto.inventory;

import com.pos.app.dto.BaseDto;

/**
 * Created by admin on 4/14/18.
 */
public class ProductSkuDto extends BaseDto {

    private ProductDto productDto;
    private String sku;
    private String skuCode;
    private String skuDescription;

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
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
}
