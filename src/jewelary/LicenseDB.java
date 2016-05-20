package jewelary;

import java.sql.*;

import javax.swing.*;

public class LicenseDB {
	
	String mainKey = "1234MMMM1234MMMM";
	
	Connection conn, conn1, conn2;
	Statement st, st1, st2;
	ResultSet dbres, dbres1, dbres2, dbres3;
	String myqurey, myqurey1, myqurey2, myqurey3;
	
	Connection conn5;
	Statement st5;
	String myqurey5;
	ResultSet dbres5;
	
	public LicenseDB() {
		createLicenseDB();
	}

	public void createLicenseDB() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:lst.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name='L_STNG_TABLEE';";
			dbres = st.executeQuery(myqurey1);
			if(!dbres.next()) {
				myqurey1 = 	"CREATE TABLE L_STNG_TABLEE (L_STATUS TEXT);";
				st.executeUpdate(myqurey1);
				myqurey1 = "INSERT INTO L_STNG_TABLEE(L_STATUS) VALUES('UNREGISTERED')";
				st.executeUpdate(myqurey1);
			}
			dbres.close();
			st.close();
			conn.close();
			createValidityDB();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+
					" -mm- Error from createLicenseDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}		
	}
	
	public void checkLicense() {
		String currStatus = null;
		String currValidity = null;
		String inpKey = null;
		String msgOk = "<html><center><font color=blue size=+1>Congratulations!</font><br><br>Product successfully <font color=green>registered!</font></center></html>";
		String msgErr = "<html><center>This product is <font color=red>not registered!</font><br><br>Please <font color=red size=+1>register!</font><br><br>The software is exiting...</center></html>";
		try {
			conn = null;
			st = null;
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:lst.db");
			st = conn.createStatement();
			conn1 = DriverManager.getConnection("jdbc:sqlite:regKey.db");
			st1 = conn1.createStatement();
			conn2 = DriverManager.getConnection("jdbc:sqlite:../winSystem.db");
			st2 = conn2.createStatement();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name='KEY_TABLEE';";
			dbres = st1.executeQuery(myqurey1);
			if(!dbres.next()) {
				myqurey1 = "CREATE TABLE KEY_TABLEE (KEY_VALUE TEXT);";
				st1.executeUpdate(myqurey1);
			}
			myqurey1 = "SELECT * FROM KEY_TABLEE;";
			dbres1 = st1.executeQuery(myqurey1);
			if(dbres1.next()) {
				inpKey = dbres1.getString("KEY_VALUE");
				if(inpKey.equals(mainKey)) {
					myqurey = "UPDATE L_STNG_TABLEE SET L_STATUS='REGISTERED';";
					st.executeUpdate(myqurey);
					myqurey = "DELETE FROM KEY_TABLEE;";
					st1.executeUpdate(myqurey);
					myqurey = "INSERT INTO VALIDITY_TABLEE (VALIDITY_STATUS) VALUES('VALID') ;";
					st2.executeUpdate(myqurey);
					JOptionPane.showMessageDialog(null, msgOk, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			myqurey2 = "SELECT * FROM L_STNG_TABLEE;";
			dbres2 = st.executeQuery(myqurey2);
			if(dbres2.next()) {
				currStatus = dbres2.getString("L_STATUS");
				if(currStatus.equals("UNREGISTERED")) {
					JOptionPane.showMessageDialog(null, msgErr, "Unregistered Product", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				myqurey = "SELECT * FROM VALIDITY_TABLEE;";
				dbres3 = st2.executeQuery(myqurey);
				if(dbres3.next()) {
					currValidity = dbres3.getString("VALIDITY_STATUS");
					if(currStatus.equals("REGISTERED") && currValidity.equals("VALID")) {
						return;
					}
					else {
						JOptionPane.showMessageDialog(null, msgErr, "Unregistered Product", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, msgErr, "Unregistered Product", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
			st2.close();
			conn2.close();
			dbres1.close();
			st1.close();
			conn1.close();
			dbres2.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+
					" -mm- Error from createLicenseDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void createValidityDB() {
		try {
			conn5 = null;
			st5 = null;
			Class.forName("org.sqlite.JDBC");
			conn5 = DriverManager.getConnection("jdbc:sqlite:../winSystem.db");
			st5 = conn5.createStatement();
			myqurey5 = "SELECT * FROM sqlite_master WHERE type='table' AND name='VALIDITY_TABLEE';";
			dbres5 = st5.executeQuery(myqurey5);
			if(!dbres5.next()) {
				myqurey5 = "CREATE TABLE VALIDITY_TABLEE (VALIDITY_STATUS TEXT);";
				st5.executeUpdate(myqurey5);
			}
			dbres5.close();
			st5.close();
			conn5.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+
					" -mm- Error from createValidityDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}
	}
	
}
