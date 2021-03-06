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
    pkColumnValue="GEN_PRD_OUT_HDR", 
    allocationSize=1)    
@Table(name = "PRODUCTOUT_HDR")
public class ProductOutHeaderClass 
extends KBusinessObjectClass
{

    @KID
    @Id   
    @GeneratedValue( strategy = javax.persistence.GenerationType.TABLE, generator="KIDGenerator" )    
    @Column(name = "id")
    private long ID;
    

    @Column(name = "typeid")
    private long TypeID;

    @Column(name = "prid")
    private long PRID;

    @Column(name = "nomor")
    private String Nomor;

    @Column(name = "tanggal")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date Tanggal;

    @Column(name = "tanggalselesai")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date TanggalSelesai;

    @Column(name = "penerimaid")
    private long PenerimaID;
    
    @Column(name = "penerimaname")
    private String PenerimaName;
    
    @Column(name = "nobc")
    private String NoBC;
    
    @Column(name = "tglbc")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date TglBC;
    
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


    public ProductOutHeaderClass() throws KExceptionClass {
    }

    //=================================================================
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getTypeID() {
        return TypeID;
    }

    public void setTypeID(long TypeID) {
        this.TypeID = TypeID;
    }

    

    
    public String getNomor() {
        return Nomor;
    }

    public void setNomor(String Nomor) {
        this.Nomor = Nomor;
    }

    public Date getTanggal() {
        return Tanggal;
    }

    public void setTanggal(Date Tanggal) {
        this.Tanggal = Tanggal;
    }

    public Date getTanggalSelesai() {
        return TanggalSelesai;
    }

    public void setTanggalSelesai(Date TanggalSelesai) {
        this.TanggalSelesai = TanggalSelesai;
    }
    
    public long getPenerimaID() {
        return PenerimaID;
    }

    public void setPenerimaID(long PenerimaID) {
        this.PenerimaID = PenerimaID;
    }

    public String getPenerimaName() {
        return PenerimaName;
    }

    public void setPenerimaName(String PenerimaName) {
        this.PenerimaName = PenerimaName;
    }
    
    

    public long getPRID() {
        return PRID;
    }

    public void setPRID(long PRID) {
        this.PRID = PRID;
    }

    public String getNoBC() {
        return NoBC;
    }

    public void setNoBC(String NoBC) {
        this.NoBC = NoBC;
    }

    public Date getTglBC() {
        return TglBC;
    }

    public void setTglBC(Date TglBC) {
        this.TglBC = TglBC;
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
