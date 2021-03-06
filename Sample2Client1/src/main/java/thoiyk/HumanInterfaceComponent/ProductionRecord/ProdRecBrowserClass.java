/*
This source code is part of the Thoyik
Copyright (C) 2013  Yoserizal
Feedback / Bug Reports yoser174@gmail.com


This project used:
KFRAMEWORK  (http://k-framework.sourceforge.net/)
 */


package thoiyk.HumanInterfaceComponent.ProductionRecord;

/**
 *
 * @author yoserizy
 */
//rtl
import thoiyk.HumanInterfaceComponent.ProductionRecord.ProdRecEditDialogClass;
import javax.swing.*;

// utilities
import KFramework30.Widgets.*;
import KFramework30.Base.*;
import static KFramework30.Widgets.KDataBrowserBaseClass.BROWSER_COLUMN_TYPE_NUMERICNOFORMAT;

// system
import ProblemDomainComponent.ProdRecClass;


public class ProdRecBrowserClass 
extends KDataBrowserBaseClass {   
        
    // uses                       	
    
    // has

    /** Creates new viajeBrowserClass */
    public ProdRecBrowserClass(
            KConfigurationClass configurationParam,
            KLogClass logParam,
            JTable tableParam,
            java.awt.Window parentWindow           
            ) throws KExceptionClass
    {
        
            // inherits
            super(
                    configurationParam, logParam,
                    true, tableParam, parentWindow,  
                    ProdRecClass.class,
                    ProdRecEditDialogClass.class
            );  
            
            // uses                   
	    // has            
    }        


    public void initializeTable()
    throws KExceptionClass
    {	      
              
            // set the SQL
            super.initializeSQLQuery( 
                
                " pr.ID, pr.prno, st.nama type, pr.STYLE, pr.BUYERID,byr.NAMA BUYERNAME,pr.DESCRIPTION, pr.QTY ",
                
                // 2 tablas and joins                                             
                " productionrecord pr   "  +
                " left join stocktype st on pr.samplerecordtypeid = st.id "   +
                " left join BUYER byr on pr.BUYERID=byr.id "  
                 ,
                                                                
                // 3 llave principal (mayusculas!)
                "ID" 
                                                                                             
                    );   

     
            setColumnNames( "pr", "ID", "ID" );
            setColumnNames( "pr", "PRNO", "PRNo" );
            setColumnNames( "st", "TYPE", "TypeName" );
            setColumnNames( "pr", "STYLE", "Style" );
            setColumnNames( "pr", "BUYERID", "BuyerID" );
            setColumnNames( "byr", "BUYERNAME", "BuyerName" );
            setColumnNames( "pr", "DESCRIPTION", "Description" );
            setColumnNames( "pr", "QTY", "Qty" );
       
            setDefaultOrder( "  ID " );
            // load data
            super.initializeTable();  
            
             // some customization
            adjustColumnWidth( "ID", 40 );
            adjustColumnWidth( "PRNo", 80 );
            adjustColumnWidth( "TypeName", 100 );
            adjustColumnWidth( "Style", 100 );
            adjustColumnWidth( "BuyerID", 40 );
            adjustColumnWidth( "BuyerName", 100 );
            adjustColumnWidth( "Description", 100 );
            adjustColumnWidth( "Qty", 40 );
            
            adjustColumnType("ID",  BROWSER_COLUMN_TYPE_NUMERICNOFORMAT );
            
    }        


    
}
