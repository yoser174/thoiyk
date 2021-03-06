/*
This source code is part of the Thoyik
Copyright (C) 2013  Yoserizal
Feedback / Bug Reports yoser174@gmail.com


This project used:
KFRAMEWORK  (http://k-framework.sourceforge.net/)
 */


package ProblemDomainComponent;

/**
 *
 * @author yoserizy
 */
import KFramework30.Base.KBusinessObjectClass;
import KFramework30.Base.KExceptionClass;
import java.awt.Component;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@TableGenerator( // SCOPE is Global to PU
    name="KIDGenerator", 
    table="SEQUENCE", 
    pkColumnName="SEQ_NAME", 
    valueColumnName="SEQ_COUNT", 
    pkColumnValue="GEN_SR_ID", 
    allocationSize=1) 
@Table(name = "PRODUCTIONRECORD")
public class pr_newClass 
extends KBusinessObjectClass
{
    
    @KBusinessObjectClass.KID
    @Id   
    @GeneratedValue( strategy = javax.persistence.GenerationType.TABLE, generator="KIDGenerator" )    
    @Column(name = "id")
    private long id;
    
    @Column(name = "selectid")
    private long selectid;

    @Column(name = "samplerecordstatusid")
    private long samplerecordstatusid;

    @Column(name = "samplerecordtypeid")
    private long samplerecordtypeid;
    
    @Column(name = "buyerid")
    private long  buyerid;

    @Column(name = "buyername")
    private String buyername;

    @Column(name = "prno")
    private String prno;

    @Column(name = "description")
    private String description;
    
    @Column(name = "style")
    private String style;
    
    @Column(name = "qty")
    private String qty;
    
    
    @Lob
    @Column(name = "image")
    private byte[] image;  
    
    @Column(name = "auditdate")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date AuditDate;
    
    @Column(name = "audituser")
    private String AuditUser;
  
      
    @KBusinessObjectClass.KObjectVersion
    @Column(name = "version")
    private long version;
 

    public pr_newClass() throws KExceptionClass {
    }

    //=================================================================    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSelectid() {
        return selectid;
    }

    public void setSelectid(long selectid) {
        this.selectid = selectid;
    }

    public long getSamplerecordstatusid() {
        return samplerecordstatusid;
    }

    public void setSamplerecordstatusid(long samplerecordstatusid) {
        this.samplerecordstatusid = samplerecordstatusid;
    }

    public long getSamplerecordtypeid() {
        return samplerecordtypeid;
    }

    public void setSamplerecordtypeid(long samplerecordtypeid) {
        this.samplerecordtypeid = samplerecordtypeid;
    }

    public long getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(long buyerid) {
        this.buyerid = buyerid;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getPrno() {
        return prno;
    }

    public void setPrno(String prno) {
        this.prno = prno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
    
    
 
    @Override
    public void validateInput(String currentField, Component currentComponent) throws KExceptionClass {
    }
    

}
