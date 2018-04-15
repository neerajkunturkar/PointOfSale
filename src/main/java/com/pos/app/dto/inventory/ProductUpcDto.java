package com.pos.app.dto.inventory;

import com.pos.app.dto.BaseDto;

/**
 * Created by admin on 4/14/18.
 */
public class ProductUpcDto extends BaseDto {

    private String upc;
    private Integer inventoryStock;
    private ProductSkuDto productSkuDto;
    private ProductPriceDto productPriceDto;

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Integer getInventoryStock() {
        return inventoryStock;
    }

    public void setInventoryStock(Integer inventoryStock) {
        this.inventoryStock = inventoryStock;
    }

    public ProductSkuDto getProductSkuDto() {
        return productSkuDto;
    }

    public void setProductSkuDto(ProductSkuDto productSkuDto) {
        this.productSkuDto = productSkuDto;
    }

    public ProductPriceDto getProductPriceDto() {
        return productPriceDto;
    }

    public void setProductPriceDto(ProductPriceDto productPriceDto) {
        this.productPriceDto = productPriceDto;
    }
}
