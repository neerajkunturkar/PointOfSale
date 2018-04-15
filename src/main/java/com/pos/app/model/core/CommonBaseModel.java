package com.pos.app.model.core;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by admin on 4/12/2018.
 */
@MappedSuperclass
public class CommonBaseModel implements Serializable {
    /** Primary id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="is_deleted", columnDefinition="boolean default false")
    private Boolean isDeleted = Boolean.FALSE;

    /** Constructor. */
    protected CommonBaseModel() {
        // Private constructor to prevent direct instantiation.
    }

    /** Primary id getter. */
    public Long getId() {
        return id;
    }

    /** Primary id setter. */
    public void setId(final Long id) {
        this.id = id;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
