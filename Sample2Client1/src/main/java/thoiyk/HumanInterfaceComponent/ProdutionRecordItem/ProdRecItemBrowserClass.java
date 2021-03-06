/*
This source code is part of the Thoyik
Copyright (C) 2013  Yoserizal
Feedback / Bug Reports yoser174@gmail.com


This project used:
KFRAMEWORK  (http://k-framework.sourceforge.net/)
 */


package thoiyk.HumanInterfaceComponent.ProdutionRecordItem;

/**
 *
 * @author yoserizy
 */

//rtl
import javax.swing.*;
import java.awt.*;

// utilities
import KFramework30.Widgets.*;
import KFramework30.Base.*;
import KFramework30.Communication.dbTransactionClientClass;
import KFramework30.Communication.persistentObjectManagerClass;
import KFramework30.Widgets.DataBrowser.KBrowserDataWriterInterface;
import KFramework30.Widgets.DataBrowser.cellRenderingHookInterface;
import KFramework30.Widgets.DataBrowser.recordClass;
import ProblemDomainComponent.sample_facturaClass;

// system
//import ProblemDomainComponent.pr_newitemClass;
import ProblemDomainComponent.ProdRecItemClass;
import static thoiyk.HumanInterfaceComponent.ProdutionRecordItem.ProdRecItemBrowserClass.ALL_SAMPLERECORD;
import static thoiyk.HumanInterfaceComponent.ProdutionRecordItem.ProdRecItemBrowserClass.SRITEM_BY_SR;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import thoiyk.HumanInterfaceComponent.ProductionRecord.ProdRecBrowserSimpleClass;
import thoiyk.HumanInterfaceComponent.ReceivedOrder.outstandingorderEditDialogClass;



