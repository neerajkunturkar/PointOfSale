package com.pos.app.model.inventory;

import com.pos.app.model.core.AuditCommonBaseModel;

import javax.persistence.*;

/**
 * Created by admin on 4/12/2018.
 */

@Entity
@Table(name = "product")
public class Product extends AuditCommonBaseModel {

    private String name;
    @Column(unique = true)
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
