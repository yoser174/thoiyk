/*
This source code is part of the Thoyik
Copyright (C) 2013  Yoserizal
Feedback / Bug Reports yoser174@gmail.com


This project used:
KFRAMEWORK  (http://k-framework.sourceforge.net/)
 */

package thoiyk.HumanInterfaceComponent.BTBDetail;


// k
import KFramework30.Base.*;
import KFramework30.Widgets.KDialogControllerClass;

//app
import KFramework30.Widgets.KDialogControllerClass.KDialogInterface;
import KFramework30.Widgets.KDropDownFillerClass;
import KFramework30.Widgets.selectDialogClass;
import ProblemDomainComponent.BTBDetailClass;
//import ProblemDomainComponent.productionrecordClass;
import java.util.Map;
import thoiyk.HumanInterfaceComponent.v_po_item.v_po_itemBrowserSimpleClass;
//import thoiyk.HumanInterfaceComponent.PurchaseOrder.PurchaseOrderBrowserClass;

// rtl


public class BTBDetailEditDialogClass 
extends javax.swing.JDialog
implements KDialogInterface
{
    
    // uses
    private KConfigurationClass             configuration;
    private KLogClass                       log;
    private long                            parentID;
   
    // has defaulted   
    private KDialogControllerClass            KDialogController;

    
    //end of object persistent functions------------------------------------------------------

    /** Creates new form facturaEditDialogClass */
    public BTBDetailEditDialogClass( 
        KConfigurationClass configurationParam, KLogClass logParam, java.awt.Window parentWindow )
        throws KExceptionClass
    {
        
        super( parentWindow, java.awt.Dialog.ModalityType.DOCUMENT_MODAL );
        initComponents ();
        pack ();
//        setSize( 630, 600 );
        KMetaUtilsClass.centerInScreen( this );
        
        // uses
        configuration = configurationParam;
        log = logParam;
        
        // has - defaulted     
        KDialogController = new KDialogControllerClass(                 
                configuration, log, 
                BTBDetailClass.class, this, getContentPane() );        
                            
    }
    
    
    public void initializeDialog(int dialogModeParam, Long ID, Map foreingKeys ) throws KExceptionClass {
        
         
       KDropDownFillerClass typeComboFiller1 = new KDropDownFillerClass(
                        configuration, log, 
                        //SQL, might have parameters and where clause or order by
                        " select ID,  NAMA from UNITTYPE ",
                        "ID", currCombo, "ItemUnitID"
                        );

        typeComboFiller1.load();        
        KDialogController.addNonVisibleWidget( typeComboFiller1 );  // to map it           

   
           KDropDownFillerClass typeComboFiller2 = new KDropDownFillerClass(
                        configuration, log, 
                        //SQL, might have parameters and where clause or order by
                        " select ID,  NAMA from UNITTYPE ",
                        "ID", currCombo1, "ActualUnitID"
                        );

        typeComboFiller2.load();        
        KDialogController.addNonVisibleWidget( typeComboFiller2 );  // to map it           

   

        // start
        KDialogController.initializeDialog( dialogModeParam, ID, foreingKeys  );
                 
        
        /*
           persistentObjectManagerClass POM = new persistentObjectManagerClass(configuration, log);
         // read the client of this invoice, no SQL anywhere ...
                pr_newClass sample = new pr_newClass();
                sample = ( pr_newClass ) POM.copy4( ((pr_newClass)KDialogController.getCurrentObjectDisplayed()).getId(), pr_newClass.class );

                descriptionLabel.setText( sample.getDescription() );
          */      
                // ---------------------------------------------------------------------        

        checkSecurity();
        
    }
    
    //---------------------------------------------------------------------------
    
    private void checkSecurity()
    throws KExceptionClass
    {
  
    }
    
    //---------------------------------------------------------------------------
    
    @Override   
    public void setupTables( long id )
    throws KExceptionClass
    {
                       
        
                        
    }
     
    public void saveBrowserChanges() {
        
        
    }    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientDiscountGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblTelp = new javax.swing.JLabel();
        qtyLabel = new javax.swing.JTextField();
        lblHp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        toleranceLabel = new javax.swing.JTextField();
        system_user_id1 = new javax.swing.JLabel();
        lblID1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LblItemID = new javax.swing.JLabel();
        lblNama1 = new javax.swing.JLabel();
        createdbyLbl = new javax.swing.JLabel();
        lblNama2 = new javax.swing.JLabel();
        LblAuditUser = new javax.swing.JLabel();
        currCombo = new javax.swing.JComboBox();
        currCombo1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Bukti Terima Barang (BTB) Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 10))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        lblID.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblID.setText("ID");

        ID.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        ID.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ID.setName("ID"); // NOI18N

        lblNama.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblNama.setText("Select Item");

        lblTelp.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblTelp.setText("Qty Item");

        qtyLabel.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        qtyLabel.setName("ItemQty"); // NOI18N

        lblHp.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblHp.setText("Unit Item");
        lblHp.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel1.setText("Qty Actual");

        toleranceLabel.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        toleranceLabel.setName("ActualQty"); // NOI18N

        system_user_id1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        system_user_id1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        system_user_id1.setName("HdrID"); // NOI18N

        lblID1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblID1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblID1.setText("HDRID");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel2.setText("Unit Actual");

        LblItemID.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        LblItemID.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LblItemID.setName("ItemID"); // NOI18N

        lblNama1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblNama1.setText("Audit Date");

        createdbyLbl.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        createdbyLbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        createdbyLbl.setName("AuditDate"); // NOI18N

        lblNama2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblNama2.setText("Audit User");

        LblAuditUser.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        LblAuditUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LblAuditUser.setName("AuditUser"); // NOI18N

        currCombo.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        currCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IDR", "USD" }));
        currCombo.setName("TypeIDSelect"); // NOI18N
        currCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currComboActionPerformed(evt);
            }
        });

        currCombo1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        currCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IDR", "USD" }));
        currCombo1.setName("TypeIDSelect"); // NOI18N
        currCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currCombo1ActionPerformed(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblID1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblNama)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTelp)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblHp)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblNama2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblNama1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(createdbyLbl, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(LblAuditUser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(qtyLabel)
                    .add(currCombo, 0, 164, Short.MAX_VALUE)
                    .add(toleranceLabel)
                    .add(currCombo1, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(LblItemID, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .add(system_user_id1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(ID, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(ID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(system_user_id1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblID1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(lblNama)
                    .add(LblItemID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(lblTelp)
                    .add(qtyLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(lblHp)
                    .add(currCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel1)
                    .add(toleranceLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel2)
                    .add(currCombo1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(lblNama1)
                    .add(createdbyLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(lblNama2)
                    .add(LblAuditUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        okButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        applyButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        applyButton.setText("Apply"); // NOI18N
        applyButton.setName("applyButton"); // NOI18N
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(okButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(CancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(applyButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(layout.createSequentialGroup()
                .add(58, 58, 58)
                .add(okButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10)
                .add(CancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10)
                .add(applyButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
        
  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        try {
            LblAuditUser.setText(configuration.getField( "system_user_name" ));

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
  
  
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
  
        setVisible (false);
        dispose ();
        
    }//GEN-LAST:event_closeDialog

private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
    
        try {

            KDialogController.OKbuttonActionPerformed();
                            
        } catch (KExceptionClass error ) {

              // log error
              log.log( this, KMetaUtilsClass.getStackTrace( error ) );

              // show error message
              KMetaUtilsClass.showErrorMessageFromException(  getOwner(), error );               
        }    
    
    
}//GEN-LAST:event_applyButtonActionPerformed

    private void currComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            v_po_itemBrowserSimpleClass supplierBrowser = new v_po_itemBrowserSimpleClass(
                configuration, log, new javax.swing.JTable(), this );

            supplierBrowser.initializeTable();

            selectDialogClass selector = new selectDialogClass(
                configuration, log, this, supplierBrowser, "Select Production Record Item" );

            // dont want to allow this, for example
            selector.getNewButton().setEnabled(false);
            selector.getDeleteButton().setEnabled(false);
            parentID = selector.showDialog();

            LblItemID.setText( Long.toString(parentID));

            if( parentID < 0 )
            {
                throw new KExceptionClass( "You must select a Supplier !", null);

            }
            else
            {

                // ---------------------------------------------------------------------
                // display the supplier name
/*                persistentObjectManagerClass POM = new persistentObjectManagerClass(configuration, log);
                supplierClass supplier = new supplierClass();
                supplier = ( supplierClass ) POM.copy4( parentID, supplierClass.class );

                suppnameLbl.setText( supplier.getNama() );
  */
                // ---------------------------------------------------------------------
            }

        }
        catch( Exception error	){
            log.log( this, KMetaUtilsClass.getStackTrace( error ) );
            KMetaUtilsClass.showErrorMessageFromException( this, error );
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void currCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currCombo1ActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel LblAuditUser;
    private javax.swing.JLabel LblItemID;
    private javax.swing.JButton applyButton;
    private javax.swing.ButtonGroup clientDiscountGroup;
    private javax.swing.JLabel createdbyLbl;
    private javax.swing.JComboBox currCombo;
    private javax.swing.JComboBox currCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHp;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNama1;
    private javax.swing.JLabel lblNama2;
    private javax.swing.JLabel lblTelp;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField qtyLabel;
    private javax.swing.JLabel system_user_id1;
    private javax.swing.JTextField toleranceLabel;
    // End of variables declaration//GEN-END:variables


    
    
}
