package com.pos.app.dto.inventory;

import com.pos.app.dto.BaseDto;

/**
 * Created by admin on 4/14/18.
 */
public class ProductDto extends BaseDto {

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
