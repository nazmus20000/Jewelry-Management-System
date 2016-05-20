package jewelary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PassDB {
	
	public PassDB() {
//		createPassDB();
	}
	
	Connection conn;
	Connection conn1;
	Statement st;
	Statement st2;
	ResultSet dbres;
	ResultSet dbres1;
	ResultSet dbres2;
	String myqurey;
	String myqurey1;
	String myqurey2;
	
	public void createPassDB() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:stdb.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name='PASS_STNG_TABLEE';";
			dbres = st.executeQuery(myqurey1);
			if(!dbres.next()) {
				myqurey1 = 	"CREATE TABLE PASS_STNG_TABLEE (PASS_STATUS INTEGER);";
				st.executeUpdate(myqurey1);
				myqurey1 = "INSERT INTO PASS_STNG_TABLEE(PASS_STATUS) VALUES(1)";
				st.executeUpdate(myqurey1);
			}
			dbres.close();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name='PASS_VALUE_TABLEE';";
			dbres = st.executeQuery(myqurey1);
			if(!dbres.next()) {
				myqurey1 = 	"CREATE TABLE PASS_VALUE_TABLEE (PASS_VALUE TEXT);";
				st.executeUpdate(myqurey1);
				myqurey1 = "INSERT INTO PASS_VALUE_TABLEE(PASS_VALUE) VALUES('000000')";
				st.executeUpdate(myqurey1);
			}
			dbres.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from createPassDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	public String getPass() {
		String pass = null;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:stdb.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM PASS_VALUE_TABLEE;";
			dbres = st.executeQuery(myqurey1);
			pass = dbres.getString("PASS_VALUE");
			dbres.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from getPass()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
		return pass;
	}
	
	public int checkPass() {
		String pass = getPass();
		int permission = 0;
		JPasswordField pwd = new JPasswordField(8);
		int i = JOptionPane.showConfirmDialog(null, pwd, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
		if(i == JOptionPane.OK_OPTION && String.valueOf(pwd.getPassword()).equals(pass)) 
			permission = 1;
		else if(i == JOptionPane.CANCEL_OPTION)
			permission = 2;
		else {
			permission = 0;
		}
		return permission;
	}
	
	public void changePass(String newpass) {
		int chk = 0;
		try {
			conn1 = null;
			st2 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:stdb.db");
			st2 = conn1.createStatement();
			chk = checkPass();
			if(chk == 2)
				return;
			if(chk == 0) {
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect Password!", "Access Denied", JOptionPane.ERROR_MESSAGE);
	    		return;
			}
			myqurey1 = "UPDATE PASS_VALUE_TABLEE set PASS_VALUE='"+newpass+"';";
			st2.executeUpdate(myqurey1);
			JOptionPane.showMessageDialog(new JFrame(), "Password Changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
			st2.close();
			conn1.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from changePass()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean checkProtection() {
		boolean protection = true;
		int i;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:stdb.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM PASS_STNG_TABLEE;";
			dbres = st.executeQuery(myqurey1);
			i = dbres.getInt("PASS_STATUS");
			if(i==1)
				protection = true;
			else
				protection = false;
			dbres.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from checkProtection()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
		return protection;
	}
	
	public void enableProtection() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:stdb.db");
			st = conn.createStatement();
			myqurey1 = "UPDATE PASS_STNG_TABLEE set PASS_STATUS=1;";
			st.executeUpdate(myqurey1);
			JOptionPane.showMessageDialog(new JFrame(), "Password protection Enabled!", "Enabled", JOptionPane.INFORMATION_MESSAGE);
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from enableProtection()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void disableProtection() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:stdb.db");
			st = conn.createStatement();
			myqurey1 = "UPDATE PASS_STNG_TABLEE set PASS_STATUS=0;";
			st.executeUpdate(myqurey1);
			JOptionPane.showMessageDialog(new JFrame(), "Password Protection disabled!", "Disabled", JOptionPane.INFORMATION_MESSAGE);
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from disableProtection()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
