package com.pos.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by admin on 4/13/2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDto {
    private Long id;

    /** Primary id getter. */
    public Long getId() {
        return id;
    }

    /** Primary id setter. */
    public void setId(final Long id) {
        this.id = id;
    }
}
