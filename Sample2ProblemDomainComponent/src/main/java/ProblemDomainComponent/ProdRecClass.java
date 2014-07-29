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
public class ProdRecClass 
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
    private long qty;

    @Column(name = "sizematrixid")
    private long SizeMatrixID;
    
    @Column(name = "s1")
    private String S1;

    @Column(name = "s2")
    private String S2;
            
    @Column(name = "s3")
    private String S3;

    @Column(name = "s4")
    private String S4;

    @Column(name = "s5")
    private String S5;

    @Column(name = "s6")
    private String S6;

    @Column(name = "s7")
    private String S7;

    @Column(name = "s8")
    private String S8;

    @Column(name = "s9")
    private String S9;

    @Column(name = "s10")
    private String S10;

    @Column(name = "s11")
    private String S11;

    @Column(name = "s12")
    private String S12;

    @Column(name = "s13")
    private String S13;

    @Column(name = "s14")
    private String S14;

    @Column(name = "s15")
    private String S15;

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
 

    public ProdRecClass() throws KExceptionClass {
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

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    public long getSizeMatrixID() {
        return SizeMatrixID;
    }

    public void setSizeMatrixID(long SizeMatrixID) {
        this.SizeMatrixID = SizeMatrixID;
    }

    public String getS1() {
        return S1;
    }

    public void setS1(String S1) {
        this.S1 = S1;
    }

    public String getS2() {
        return S2;
    }

    public void setS2(String S2) {
        this.S2 = S2;
    }

    public String getS3() {
        return S3;
    }

    public void setS3(String S3) {
        this.S3 = S3;
    }

    public String getS4() {
        return S4;
    }

    public void setS4(String S4) {
        this.S4 = S4;
    }

    public String getS5() {
        return S5;
    }

    public void setS5(String S5) {
        this.S5 = S5;
    }

    public String getS6() {
        return S6;
    }

    public void setS6(String S6) {
        this.S6 = S6;
    }

    public String getS7() {
        return S7;
    }

    public void setS7(String S7) {
        this.S7 = S7;
    }

    public String getS8() {
        return S8;
    }

    public void setS8(String S8) {
        this.S8 = S8;
    }

    public String getS9() {
        return S9;
    }

    public void setS9(String S9) {
        this.S9 = S9;
    }

    public String getS10() {
        return S10;
    }

    public void setS10(String S10) {
        this.S10 = S10;
    }

    public String getS11() {
        return S11;
    }

    public void setS11(String S11) {
        this.S11 = S11;
    }

    public String getS12() {
        return S12;
    }

    public void setS12(String S12) {
        this.S12 = S12;
    }

    public String getS13() {
        return S13;
    }

    public void setS13(String S13) {
        this.S13 = S13;
    }

    public String getS14() {
        return S14;
    }

    public void setS14(String S14) {
        this.S14 = S14;
    }

    public String getS15() {
        return S15;
    }

    public void setS15(String S15) {
        this.S15 = S15;
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
