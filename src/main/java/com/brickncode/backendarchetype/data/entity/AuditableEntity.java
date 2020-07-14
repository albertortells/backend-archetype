package com.brickncode.backendarchetype.data.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@MappedSuperclass
class AuditableEntity implements Serializable {

    private static final long serialVersionUID = 8723150914271182093L;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "modified_by")
    private String lastModifiedBy;

    AuditableEntity() { }

    AuditableEntity(Date createdDate, Date lastModifiedDate, String createdBy, String lastModifiedBy) {
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
    }

    public static long getSerialVersionUID() {  return serialVersionUID; }

    public Date getCreatedDate() { return this.createdDate != null ? new Date(this.createdDate.getTime()) : null; }

    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate != null ? new Date(createdDate.getTime()) : null; }

    public Date getLastModifiedDate() { return this.lastModifiedDate != null ? new Date(this.lastModifiedDate.getTime()) : null; }

    public void setLastModifiedDate(Date lastModifiedDate) { this.lastModifiedDate = lastModifiedDate != null ? new Date(lastModifiedDate.getTime()) : null; }

    public String getCreatedBy() { return createdBy; }

    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getLastModifiedBy() { return lastModifiedBy; }

    public void setLastModifiedBy(String lastModifiedBy) { this.lastModifiedBy = lastModifiedBy; }
}