public class ProdRecItemBrowserClass 
extends KDataBrowserBaseClass 
implements 
cellRenderingHookInterface,  // to customize the data at runtime OPTIONAL
KBrowserDataWriterInterface // to make it RW  OPTIONAL
{   
        
        // modes
        static public final int ALL_SAMPLERECORD = 0;
        static public final int SRITEM_BY_SR = 1;
    
	// uses
        private int                             mode;
        private long                            parentID;
        private long                            productID;

	// has - defaulted
        
        
    
    /** Creates new viajeBrowserClass */
    public ProdRecItemBrowserClass(
            KConfigurationClass configurationParam,
            KLogClass logParam,
            JTable tableParam,            
            int modeParam, long parentIDparam,            
            java.awt.Window parentWindow ) throws KExceptionClass
    {
        
            // inherits
            super(
                    configurationParam, logParam,
                    true, tableParam, parentWindow,  
                    ProdRecItemClass.class,
                    ProdRecItemEditDialogClass.class
            );  
            
            // uses   
            mode = modeParam;
            parentID = parentIDparam;
            
	    // has
            
            // set
            setCellDisplayHook( this );
            
            
    }        



    public void initializeTable()
    throws KExceptionClass
    {	      
 

                                            
            if( mode == SRITEM_BY_SR ){   
                
                // this is a read write browsers
                setBrowserSaveListener(this);
                
                if( configuration.getField("databaseType").equals( "oracle" )  ){
                    
                    super.initializeSQLQuery(     

                        // 1 fields                    
                        " sri.id , sri.itemid, vsri.subcategory,vsri.nama itemname, sri.qty, ut.nama unit, sri.comp, sri.tolerance, sri.qtyneed,vdtl.stok, vdtl.podate ||' '|| vdtl.pono  as PO, vdtl.poqty, sri.qtyneed-(vdtl.stok+vdtl.poqty) qtyactual,  vdtl.btbdate ||' '|| vdtl.btbno as btb, vdtl.btbqty, vdtl.qtysisa, vdtl.persenqty  ",    

                        // 2 tables and joins                                                
                        " productionrecorditem sri " +
                       " left join v_sr_item vsri on sri.itemid=vsri.id"  +
                        " left join unittype ut on sri.unittypeid=ut.id"  +
                        " left join v_pr_item_dtl vdtl on sri.id=vdtl.pritemid"    ,

                        // 3 key of primary PDC object
                        "ID"
                            );    
                    
                }else{
                
                    throw new KExceptionClass( "Data base type not recognized " + configuration.getField("databaseType"), null );
                }
                
                               

                setColumnNames( "sri", "ID", "TypeID" );             
               setColumnNames( "sri", "ITEMID", "ItemID" );             
                setColumnNames( "vsri", "SUBCATEGORY", "SubCategory" );             
                setColumnNames( "vsri", "ITEMNAME", "Description" );             
                setColumnNames( "sri", "QTY", "Qty Order" );  
                setColumnNames( "ut", "UNIT", "Unit" );  
                setColumnNames( "sri", "COMP", "Cons" );             
                setColumnNames( "sri", "TOLERANCE", "Tolerance" );             
                setColumnNames( "sri", "QTYNEED", "Qty Need" );  
                setColumnNames( "sri", "STOK", "Stock" ); 
                setColumnNames( "sri", "PO", "PO No & Date" ); 
                setColumnNames( "sri", "POQTY", "Qty PO" ); 
                setColumnNames( "sri", "QTYACTUAL", "Qty Actual" ); 
                setColumnNames( "sri", "BTB", "BTB No & Date" ); 
                setColumnNames( "sri", "BTBQTY", "Qty BTB" ); 
                setColumnNames( "sri", "QTYSISA", "+/-" ); 
                setColumnNames( "sri", "PERSENQTY", "+/- (%)" ); 


                                
                // replace criteria
                setDefaultCriteria( " samplerecordid = ? " );               
                bindDefaultParameter1( ":samperecordid",  parentID  );     
                
            }else{  // mode = ALL_INVOICES
                
                // this is NOT a read write browsers
                //setBrowserSaveListener(this);
                
              if( configuration.getField("databaseType").equals( "oracle" )  ){
                    
                    super.initializeSQLQuery(     

                        // 1 fields                    
                        " sri.id , sri.itemid, vsri.subcategory,vsri.nama itemname, sri.qty,ut.nama unit, sri.comp, sri.tolerance, sri.qtyneed ",    

                        // 2 tables and joins                                                
                        " productionrecorditem sri " +
                       " left join v_sr_item vsri on sri.itemid=vsri.id"   +
                        " left join unittype ut on sri.unittypeid=ut.id"     ,

                        // 3 key of primary PDC object
                        "ID"
                            );    
                    
                }else{
                
                    throw new KExceptionClass( "Data base type not recognized " + configuration.getField("databaseType"), null );
                }               
                
                // FOR ALL INVOICES
                

                setColumnNames( "sri", "ID", "TypeID" );             
               setColumnNames( "sri", "ITEMID", "ItemID" );             
                setColumnNames( "vsri", "SUBCATEGORY", "SubCategory" );             
                setColumnNames( "vsri", "ITEMNAME", "Description" );             
                setColumnNames( "sri", "QTY", "Qty Order" );  
                setColumnNames( "ut", "UNIT", "Unit" );  
                setColumnNames( "sri", "COMP", "Cons" );             
                setColumnNames( "sri", "TOLERANCE", "Tolerance" );             
                setColumnNames( "sri", "QTYNEED", "Qty Need" );  
                setColumnNames( "sri", "STOK", "Stock" ); 
                setColumnNames( "sri", "PO", "PO No & Date" ); 
                setColumnNames( "sri", "POQTY", "Qty PO" ); 
                setColumnNames( "sri", "QTYACTUAL", "Qty Actual" ); 
                setColumnNames( "sri", "BTB", "BTB No & Date" ); 
                setColumnNames( "sri", "BTBQTY", "Qty BTB" ); 
                setColumnNames( "sri", "QTYSISA", "+/-" ); 
                setColumnNames( "sri", "PERSENQTY", "+/- (%)" ); 
     
                
            }

            setDefaultOrder( "itemid" );
                                
            
           super.initializeTable();             

            adjustColumnWidth( "TypeID", 50 );
            adjustColumnWidth( "ItemID", 50 );
            adjustColumnWidth( "SubCategory", 100 );
            adjustColumnWidth( "Qty Order", 80 );
            adjustColumnWidth( "Unit", 80 );
            adjustColumnWidth( "Cons", 80 );            
            adjustColumnWidth( "Tolerance", 80 );
            adjustColumnWidth( "Qty Need", 80 );
            adjustColumnWidth( "Stock", 80 );
            adjustColumnWidth( "PO No & Date", 80 );
            adjustColumnWidth( "Qty PO", 80 );
            adjustColumnWidth( "Qty Actual", 80 );
            adjustColumnWidth( "BTB No & Date", 80 );
            adjustColumnWidth( "Qty BTB", 80 );
            adjustColumnWidth( "+/-", 80 );
            adjustColumnWidth( "+/- (%)", 80 );
            
            
          //  adjustColumnType( "Date", BROWSER_COLUMN_TYPE_DATE ); // so that autofilter will use date format
           
            if( mode == SRITEM_BY_SR ){                        
                
                
                //DATE -->>
     //           setColumnRenderer("Date", new CalendarCellRendererClass(tableModel, log)); //<-- no necessary and looks awful
      //          setColumnEditor("Date", new CalendarCellEditorClass(tableModel, log));
                //DATE -->>
                
                
                
                // OK box
//                setColumnRenderer("OK", new CheckBoxCellRendererClass(tableModel, log) );
//                setColumnEditor("OK", new CheckBoxCellEditorClass(tableModel, log) );                
//                adjustColumnWidth( "OK", 30 );            
                
               
                
                // STATUS COMBO
        //        dbTransactionClientClass query = new dbTransactionClientClass(configuration, log);
        //        query.prepare( " select FACSTATUS_STATUS from SAMPLE_FACTURA_STATUS " );
        //        query.executeQuery( 0 , 999 );                  
         //       Vector< String > options = new Vector< String >();
         //       while( query.fetch() ) options.add( (String )query.getField( "FACSTATUS_STATUS" ) );                
                
         //       setColumnEditor("STATUS", new ComboCellEditorClass( options,  tableModel, log, true ) );
         //       setColumnRenderer("STATUS", new ComboCellRendererClass( options, tableModel, log) );
                   
                // TOTAL
                // for the total, leave the default text editor assigned when set to editable
                
            }
            
//            adjustColumnType( "TOTAL", BROWSER_COLUMN_TYPE_CURRENCY );
            
 //           adjustColumnFont(  "id",  new Font( "arial", Font.PLAIN, 10  ) );            
  //          adjustColumnFont(  "Name",  new Font( "arial", Font.PLAIN, 10 )  );                        
   //         adjustColumnFont(  "Date",  new Font( "arial", Font.PLAIN, 10 )  );                        
   //         adjustColumnFont(  "STATUS",  new Font( "arial", Font.PLAIN, 10 )  );                        
   //         adjustColumnFont(  "TOTAL",  new Font( "arial", Font.BOLD, 10 )  );            
                       
    }        

    
    //----------------------------------------------------
    
       // Fired on browser save action, either by button called or user browser.save ...
       // Required because it is RW, and implements KBrowserDataWriterInterface
       // OPTIONAL , if no RW  remove this and the implements  KBrowserDataWriterInterface
        // For a bare minimums example better see the productBrowserClass
    
        @Override
        public void save( java.util.List< String > fieldNames, java.util.List< recordClass > data ){                
            
            try {            
            
                // load status
                Properties invoiceStatusProp = new Properties();
                dbTransactionClientClass query = new dbTransactionClientClass(configuration, log);
                query.prepare( " select FACSTATUS_ID, FACSTATUS_STATUS from SAMPLE_FACTURA_STATUS " );
                query.executeQuery(0, 999);
                while( query.fetch() ){
                    invoiceStatusProp.put( query.getField("FACSTATUS_STATUS"), query.getField("FACSTATUS_ID") );
                }
                                                    
                // for you to see
                Iterator dataRowChanged = data.iterator();
                while( dataRowChanged.hasNext() ){
                    
                    recordClass currentRow = (recordClass) dataRowChanged.next();

                    // materialize object
                    sample_facturaClass factura = new sample_facturaClass();

                    persistentObjectManagerClass pom = new persistentObjectManagerClass(configuration, log) ;
                    factura = (sample_facturaClass) pom.copy4( KMetaUtilsClass.getIntegralNumericValueFromString(  (String) currentRow.getValueAt(6) ), factura.getClass()  );
                                       
                    // update it
                    
                    // OK box
                    
                        String OKbox = (String) currentRow.getValueAt(0);
                        // will return ture or false for the checkbox
                        // not used in this example. This is a sample on how to read it
                    
                    // DATE
                        factura.setFacDate(                                 
                                KMetaUtilsClass.stringToDate(
                                    KMetaUtilsClass.KDEFAULT_LONG_DATE_TIME_FORMAT, (String) currentRow.getValueAt(3)  ) );

                    // STATUS
                        factura.setFacstatusId( KMetaUtilsClass.getIntegralNumericValueFromString( invoiceStatusProp.getProperty( (String) currentRow.getValueAt(4) ) ) );
                        
                    // TOTAL
                        factura.setFacTotal( KMetaUtilsClass.getCurrencyNumericValueFromString( (String)currentRow.getValueAt(5) ) );

                    // save it
                    factura = (sample_facturaClass) pom.update4( KMetaUtilsClass.getIntegralNumericValueFromString( (String)currentRow.getValueAt(6) ), factura);

                }
                
            } catch (KExceptionClass error) {
                
                // log error
                log.log( this, KMetaUtilsClass.getStackTrace( error ) );		                
                // show error message
                KMetaUtilsClass.showErrorMessageFromException( getParentWindow(), error );                

            }
                
            
           
        
    }      
  
  // ---------------------------------------------------------------------------     
        
        // These two are OPTIONAL to show how to customize the rendering
        // Used because it immplements cellRenderingHookInterface
        // Remove immplements and functions if not required
        // For a bare minimums example better see the productBrowser.class
        
        public void cellEditHook(int row, int col, boolean isSelected, Component editor, String ColumnName, String value, recordClass record, KLogClass log) throws KExceptionClass {
                 // not customizing the editor
        }          

        public void cellRenderingHook( 
            int row, int col, // what cell are we executing for 
            boolean isSelected, // is it currently highlited ?
            Component renderer, // here is the renderer, change it, or replaze it altogether
            String ColumnName, String value,  // data
            recordClass record, // the whole row data
            KLogClass log ) // the log used
            throws KExceptionClass               
        {
            boolean updateRenderer = false;

            // -----------------------------------------------------------------------                                    
            if( ColumnName.equals( "TOTAL" ) ) {

                if( KMetaUtilsClass.getCurrencyNumericValueFromString( value ) < 0 ){ 

                    renderer.setForeground( Color.red ); 

                    if( isSelected  )renderer.setBackground( Color.yellow );

                    updateRenderer = true;
                }

            }                
            // -----------------------------------------------------------------------            
           
        }
        
        
    // ----------------------------------------------------------------------
    // ----------------------------------------------------------------------
    // Event handling
    // ----------------------------------------------------------------------
    // ----------------------------------------------------------------------


  @Override
  public void newButtonActionPerformed() // need override default to set foreing keys to parent
   
  {       
      
        try{            
            
                // ------------------------------------------------
                // when not inside a client edit dialog
            
                        if( mode == ALL_SAMPLERECORD ){

                            // build a client browser
                               ProdRecBrowserSimpleClass pr_new = new ProdRecBrowserSimpleClass(
                                        configuration, log, new javax.swing.JTable(), getParentWindow() );

                               pr_new.initializeTable();   


                               selectDialogClass selector = new selectDialogClass( 
                                       configuration, log, getParentWindow(), pr_new, "Select Production Record Item" );

                               // dont want to allow this, for example
                               selector.getNewButton().setEnabled(false);
                               selector.getDeleteButton().setEnabled(false);                       

                               productID = selector.showDialog();
                               log.log( this,"---------------------------------------\nparentID:"+parentID);        

                               if( parentID == -1 ) throw new KExceptionClass( "You must select a production record for the pr_newitem!", null);
                        }

                // when not inside a client edit dialog
                // ------------------------------------------------               
                        
                        
            
                
                HashMap foreingKeys = new HashMap();
                foreingKeys.put( "itemid", productID );                                             
                foreingKeys.put( "samplerecordid", parentID );
                super.newButtonActionPerformed( foreingKeys ); 
                
                
        }
        catch( Exception error	){            
                log.log( this, KMetaUtilsClass.getStackTrace( error ) );		                
                KMetaUtilsClass.showErrorMessageFromException( getParentWindow(), error );
        }
 
                     
  }
  
  


}
