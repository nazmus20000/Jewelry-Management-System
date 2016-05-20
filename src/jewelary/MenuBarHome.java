package jewelary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.*;


public class MenuBarHome {
	
	JFrame mainframeinmenu;
	
	JMenuBar menubar;
	JMenu filemenu;
	JMenuItem clearitem;
	JMenuItem okitem;
	JMenuItem backupitem;
	JMenuItem exititem;
	JMenu helpmenu;
	JMenuItem devinfoitem;
	JMenuItem aboutitem;
	JMenu settingsmenu;
	JMenuItem passsettingsitem;
	JMenu toolsmenu;
	JMenuItem adminitem, delitem;
	
	String aboutmsg =  "<html>"+
			"<center><font color=Blue size=+1>Sonali Jewellers Management</font><br>"+
			"Version 2.0.0.1<br><br>"+
			"Version Release Date- <br>"+
			"<br><br><br></html>";
	
	public MenuBarHome() {
	}
	
	public MenuBarHome(JFrame frame) {
		this.mainframeinmenu = frame;
	}
	
	public JMenuBar prepareMenuBarHome() {
		menubar= new JMenuBar();
		
		filemenu= new JMenu("File");
		filemenu.setMnemonic(KeyEvent.VK_F);
		okitem= new JMenuItem("OK");
		okitem.setActionCommand("okmenuclicked_w1");
		clearitem= new JMenuItem("Clear");
		clearitem.setActionCommand("clearmenu");
		
		backupitem = new JMenuItem("Backup Database");
		backupitem.setMnemonic(KeyEvent.VK_B);
		try {
				URL iconurl = getClass().getResource("res/Backup_Icon.png");
	    		ImageIcon icon = new ImageIcon(iconurl);
	    		backupitem.setIcon(icon);
		} catch (Exception e) {
		}
		backupitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int res;
				PassDB dbOb = new PassDB();
				res = dbOb.checkPass();
				if(res == 1) {
					int yes = JOptionPane.showConfirmDialog(null, "Backup Database?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if(yes==JOptionPane.YES_OPTION) {
						backupDatabase();
					}
				}
				else if(res == 0) {
					JOptionPane.showMessageDialog(null, "Incorrect Password!", "Access Denied", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		exititem = new JMenuItem("Exit", KeyEvent.VK_X);
		try {
			URL iconurl = getClass().getResource("res/Exit_Icon.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		exititem.setIcon(icon);
		} catch (Exception e) {
		}
		exititem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				mainframeinmenu.dispose();
				System.exit(0);
			}
		});

		filemenu.add(backupitem);
		filemenu.addSeparator();
		filemenu.add(exititem);
		
		settingsmenu = new JMenu("Settings");
		settingsmenu.setMnemonic(KeyEvent.VK_S);
		passsettingsitem = new JMenuItem("Password Settings", KeyEvent.VK_P);
		try {
			URL iconurl = getClass().getResource("res/Pass_Icon.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		passsettingsitem.setIcon(icon);
		} catch (Exception e) {
		}
		settingsmenu.add(passsettingsitem);
		passsettingsitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new PassSettings();
			}
		});
		
		helpmenu = new JMenu("Help");
		helpmenu.setMnemonic(KeyEvent.VK_H);
		devinfoitem = new JMenuItem("Developers Info", KeyEvent.VK_D);
		try {
			URL iconurl = getClass().getResource("res/dev4.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		devinfoitem.setIcon(icon);
		} catch (Exception e) {
		}
		devinfoitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				move a=new move();
				a.start();
//				JOptionPane.showMessageDialog(new StringMove(), null, "Developers Info", JOptionPane.NO_OPTION, null);
			}
		});
		
		aboutitem = new JMenuItem("About this software", KeyEvent.VK_A);
		try {
			URL iconurl = getClass().getResource("res/About_Icon.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		aboutitem.setIcon(icon);
		} catch (Exception e) {
		}
		
		aboutitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon icon1 = null;
				try {
					URL iconurl1 = getClass().getResource("res/Icon_About_In.png");
		    		icon1 = new ImageIcon(iconurl1);
				} catch (Exception e) {
				}
				JOptionPane.showMessageDialog(null, aboutmsg, "About This Software", JOptionPane.INFORMATION_MESSAGE, icon1);
			}
		});
		
		
		helpmenu.add(devinfoitem);
		helpmenu.add(aboutitem);
		
		toolsmenu = new JMenu("Tools");
		adminitem = new JMenuItem("Administrative Tools");
		try {
			URL iconurl = getClass().getResource("res/Admin_Icon.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		adminitem.setIcon(icon);
		} catch (Exception e) {
		}
		adminitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Tools();
			}
		});
		delitem = new JMenuItem("Delete a token");
		
		toolsmenu.add(adminitem);
		
		menubar.add(filemenu);
		menubar.add(settingsmenu);
//		menubar.add(toolsmenu);
		menubar.add(helpmenu);
		
		return menubar;
	}
	
	public void backupDatabase() {
		try {
			Runtime.getRuntime().exec("cmd /C start backUp.bat");
			JOptionPane.showMessageDialog(new JFrame(), "Backup created in \"C:\\Database Backup\"", "Success", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error backing up database!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
