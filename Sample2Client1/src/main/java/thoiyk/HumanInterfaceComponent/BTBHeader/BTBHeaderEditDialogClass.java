/*
 * This source code is part of the Thoyik
 * Copyright (C) 2013  Yoserizal
 * Feedback / Bug Reports yoser174@gmail.com
 * 
 * 
 * This project used:
 * KFRAMEWORK  (http://k-framework.sourceforge.net/)
 */


package thoiyk.HumanInterfaceComponent.BTBHeader;

/**
 *
 * @author yoserizy
 */

// rtl
import KFramework30.Base.*;
import KFramework30.Communication.dbTransactionClientClass;
import KFramework30.Communication.persistentObjectManagerClass;
import KFramework30.Printing.KPrintDataTableClass;
import KFramework30.Printing.KPrintJobClass;
import KFramework30.Printing.KPrintSectionClass;
import java.util.Map;

// app
import Sample1.UserCustomWidgets.JCalendarDemoWidgetAdapterClass;

// fwk
import KFramework30.Widgets.KDialogControllerClass;
import KFramework30.Widgets.KDialogControllerClass.KDialogInterface;
import KFramework30.Widgets.KDropDownFillerClass;
import KFramework30.Widgets.selectDialogClass;
import ProblemDomainComponent.BTBHeaderClass;
import ProblemDomainComponent.PurchaseOrderClass;
//import ProblemDomainComponent.BTBTypeClass;
import ProblemDomainComponent.supplierClass;
import java.awt.Font;
import java.awt.print.PageFormat;
import thoiyk.HumanInterfaceComponent.BTBDetail.BTBDetailBrowserClass;
import thoiyk.HumanInterfaceComponent.PurchaseOrder.PurchaseOrderBrowserClass;
import thoiyk.HumanInterfaceComponent.supplier.supplierBrowserClass;


