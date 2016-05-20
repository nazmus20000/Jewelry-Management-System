package jewelary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

public class PassSettings {
	
	JDialog passstframe;
	JButton changebutton;
	JButton enablebutton;
	JLabel statuslabel;
	
	String buttonname1 = "Enable Password Protection";
	String buttonname2 = "Disable Password Protection";
	
	public PassSettings() {
		preparePassSettingWin();
		passstframe.setLocationRelativeTo(null);
		passstframe.setVisible(true);
		passstframe.setResizable(false);
	}
	
	public void preparePassSettingWin() {
		passstframe = new JDialog();
		passstframe.setSize(300, 300);
		passstframe.setTitle("Password Settings");
		passstframe.setLayout(null);
		passstframe.setModal(true);
		passstframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		passstframe.setResizable(true);
		
		try {
    		URL iconurl = getClass().getResource("res/Pass_Icon.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		passstframe.setIconImage(icon.getImage());
		} catch (Exception e) {
		}
		
		changebutton = new JButton("Change Password");
		changebutton.setBounds(80, 40, changebutton.getPreferredSize().width, 40);
		
		statuslabel = new JLabel();
		enablebutton = new JButton();
		if(new PassDB().checkProtection()) {
			enablebutton.setText(buttonname2);
			statuslabel.setText("<html>Password protection currently <font color=green size=+1>Enabled</font></html>");
		}
		else {
			enablebutton.setText(buttonname1);
			statuslabel.setText("<html>Password protection currently <font color=red size=+1>Disabled</font></html>");
		}
		statuslabel.setBounds(40, 140, statuslabel.getPreferredSize().width, statuslabel.getPreferredSize().height);
		enablebutton.setBounds(60, 170, enablebutton.getPreferredSize().width, 40);
		
		
		passstframe.add(changebutton);
		passstframe.add(statuslabel);
		passstframe.add(enablebutton);
		
		changebutton.setActionCommand("Change_Pass");
		changebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String newpass = null;
				JPasswordField pwdnew = new JPasswordField(8);
				int i = JOptionPane.showConfirmDialog(null, pwdnew, "Enter New Password", JOptionPane.OK_CANCEL_OPTION);
				if(i == JOptionPane.OK_OPTION) {
					newpass = String.valueOf(pwdnew.getPassword());
					new PassDB().changePass(newpass);
				}
			}
		});
		
		enablebutton.setActionCommand("Enable_Pass");
		enablebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PassDB pdb = new PassDB();
				if(new PassDB().checkProtection()) {
					int chk = pdb.checkPass();
					if(chk == 2)
						return;
					if(chk == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Incorrect Password!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
			    		return;
					}
					new PassDB().disableProtection();
					enablebutton.setText(buttonname1);
					statuslabel.setText("<html>Password protection currently <font color=red size=+1>Disabled</font></html>");
					statuslabel.setBounds(40, 140, statuslabel.getPreferredSize().width, statuslabel.getPreferredSize().height);
				}
				else {
					int chk = new PassDB().checkPass();
					if(chk == 2)
						return;
					if(chk == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Incorrect Password!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
			    		return;
					}
					new PassDB().enableProtection();
					enablebutton.setText(buttonname2);
					statuslabel.setText("<html>Password protection currently <font color=green size=+1>Enabled</font></html>");
				}
			}
		});
	}
	
}
