package jewelary;

import java.awt.*;

import javax.swing.*;

public class Mainframe_Final extends Thread {
	private mainframe a;
	public Mainframe_Final(){
		
		// auto-gen
//		try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Exchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Exchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Exchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Exchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
		// -auto gen end
		
		a=new mainframe();
		a.setVisible(true);
	}
	public void run(){
		int color=0;
	 while(1>0){
		 try{
		 if(color%3==0){
			a.welcomeLabel.setForeground(Color.BLUE);
		 }
		 else if(color%3==1){
//			 a.welcomeLabel.setForeground(Color.GRAY);
			 a.welcomeLabel.setForeground(new Color(218,165,32));
		 }
		 else if(color%3==2){
//			 a.welcomeLabel.setForeground(Color.MAGENTA);
			 a.welcomeLabel.setForeground(new Color(0,191,255));
		 }
		 Thread.sleep(1000);
		 }
		 catch(Exception e){
			 
		 }
		 color++;
	 }
	}
	public static void main(String [] args){
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
    		try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Exchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Exchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Exchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Exchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
		
		//License checking
		LicenseDB lic = new LicenseDB();
		lic.checkLicense();
		// end of License Checking
		
		//password works -mm-
    	PassDB pdb = new PassDB();
    	pdb.createPassDB();
    	if(pdb.checkProtection()) {
    		int chk = pdb.checkPass();
    		if(chk == 2) {
    			System.exit(0);
    		}
    		if(chk == 0) {
    			JOptionPane.showMessageDialog(null, "Incorrect Password! Program exiting...", "Access Denied", JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}
    	}
    	//password works -mm-
		Mainframe_Final m=new Mainframe_Final();
		m.start();
	}

}
