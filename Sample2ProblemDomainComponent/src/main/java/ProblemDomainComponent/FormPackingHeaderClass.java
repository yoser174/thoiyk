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
    pkColumnValue="GEN_FPACKING_HDR", 
    allocationSize=1)    
@Table(name = "FORMPACKING_HDR")
public class FormPackingHeaderClass 
extends KBusinessObjectClass
{
    @KID
    @Id   
    @GeneratedValue( strategy = javax.persistence.GenerationType.TABLE, generator="KIDGenerator" )    
    @Column(name = "id")
    private long ID;

    @Column(name = "prid")
    private long PRID;
    
    @Column(name = "prno")
    private String PRNo;

    @Column(name = "tanggal")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date Tanggal;

    @Column(name = "stylename")
    private String StyleName;

    @Column(name = "buyerid")
    private long BuyerID;

    @Column(name = "negara")
    private String Negara;

    @Column(name = "Description")
    private String Description;

    @Column(name = "atn")
    private String Atn;

    @Column(name = "buyername")
    private String BuyerName;

    @Column(name = "PO")
    private String PO;

    @Column(name = "auditdate")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date AuditDate;

    @Column(name = "audituser")
    private String AuditUser;
    
    @KBusinessObjectClass.KObjectVersion
    @Column(name = "version")
    private long version;
    
    public FormPackingHeaderClass() throws KExceptionClass{
    }

    //=================================================================
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getPRID() {
        return PRID;
    }

    public void setPRID(long PRID) {
        this.PRID = PRID;
    }

    public String getPRNo() {
        return PRNo;
    }

    public void setPRNo(String PRNo) {
        this.PRNo = PRNo;
    }

    public Date getTanggal() {
        return Tanggal;
    }

    public void setTanggal(Date Tanggal) {
        this.Tanggal = Tanggal;
    }

    public String getStyleName() {
        return StyleName;
    }

    public void setStyleName(String StyleName) {
        this.StyleName = StyleName;
    }

    public long getBuyerID() {
        return BuyerID;
    }

    public void setBuyerID(long BuyerID) {
        this.BuyerID = BuyerID;
    }

    public String getNegara() {
        return Negara;
    }

    public void setNegara(String Negara) {
        this.Negara = Negara;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getAtn() {
        return Atn;
    }

    public void setAtn(String Atn) {
        this.Atn = Atn;
    }

    public String getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(String BuyerName) {
        this.BuyerName = BuyerName;
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public Date getAuditDate() {
        return AuditDate;
    }

    public void setAuditDate(Date AuditDate) {
        this.AuditDate = AuditDate;
    }

    public String getAuditUser() {
        return AuditUser;
    }

    public void setAuditUser(String AuditUser) {
        this.AuditUser = AuditUser;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
    
    
    
    public void validateInput(String currentField, Component currentComponent) throws KExceptionClass {
    }
    
}
