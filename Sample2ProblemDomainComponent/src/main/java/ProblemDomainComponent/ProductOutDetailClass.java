/*
This source code is part of the Thoyik
Copyright (C) 2013  Yoserizal
Feedback / Bug Reports yoser174@gmail.com


This project used:
KFRAMEWORK  (http://k-framework.sourceforge.net/)
 */


package ProblemDomainComponent;

import KFramework30.Base.KBusinessObjectClass;
import KFramework30.Base.KExceptionClass;
import java.awt.Component;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yoserizy
 */
@Entity
@TableGenerator( // SCOPE is Global to PU
    name="KIDGenerator", 
    table="SEQUENCE", 
    pkColumnName="SEQ_NAME", 
    valueColumnName="SEQ_COUNT", 
    pkColumnValue="GEN_PRD_OUT_DTL", 
    allocationSize=1)    
@Table(name = "PRODUCTOUT_DTL")
public class ProductOutDetailClass 
extends KBusinessObjectClass
{

    @KBusinessObjectClass.KID
    @Id   
    @GeneratedValue( strategy = javax.persistence.GenerationType.TABLE, generator="KIDGenerator" )    
    @Column(name = "id")
    private long ID;
    
    @Column(name = "hdrid")
    private long HdrID;

    @Column(name = "itemid")
    private long ItemID;
    
    @Column(name = "itemqty")
    private long ItemQty;
    
    @Column(name = "itemunitid")
    private long ItemUnitID;
        
    @Column(name = "createdby")
    private String CreatedBy;
    
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date DateCreated;

    @Column(name = "modifiedby")
    private String ModifiedBy;
    
    @Column(name = "datemodified")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date DateModified;
    
    
    @KBusinessObjectClass.KObjectVersion
    @Column(name = "version")
    private long version;

    
    
    public ProductOutDetailClass() throws KExceptionClass {
    }

    //=================================================================
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getHdrID() {
        return HdrID;
    }

    public void setHdrID(long HdrID) {
        this.HdrID = HdrID;
    }

    public long getItemID() {
        return ItemID;
    }

    public void setItemID(long ItemID) {
        this.ItemID = ItemID;
    }

    public long getItemQty() {
        return ItemQty;
    }

    public void setItemQty(long ItemQty) {
        this.ItemQty = ItemQty;
    }

    public long getItemUnitID() {
        return ItemUnitID;
    }

    public void setItemUnitID(long ItemUnitID) {
        this.ItemUnitID = ItemUnitID;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date DateCreated) {
        this.DateCreated = DateCreated;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String ModifiedBy) {
        this.ModifiedBy = ModifiedBy;
    }

    public Date getDateModified() {
        return DateModified;
    }

    public void setDateModified(Date DateModified) {
        this.DateModified = DateModified;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
    
    
    
    @Override
    public void validateInput(String currentField, Component currentComponent) throws KExceptionClass {
    }


}
