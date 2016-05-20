package jewelary;

import java.net.URL;

import javax.swing.*;

public class Tools extends JDialog{
	
	JButton btnProdReset, btnTknRestart, btnCidRestart, btnTidRestart, btnAccReset, btnAppReset;
	
	public Tools() {
		prepareTools();
		addCompsTools();
		showTools();
	}
	
	public void prepareTools() {
		this.setLayout(null);
		this.setTitle("Administrative Tools");
		try {
    		URL iconurl = getClass().getResource("res/Admin_Icon1.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		this.setIconImage(icon.getImage());
		} catch (Exception e) {
		}
		this.setSize(450, 500);
		this.setModal(true);
	}
	
	public void addCompsTools() {
		btnAccReset = new JButton("Reset Account Details");
		btnAccReset.setToolTipText("All \"Accounts\" data will be deleted");
		btnAppReset = new JButton("Reset Software to Factory Default");
		btnAppReset.setToolTipText("All data in the database will be deleted.");
		btnAccReset.setBounds(40, 40, (int)btnAccReset.getPreferredSize().getWidth(), 30);
		this.add(btnAccReset);
	}
	
	public void showTools() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
