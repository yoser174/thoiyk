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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

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
    pkColumnValue="SEQ_SERVICE_TYPE", 
    allocationSize=1)    
@Table(name = "SERVICETYPE")
public class ServiceTypeClass 
extends KBusinessObjectClass{
    
    @Id
    @KBusinessObjectClass.KID    
    @Basic(optional = false)
    @GeneratedValue( strategy = javax.persistence.GenerationType.TABLE, generator="KIDGenerator" )    
    @Column(name = "id")
    private long ID;

    @Column(name = "name")
    private String Name;

    @KBusinessObjectClass.KObjectVersion
    @Column(name = "version")
    private long version;

           
    public ServiceTypeClass() throws KExceptionClass {
    }

    //=================================================================
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