public class BTBHeaderEditDialogClass 
extends javax.swing.JDialog
implements KDialogInterface, KDialogControllerClass.KDialogEventCallbackInterface
{
    
// uses
    private KConfigurationClass             configuration;
    private KLogClass                       log;
    private long                            parentID;
   
    // has defaulted   
    private BTBDetailBrowserClass             browser;   
    private KNonVisibleBinaryWidgetClass    productPictureRawDataContainer;
    private KDialogControllerClass            KDialogController;

    

    /** Creates new form facturaEditDialogClass */
    public BTBHeaderEditDialogClass( 
        KConfigurationClass configurationParam, KLogClass logParam, java.awt.Window parentWindow )
        throws KExceptionClass
{
        
        super( parentWindow, java.awt.Dialog.ModalityType.DOCUMENT_MODAL );
        initComponents ();
        pack ();
       // setSize( 630, 600 );
        KMetaUtilsClass.centerInScreen( this );
        
        // uses
        configuration = configurationParam;
        log = logParam;
        
        // has - defaulted     
        KDialogController = new KDialogControllerClass(                 
                configurationParam, logParam, 
                BTBHeaderClass.class, 
                this, getContentPane() );   
                         
        
        KDialogController.setEventCallback(this);


                            
    }
        
    
    public void initializeDialog(int dialogModeParam, Long ID, Map foreingKeys ) throws KExceptionClass {

        // dont forget to visually set the "name" property to the  field you want to map
        JCalendarDemoWidgetAdapterClass dateChooserAdapter = new JCalendarDemoWidgetAdapterClass( jDateChooser1, "Tanggal" );                
        KDialogController.includeCustomWidgetForMapping( dateChooserAdapter ); 
        JCalendarDemoWidgetAdapterClass dateChooserAdapter3 = new JCalendarDemoWidgetAdapterClass( jDateChooser3, "TglSJ" );                
        KDialogController.includeCustomWidgetForMapping( dateChooserAdapter3 );                
        JCalendarDemoWidgetAdapterClass dateChooserAdapter4 = new JCalendarDemoWidgetAdapterClass( jDateChooser4, "TglBC" );                
        KDialogController.includeCustomWidgetForMapping( dateChooserAdapter4 );                
      
        //-------------------------------------------------------------                           

        // start
          KDialogController.initializeDialog( dialogModeParam, ID, null  );

        checkSecurity();
        

    }    

    
    
    //---------------------------------------------------------------------------    
    
    // called when a browser has a row changed ...    
    public void tableToolbarButtonClickedNotification( String action ) {
        
        try {
            
                //  .. since the total might have changed, do a reload of the invoice ->
                KDialogController.edit();
                // .. to load the new total which is controlled by the server
                // ... and avoid a record version changed error, for optimitic locking.
                            
        } catch (KExceptionClass error ) {
            
              // log error
              log.log( this, KMetaUtilsClass.getStackTrace( error ) );
              // show error message
              KMetaUtilsClass.showErrorMessageFromException( getOwner(), error );
        }
    }
    
    
    //---------------------------------------------------------------------------
    
    private void checkSecurity()
    throws KExceptionClass
    {
        
    }
        
    // called from browser when a user clicked save.....  for editable browsers, see client dialog for examples
    @Override        
    public void saveBrowserChanges() {     
    }    
    
    @Override
    public void setupTables(long id) throws KExceptionClass {

       
        browser = new BTBDetailBrowserClass( 
                //
                 configuration, log,
                POItemBrowserJTable,
                BTBDetailBrowserClass.POITEM_BY_PO, 
                id,
                
                 this );
                
        browser.initializeTable();
        
        // register me to be notified for actions on rows, see implement above -> tableToolbarButtonClickedNotification
//        browser.addButtonActionListener( this );
        
        //setup container button
        newButton.addActionListener( browser );
        deleteButton.addActionListener( browser );
        editButton.addActionListener( browser );        
        sortButton.addActionListener( browser );
        filterButton.addActionListener( browser );     
        printButton.addActionListener( browser );   
        refreshButton.addActionListener( browser );          
//        saveChangesButton1.addActionListener( browser );  

//        saveChangesButton1.setEnabled( true);        
//        newButton.setEnabled( true);
        deleteButton.setEnabled( true);
        editButton.setEnabled( true);        
        sortButton.setEnabled( true);
        filterButton.setEnabled( true);
        printButton.setEnabled( true);
        refreshButton.setEnabled( true); 
    }
    
    
    //----------------------------------------------------------------------
  
        
   

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        okButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        idLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        issuedbyLbl = new javax.swing.JLabel();
        client_id6 = new javax.swing.JLabel();
        SupplierID = new javax.swing.JLabel();
        suppnameLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        issuedbyLbl1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        issuedbyLbl2 = new javax.swing.JLabel();
        printGraphButton1 = new javax.swing.JButton();
        Supplier_Text04Edit = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Supplier_Text04Edit1 = new javax.swing.JTextField();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        Supplier_Text04Edit2 = new javax.swing.JTextField();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        issuedbyLbl3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        poidLbl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        topLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        POItemBrowserJTable = new javax.swing.JTable();
        DesktopToolbar = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        sortButton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        printButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        refreshButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(100, 100));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okButton.setBounds(670, 90, 80, 20);
        jLayeredPane1.add(okButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        CancelButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        CancelButton.setBounds(670, 120, 80, 20);
        jLayeredPane1.add(CancelButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        applyButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        applyButton.setText("Apply"); // NOI18N
        applyButton.setName("applyButton"); // NOI18N
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        applyButton.setBounds(670, 150, 80, 20);
        jLayeredPane1.add(applyButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BTB Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        jDateChooser1.setName("TanggalPick"); // NOI18N

        idLbl.setText("ID");

        jLabel4.setText("Tanggal");

        jLabel5.setText("SupplierID");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("CreatedBy");

        issuedbyLbl.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        issuedbyLbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        issuedbyLbl.setName("CreatedBy"); // NOI18N

        client_id6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        client_id6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        client_id6.setName("ID"); // NOI18N

        SupplierID.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        SupplierID.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SupplierID.setName("SupplierID"); // NOI18N

        suppnameLbl.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        suppnameLbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        suppnameLbl.setName("SupplierName"); // NOI18N

        jLabel7.setText("TglSJ");

        jLabel9.setText("NoBC");

        jLabel10.setText("DateCreated");

        issuedbyLbl1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        issuedbyLbl1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        issuedbyLbl1.setName("DateCreated"); // NOI18N

        jLabel11.setText("ModifiedBy");

        issuedbyLbl2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        issuedbyLbl2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        issuedbyLbl2.setName("ModifiedBy"); // NOI18N

        printGraphButton1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        printGraphButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/print1.gif"))); // NOI18N
        printGraphButton1.setText("print");
        printGraphButton1.setToolTipText("Print Porduct In");
        printGraphButton1.setActionCommand("edit");
        printGraphButton1.setFocusable(false);
        printGraphButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printGraphButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        printGraphButton1.setMaximumSize(new java.awt.Dimension(80, 40));
        printGraphButton1.setMinimumSize(new java.awt.Dimension(80, 40));
        printGraphButton1.setPreferredSize(new java.awt.Dimension(80, 40));
        printGraphButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printGraphButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printGraphButton1ActionPerformed(evt);
            }
        });

        Supplier_Text04Edit.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Supplier_Text04Edit.setName("Nomor"); // NOI18N

        jLabel16.setText("NoSJ");

        jLabel3.setText("Nomor");

        Supplier_Text04Edit1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Supplier_Text04Edit1.setName("NoSJ"); // NOI18N

        jDateChooser3.setName("NoSJPick"); // NOI18N

        Supplier_Text04Edit2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Supplier_Text04Edit2.setName("NoBC"); // NOI18N

        jDateChooser4.setName("TglBCPick"); // NOI18N

        jLabel13.setText("TglBC");

        issuedbyLbl3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        issuedbyLbl3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        issuedbyLbl3.setName("DateModified"); // NOI18N

        jLabel14.setText("DateModified");

        poidLbl.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        poidLbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        poidLbl.setName("POID"); // NOI18N

        jButton2.setText("Pick from PO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 23, Short.MAX_VALUE)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jDateChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(Supplier_Text04Edit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(298, 298, 298)
                        .add(printGraphButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel11)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(issuedbyLbl2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel14)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(issuedbyLbl3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(idLbl)
                                .add(58, 58, 58)
                                .add(client_id6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(104, 104, 104)
                                .add(poidLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(1, 1, 1)
                                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .add(69, 69, 69))
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .add(jLabel16)
                                            .add(43, 43, 43))
                                        .add(jPanel1Layout.createSequentialGroup()
                                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jLabel9)
                                                .add(jLabel7)
                                                .add(jLabel13))
                                            .add(41, 41, 41)))
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jDateChooser3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(Supplier_Text04Edit1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(Supplier_Text04Edit2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jDateChooser4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(jLabel5)
                                    .add(18, 18, 18)
                                    .add(SupplierID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(suppnameLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 291, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(jLabel8)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(issuedbyLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jLabel10)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(issuedbyLbl1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .add(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(idLbl)
                    .add(client_id6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(poidLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(printGraphButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(Supplier_Text04Edit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(jDateChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(1, 1, 1)
                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(jLabel5)
                                                .add(jButton1))
                                            .add(SupplierID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, suppnameLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                            .add(jLabel16)
                                            .add(Supplier_Text04Edit1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .add(jLabel4))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jDateChooser3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel7))
                        .add(3, 3, 3)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(Supplier_Text04Edit2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel9))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jDateChooser4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel13))
                        .add(18, 18, 18)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(issuedbyLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel8)
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(issuedbyLbl1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel10)))
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(17, 17, 17)
                                    .add(jLabel11))
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(7, 7, 7)
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(issuedbyLbl3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel14))))
                            .add(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(issuedbyLbl2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .add(8, 21, Short.MAX_VALUE))
        );

        jPanel1.setBounds(0, 60, 660, 330);
        jLayeredPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        topLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        topLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/topBar.jpg"))); // NOI18N
        topLabel.setMaximumSize(new java.awt.Dimension(100, 44));
        topLabel.setMinimumSize(new java.awt.Dimension(100, 44));
        topLabel.setBounds(0, -13, 770, 650);
        jLayeredPane1.add(topLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        POItemBrowserJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(POItemBrowserJTable);

        DesktopToolbar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DesktopToolbar.setFloatable(false);
        DesktopToolbar.setRollover(true);
        DesktopToolbar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DesktopToolbar.setMargin(new java.awt.Insets(200, 0, 0, 0));
        DesktopToolbar.setMaximumSize(new java.awt.Dimension(367, 42));
        DesktopToolbar.setMinimumSize(new java.awt.Dimension(367, 42));

        newButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new1.jpg"))); // NOI18N
        newButton.setText("New");
        newButton.setToolTipText("Create a link to asociado"); // NOI18N
        newButton.setActionCommand("new");
        newButton.setEnabled(false);
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        newButton.setMaximumSize(new java.awt.Dimension(50, 40));
        newButton.setMinimumSize(new java.awt.Dimension(50, 40));
        newButton.setPreferredSize(new java.awt.Dimension(50, 40));
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        DesktopToolbar.add(newButton);

        editButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit1.jpg"))); // NOI18N
        editButton.setText("Edit");
        editButton.setToolTipText("Edit asociado"); // NOI18N
        editButton.setActionCommand("edit");
        editButton.setEnabled(false);
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        editButton.setMaximumSize(new java.awt.Dimension(45, 40));
        editButton.setMinimumSize(new java.awt.Dimension(45, 40));
        editButton.setPreferredSize(new java.awt.Dimension(45, 40));
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DesktopToolbar.add(editButton);

        deleteButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete1.jpg"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setToolTipText("Remove link to asociado"); // NOI18N
        deleteButton.setActionCommand("delete");
        deleteButton.setEnabled(false);
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        deleteButton.setMaximumSize(new java.awt.Dimension(45, 40));
        deleteButton.setMinimumSize(new java.awt.Dimension(45, 40));
        deleteButton.setPreferredSize(new java.awt.Dimension(45, 40));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DesktopToolbar.add(deleteButton);

        jSeparator1.setMaximumSize(new java.awt.Dimension(15, 32767));
        jSeparator1.setPreferredSize(new java.awt.Dimension(15, 0));
        DesktopToolbar.add(jSeparator1);

        sortButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        sortButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sort.jpg"))); // NOI18N
        sortButton.setText("Sort");
        sortButton.setActionCommand("sort");
        sortButton.setEnabled(false);
        sortButton.setFocusable(false);
        sortButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sortButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        sortButton.setMaximumSize(new java.awt.Dimension(45, 40));
        sortButton.setMinimumSize(new java.awt.Dimension(45, 40));
        sortButton.setPreferredSize(new java.awt.Dimension(45, 40));
        sortButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DesktopToolbar.add(sortButton);

        filterButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        filterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/filter1.jpg"))); // NOI18N
        filterButton.setText("Filter");
        filterButton.setActionCommand("filter");
        filterButton.setEnabled(false);
        filterButton.setFocusable(false);
        filterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        filterButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        filterButton.setMaximumSize(new java.awt.Dimension(45, 40));
        filterButton.setMinimumSize(new java.awt.Dimension(45, 40));
        filterButton.setPreferredSize(new java.awt.Dimension(45, 40));
        filterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DesktopToolbar.add(filterButton);

        jSeparator2.setMaximumSize(new java.awt.Dimension(15, 32767));
        jSeparator2.setPreferredSize(new java.awt.Dimension(15, 0));
        DesktopToolbar.add(jSeparator2);

        printButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/print.jpg"))); // NOI18N
        printButton.setText("Print");
        printButton.setActionCommand("print");
        printButton.setEnabled(false);
        printButton.setFocusable(false);
        printButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        printButton.setMaximumSize(new java.awt.Dimension(60, 40));
        printButton.setPreferredSize(new java.awt.Dimension(60, 40));
        printButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DesktopToolbar.add(printButton);

        jSeparator3.setMaximumSize(new java.awt.Dimension(15, 32767));
        jSeparator3.setPreferredSize(new java.awt.Dimension(15, 0));
        DesktopToolbar.add(jSeparator3);

        refreshButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh1.jpg"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.setActionCommand("refresh");
        refreshButton.setEnabled(false);
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        refreshButton.setMaximumSize(new java.awt.Dimension(60, 40));
        refreshButton.setPreferredSize(new java.awt.Dimension(60, 40));
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DesktopToolbar.add(refreshButton);

        jSeparator4.setMaximumSize(new java.awt.Dimension(15, 32767));
        jSeparator4.setPreferredSize(new java.awt.Dimension(15, 0));
        DesktopToolbar.add(jSeparator4);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLayeredPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
            .add(DesktopToolbar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
            .add(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jLayeredPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 397, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(DesktopToolbar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
        
  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

      
      
      try {
            
            issuedbyLbl.setText(configuration.getField( "system_user_name" ));
            
            


            KDialogController.OKbuttonActionPerformed();

            setVisible (false);
            dispose ();      
                        
        } catch (KExceptionClass error ) {

              // log error
              log.log( this, KMetaUtilsClass.getStackTrace( error ) );

              // show error message
              KMetaUtilsClass.showErrorMessageFromException( getOwner(), error );               
        }
  }//GEN-LAST:event_okButtonActionPerformed
  
  private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
      setVisible (false);
      dispose ();
  }//GEN-LAST:event_CloseButtonActionPerformed
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible (false);
        dispose ();
    }//GEN-LAST:event_closeDialog

private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        try {
            issuedbyLbl.setText(configuration.getField( "system_user_name" ));

            KDialogController.OKbuttonActionPerformed();
                            
        } catch (KExceptionClass error ) {

              // log error
              log.log( this, KMetaUtilsClass.getStackTrace( error ) );

              // show error message
              KMetaUtilsClass.showErrorMessageFromException( getOwner(), error );               
        } 
}//GEN-LAST:event_applyButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            supplierBrowserClass supplierBrowser = new supplierBrowserClass(
                configuration, log, new javax.swing.JTable(), this );

            supplierBrowser.initializeTable();

            selectDialogClass selector = new selectDialogClass(
                configuration, log, this, supplierBrowser, "Select Supplier" );

            // dont want to allow this, for example
            selector.getNewButton().setEnabled(false);
            selector.getDeleteButton().setEnabled(false);
            parentID = selector.showDialog();

            SupplierID.setText( Long.toString(parentID));

            if( parentID < 0 ) 
            {
                throw new KExceptionClass( "You must select a Supplier !", null);
                        
            }            
            else
            {
            
               // ---------------------------------------------------------------------
                // display the supplier name                
                persistentObjectManagerClass POM = new persistentObjectManagerClass(configuration, log);
                supplierClass supplier = new supplierClass();
                supplier = ( supplierClass ) POM.copy4( parentID, supplierClass.class );

                suppnameLbl.setText( supplier.getNama() );
                // ---------------------------------------------------------------------        
            }   

            
        }
        catch( Exception error	){
            log.log( this, KMetaUtilsClass.getStackTrace( error ) );
            KMetaUtilsClass.showErrorMessageFromException( this, error );
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newButtonActionPerformed

    private void printGraphButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printGraphButton1ActionPerformed
        
      try{
          
            log.log( this, "Printing Product In" );
            persistentObjectManagerClass persistentObjectManager = 
                    new persistentObjectManagerClass( configuration, log );             

            //materialize the sdg
         //   BTBHeadersamplerecordClassClass po = new BTBHeaderClass();
         //   po = (BTBHeaderClass) persistentObjectManager.copy4( sdg_id, ASHURSampleDeliveryGroupClass.class );  

            persistentObjectManagerClass POM = new persistentObjectManagerClass(configuration, log);
            //BTBHeaderClass po = new BTBHeaderClass();
            BTBHeaderClass ProdIn = ( BTBHeaderClass ) POM.copy4( ((BTBHeaderClass)KDialogController.getCurrentObjectDisplayed()).getID(), BTBHeaderClass.class );
            
            //materialize Product In Type
            //persistentObjectManagerClass POMProdInType = new persistentObjectManagerClass(configuration, log);
            //BTBTypeClass ProdInType = ( BTBTypeClass ) POMProdInType.copy4( ProdIn.getTypeID(), BTBTypeClass.class );

            //materialize Supplier
            //persistentObjectManagerClass POMSupp = new persistentObjectManagerClass(configuration, log);
            //supplierClass Supp = ( supplierClass ) POMSupp.copy4( ProdIn.getSupplierID(), supplierClass.class );

            //BTBHeaderTermClass poterm = new BTBHeaderTermClass();
            //poterm = (BTBHeaderTermClass) persistentObjectManager.copy4( po.getTermPaymentID(), BTBHeaderTermClass.class );  
            

          //KMetaUtilsClass.showMessage(this,po.getSupplier_Text01() );
            
            // ---------------------------------------------------------------------------------------
            //Header section
            KPrintSectionClass headerSection = new KPrintSectionClass(configuration, log, 520, 140);           

            // Header: Address "Mount Holly"
            headerSection.setFont( new Font( "arial", Font.PLAIN,                        8) ); 
//            headerSection.printText("Kframework Municipal Utilities Authority ",   350, 40 );
//            headerSection.printText("(Certification Number:1234)",              350, 50 );
//            headerSection.printText("300 Saturn Road, PO BOX 486",                350, 60 );
//            headerSection.printText("Mount Everest KA 08060",                         350, 70 );
//            headerSection.printText("Phone 609-123-1223  Fax: 609-123-1234",        350, 80 );
//            headerSection.printText("Email: vmaxxed@users.sourceforge.net",                        350, 90 );
//            
            headerSection.setFont( new Font( "arial", Font.PLAIN,                       12) );
            headerSection.printText("Bukti Terima Barang",          170, 100 );
            headerSection.printLine(170,114,310,114);            
//            headerSection.setFont( new Font( "arial", Font.PLAIN,                        10) );
//            headerSection.printText("Date:",                                          0, 120 );
//            headerSection.printText( KMetaUtilsClass.time(),                          70, 120 );
//            headerSection.printText("Summary #: ",                                  350, 120 );
//            headerSection.printText(Long.toString(po.getID()),                                 405, 120 );
   

            // ---------------------------------------------------------------------------------------
            
            // Address section
//            KPrintSectionClass addressSection = new KPrintSectionClass(configuration, log, 520, 130 );                 
//            addressSection.setFont( new Font( "arial", Font.BOLD, 10) );
//            addressSection.printText("PO No:",                                         0, 20 );
//            addressSection.printText(po.getNomor(),                                    0, 30 );
//            addressSection.printText("Ship To:",                               350, 20 );
//            addressSection.printText("Ship To:",                               350, 20 );
   
            KPrintSectionClass leftTopSection = new KPrintSectionClass(configuration, log, 520, 130 );                 
  /*          leftTopSection.setFont( new Font( "arial", Font.PLAIN, 10) );
            leftTopSection.printText("PO No",                                         0, 20 );
            leftTopSection.printText(po.getNomor(),                                   40, 20 );
            leftTopSection.printText("Date",                                          0, 30 );
            leftTopSection.printText(po.getPODate().toLocaleString(),                 40, 30 );
            leftTopSection.printText("To",                                            0, 40 );
            leftTopSection.printText(po.getSupplier_Text01(),                         40, 40 );
            leftTopSection.printText(po.getSupplier_Text02(),                         40, 50 );
            leftTopSection.printText(po.getSupplier_Text03(),                         40, 60 );
            leftTopSection.printText("Atn.",                                           0, 70 );
            leftTopSection.printText(po.getSupplier_Text04(),                         40, 70 );
            
*/
           // KPrintSectionClass rightTopSection = new KPrintSectionClass(configuration, log, 520, 130 );                 
            leftTopSection.setFont( new Font( "arial", Font.PLAIN, 10) );
//            leftTopSection.printText("Ship To",                                         320, 20 );
            leftTopSection.printText("Pintu Mas Garmindo PT",                           0, 20 );
            leftTopSection.printText("Jl.Raya Dramarga Km 7 No 61",                     0, 30 );
            leftTopSection.printText("Kab.Bogor Jawa Barat 16650",                      0, 40 );
//            leftTopSection.printText("NPWP",                                            0, 50 );
//            leftTopSection.printText("123.123.123.123",                                 0, 60 );
            leftTopSection.printText("Phone: +62 123456 Fax: +62 212334",               0, 50 );
//            leftTopSection.printText("Atn.",                                            320, 70 );
//            leftTopSection.printText("Arum / Ibu Lisye",                                360, 70 );

            
            // informasi BTB
            leftTopSection.printText("NO",                              300, 20 );
            leftTopSection.printText(ProdIn.getNomor(),                 360, 20 );
            leftTopSection.printText("Tgl",                             300, 30 );
            leftTopSection.printText(ProdIn.getTanggal().toString(),    360, 30 );
            leftTopSection.printText("Supplier",                        300, 40 );
            leftTopSection.printText(ProdIn.getSupplierName(),          360, 40 );
            leftTopSection.printText("NoSJ",                            300, 50 );
            leftTopSection.printText(ProdIn.getNoSJ(),                  360, 50 );
            leftTopSection.printText("TglSJ",                           300, 60 );
//            leftTopSection.printText(ProdIn.getTglSJ().toString(),      360, 60 );
            
            // heading and Analytical Testing Service Summary
            // get a KePrintJob
            KPrintJobClass printJob = 
                new KPrintJobClass( configuration, log ); 

            PageFormat fixedPageFormat = ( PageFormat ) KPrintJobClass.defaultPageFormat.clone();
            fixedPageFormat.setOrientation( PageFormat.PORTRAIT );
            
            printJob.useSpecificPrintingDefaults(
                KPrintJobClass.defaultPrinterJob, fixedPageFormat );   

            // start job 
            printJob.setDefaultFont( new Font("Arial", Font.PLAIN, 10) );  
            printJob.setLeftMargin( 50 );
            printJob.setBottomMargin( 40 );
           
            printJob.startPrintJob();   //pop up system print dialog box            
            
            printJob.SetHeader( headerSection, KPrintJobClass.CENTER );                         
            
            printJob.printSection( leftTopSection, KPrintJobClass.CENTER );
            //printJob.printSection( rightTopSection, KPrintJobClass.CENTER );
            
            
           dbTransactionClientClass dbTransaction = 
           new dbTransactionClientClass( configuration, log ); 

            dbTransaction.prepare(

                " select rownum no, namabarang,jumlah,unit,pono,prno,style,actualqty " +
                 // End Fields used in the receipt
                 //--------------------------------------------------
                 "from "+
                 "v_productin_dtl vdtl " +
                " where " +
                    "vdtl.hdrid=:v1 " );

                dbTransaction.bind( ":v1",  ProdIn.getID() );                  
                dbTransaction.executeQuery( 0, 655356 );
                // --------------------------------------------------------    
                
               //to get analysis info
                //dbTransactionClientClass AnalysisdbTransaction = 
                  //  new dbTransactionClientClass( configuration, log ); 
                    
                //for each sample, print sample and get analysis info
                //while( dbTransaction.fetch() ) { 
                    //print out sample info
                    KPrintSectionClass poitem = new KPrintSectionClass(configuration, log, 520, 90 ); 
                    
                    poitem.setFont( new Font( "arial", Font.PLAIN, 8) );
                    
                    //String valueBuffer = (String) dbTransaction.getProperty( "SAMPLE_LAB_ID" );   
                    // setup the DB printer
                    KPrintDataTableClass dbTable = new KPrintDataTableClass( 
                               configuration, log, 
                               dbTransaction, printJob, 0, 655356 );
                
                    //print anasys info
                    //dbTable.addField( "NO","No",10 );
                    dbTable.addField( "NAMABARANG", "NamaBarang",230 );   
                    dbTable.addField( "JUMLAH","Jumlah",30 );
                    dbTable.addField( "UNIT","Unit",50 );        
                    dbTable.addField( "PONO","PONo",50 );        
                    dbTable.addField( "PRNO","PRNo",50 );        
                    dbTable.addField( "STYLE","Style",50 );        
                    dbTable.addField( "ACTUALQTY","ActualQty",30 ); 
                    //dbTable.addField( "ANALYSIS_CLIENT_PRICE","CLIENT PRICE", 100, KPrintJobClass.RIGHT );                        
                    
                    
                    
                    //dbTable.addSummary( "CLIENT PRICE", KPrintDataTableClass.SUM, "Total: $", null, 2 );
                    
                    
                    //dbTable.setPrintingField( "No" );
                    dbTable.setPrintingField( "NamaBarang" );
                    dbTable.setPrintingField( "Jumlah" );        
                    dbTable.setPrintingField( "Unit" );                        
                    dbTable.setPrintingField( "PONo" );
                    dbTable.setPrintingField( "PRNo" );
                    dbTable.setPrintingField( "Style" );
                    dbTable.setPrintingField( "ActualQty" );
                    
                   
                    
                    
                    // summary
                    //dbTable.addSummary( "Price", KPrintDataTableClass.SUM, null, null, 2 );
                  
                    
                    dbTable.setHorizontalSpace( 10 );
                    printJob.setDefaultFont( new Font("Arial", Font.PLAIN, 8) ); 
                    int oldLeftMargin = printJob.getLeftMargin();
                    printJob.setLeftMargin(40);              
                    dbTable.setHeadersMode( dbTable.HEADER_TYPE_INLINEHEADER );                 
                    
                    dbTable.print();
                    
                    printJob.setDefaultFont( new Font("Arial", Font.PLAIN, 10) );
                    printJob.setLeftMargin(oldLeftMargin);
                   
                    //Footer section
                    KPrintSectionClass footerSection = new KPrintSectionClass(configuration, log, 520, 140);           
                    
                    footerSection.setFont( new Font( "arial", Font.PLAIN, 10) );
                    
                    footerSection.printText("Penerima",         0, 10 );
                    //footerSection.printText(po.getIssuedBy(),0, 30 );
                    footerSection.printText("Kontrol Kualitas", 200, 10 );
                    footerSection.printText("Mengetahui",       400, 10 );
                    
//                    footerSection.printText("Term Payment",                                   0, 120 );
//                    footerSection.printText(poterm.getName(),                                   100, 120 );
//                    footerSection.printText("Delivery Date",                                  0, 130 );
//                    footerSection.printText(po.getDeliveryDate().toLocaleString(),                 100, 130 );
//                    footerSection.printText("Note",                                            0, 140 );
                    
                   
                    
                    printJob.printSection( footerSection, KPrintJobClass.CENTER );
                    //footerSection.printText(po.get,                         40, 40 );

                    //footerSection.printText("Note",                                            0, 40 );

                    
//                    
//                    String valueBuffer = (String) dbTransaction.getProperty( "ITEMNAME" ); 
//                    poitem.printText(valueBuffer,                                    65, 10 );
//                    valueBuffer = (String) dbTransaction.getProperty( "KODE" ); 
//                    poitem.printText(valueBuffer,                                    265, 10 );
//                    valueBuffer = (String) dbTransaction.getProperty( "PRID" ); 
//                    poitem.printText(valueBuffer,                                     365, 10 );
//                    valueBuffer = (String) dbTransaction.getProperty( "QTY" ); 
//                    poitem.printText(valueBuffer,                                     415, 10 );
//                    
//                     printJob.printSection( poitem, KPrintJobClass.CENTER );
                    
                    

                //}
   
                    
                                
            printJob.submitPrintJob();  


            
        }
        catch( Exception error	){
            
                // log error
                log.log( this, KMetaUtilsClass.getStackTrace( error ) );		                
                // show error message
                KMetaUtilsClass.showErrorMessageFromException( this,  error );
        } 
                    
            

    }//GEN-LAST:event_printGraphButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
                        
            PurchaseOrderBrowserClass POBrowser = new PurchaseOrderBrowserClass(
                configuration, log, new javax.swing.JTable(), this );

            POBrowser.initializeTable();

            selectDialogClass selector = new selectDialogClass(
                configuration, log, this, POBrowser, "Select Purchase Order" );

            // dont want to allow this, for example
            selector.getNewButton().setEnabled(false);
            selector.getDeleteButton().setEnabled(false);
            parentID = selector.showDialog();

