package com.pos.app.model.core;

/**
 * Created by admin on 4/12/2018.
 */

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/** Abstract base model including primary id and
 * created_at and updated_at time fields.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditCommonBaseModel extends CommonBaseModel {

    /** Model created at timestamp. */
    @CreatedDate
    private Date createdAt;

    /** Model updated at timestamp. */
    @LastModifiedDate
    private Date updatedAt;

    @CreatedBy
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;

    /** Constructor. */
    protected AuditCommonBaseModel() {
        // Private constructor to prevent direct instantiation.
    }

    /** Created at getter. */
    public Date getCreatedAt() {
        return createdAt;
    }

    /** Created at setter. */
    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    /** Updated at getter. */
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    /** Updated at setter. */
    public void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

}
