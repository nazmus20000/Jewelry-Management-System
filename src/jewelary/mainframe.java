package jewelary;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class mainframe extends javax.swing.JFrame {
    public mainframe() {
    	new DBManager();
//    	new LicenseDB();
    	initComponents();
        setLocationRelativeTo(null);
        setTitle("Sonali Jewellers");
    }
    
    private void initComponents() {
    	this.setResizable(false);
    	this.setMinimumSize(new Dimension(650,450));
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setJMenuBar(new MenuBarHome(this).prepareMenuBarHome());
    	
    	try {
    		URL iconurl = getClass().getResource("res/Icon_Main.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		this.setIconImage(icon.getImage());
		} catch (Exception e) {
		}
    	
        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        OthersButton = new javax.swing.JButton();
        sellButton = new javax.swing.JButton();
        StockSummery_buton = new javax.swing.JButton();
        AcountInfoBut = new javax.swing.JButton();
        ShowPendingBut = new javax.swing.JButton();
        ExchangeBut = new javax.swing.JButton();
        AdvancePayBut = new javax.swing.JButton();
        AddProductBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        welcomeLabel.setText("   SONALI JEWELLERS");

        OthersButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OthersButton.setText("Others");
        OthersButton.setPreferredSize(new java.awt.Dimension(100, 23));
        OthersButton.addActionListener(new cliked());

        sellButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sellButton.setText("Sell");
        sellButton.setActionCommand("Sell");
        sellButton.setPreferredSize(new java.awt.Dimension(100, 23));
        sellButton.addActionListener(new cliked());

        StockSummery_buton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        StockSummery_buton.setText("Stock");
        StockSummery_buton.setActionCommand("stock");
        StockSummery_buton.setPreferredSize(new java.awt.Dimension(100, 23));
        StockSummery_buton.addActionListener(new cliked());
        AcountInfoBut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AcountInfoBut.setText("Accounts");
        AcountInfoBut.setActionCommand("AcountInfo");
        AcountInfoBut.addActionListener(new cliked());
        AcountInfoBut.setPreferredSize(new java.awt.Dimension(100, 23));

        ShowPendingBut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ShowPendingBut.setText("Show Pending");
        ShowPendingBut.setActionCommand("pending");
        ShowPendingBut.addActionListener(new cliked());

        ExchangeBut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ExchangeBut.setText("Exchange");
        ExchangeBut.setActionCommand("Exchange");
        ExchangeBut.addActionListener(new cliked());

        AdvancePayBut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AdvancePayBut.setText("Advance Payment");
        AdvancePayBut.setActionCommand("Advance");
        AdvancePayBut.addActionListener(new cliked());
        

        AddProductBut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddProductBut.setText("Add Product");
        AddProductBut.setActionCommand("add");
        AddProductBut.addActionListener(new cliked());
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sellButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(AcountInfoBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StockSummery_buton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(OthersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ExchangeBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(ShowPendingBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(AdvancePayBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddProductBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowPendingBut, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OthersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExchangeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdvancePayBut, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StockSummery_buton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddProductBut, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AcountInfoBut, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void OthersButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:

    }                                            

    private void ShowPendingButActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//    	try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
    	
//    	//password works -mm-
//    	PassDB pdb = new PassDB();
//    	pdb.createPassDB();
//    	if(pdb.checkProtection()) {
//    		int chk = pdb.checkPass();
//    		if(chk == 2) {
//    			return;    		
//    		}
//    		if(chk == 0) {
//    			JOptionPane.showMessageDialog(new JFrame(), "Incorrect Password! Program exiting...", "Wrong Password", JOptionPane.ERROR_MESSAGE);
//    			return;
//    		}
//    	}
//    	//password works -mm-

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AcountInfoBut;
    private javax.swing.JButton AddProductBut;
    private javax.swing.JButton AdvancePayBut;
    private javax.swing.JButton ExchangeBut;
    private javax.swing.JButton OthersButton;
    private javax.swing.JButton ShowPendingBut;
    private javax.swing.JButton StockSummery_buton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton sellButton;
    public javax.swing.JLabel welcomeLabel;
    // End of variables declaration  
  
}