//            SupplierID.setText( Long.toString(parentID));

            if( parentID < 0 ) 
            {
                throw new KExceptionClass( "You must select a Purchase Order !", null);
                        
            }            
            else
            {
            
                poidLbl.setText( Long.toString(parentID) );

                persistentObjectManagerClass persistentObjectManager = 
                    new persistentObjectManagerClass( configuration, log );
                
                PurchaseOrderClass po = new PurchaseOrderClass();
                supplierClass supp = new supplierClass();
                
                po = (PurchaseOrderClass) persistentObjectManager.copy4( parentID, PurchaseOrderClass.class );  
                
                supp = (supplierClass) persistentObjectManager.copy4( po.getSupplierID(), supplierClass.class );  
                
                SupplierID.setText(Long.toString(supp.getId()));
                suppnameLbl.setText(supp.getNama());

            }   

            
        }
        catch( Exception error	){
            log.log( this, KMetaUtilsClass.getStackTrace( error ) );
            KMetaUtilsClass.showErrorMessageFromException( this, error );
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JToolBar DesktopToolbar;
    private javax.swing.JTable POItemBrowserJTable;
    private javax.swing.JLabel SupplierID;
    private javax.swing.JTextField Supplier_Text04Edit;
    private javax.swing.JTextField Supplier_Text04Edit1;
    private javax.swing.JTextField Supplier_Text04Edit2;
    private javax.swing.JButton applyButton;
    private javax.swing.JLabel client_id6;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel idLbl;
    private javax.swing.JLabel issuedbyLbl;
    private javax.swing.JLabel issuedbyLbl1;
    private javax.swing.JLabel issuedbyLbl2;
    private javax.swing.JLabel issuedbyLbl3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JButton newButton;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel poidLbl;
    private javax.swing.JButton printButton;
    private javax.swing.JButton printGraphButton1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton sortButton;
    private javax.swing.JLabel suppnameLbl;
    private javax.swing.JLabel topLabel;
    // End of variables declaration//GEN-END:variables
   
    
    @Override
    public void preNewObject() throws Exception {
    }

    @Override
    public void postNewObject(KBusinessObjectClass businessObject) throws Exception {
    }

    @Override
    public void prePushBack(KBusinessObjectClass businessObject) throws Exception {
    }

    @Override
    public void postPushBack(KBusinessObjectClass businessObject) throws Exception {
    }

    @Override
    public void preEdit() throws Exception {
    }

    @Override
    public void postEdit(KBusinessObjectClass businessObject) throws Exception {
  
        /*
        pr_newClass product = (pr_newClass) businessObject;
        if( product.getImage() != null ){
            
            pictureLabel.setIcon(  new ImageIcon( product.getImage() ) );            
        }
        * */
        
        
    }

    @Override
    public void preUpdate(KBusinessObjectClass businessObject) throws Exception {
    }

    @Override
    public void postUpdate(KBusinessObjectClass businessObject) throws Exception {
    }    
    
    
}
