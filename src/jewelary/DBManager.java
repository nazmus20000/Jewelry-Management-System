package jewelary;

import java.sql.*;

import javax.swing.*;

public class DBManager {
	
	public DBManager() {
		createDB();
		createDBDailyStockDB();
		createDB_2();
		createDBTokenDB();
		createDBAccountsDB();
		createDBMakerDB();
	}
	
	Connection conn, conn1, conn2, conn3, conn4;
	Statement st, st1, st2, st3, st4;
	ResultSet dbres, dbres1, dbres2, dbres3, dbres4, dbres5, dbres6;
	String myqurey, myqurey1, myqurey2, myqurey3, myqurey4;
	int flag, flag2, flag3, flag4, flag5, flag6, flag7, flag8, flag9, flag10;
	boolean soldflag, bookedflag, exchangeflag;
	
	public void createDB() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name='MAIN_TABLEE';";
			dbres = st.executeQuery(myqurey1);
			if(!dbres.next()) {
				myqurey1 = 	"CREATE TABLE MAIN_TABLEE "
						+ "(P_TOKEN 		TEXT			,"
						+ " P_WEIGHT		REAL			,"
						+ "	P_ID 			TEXT 			,"
						+ "	P_NAME 			TEXT 			,"
						+ "	P_STATUS 		TEXT 			,"
						+ "	DATE_ADDED 		TEXT			,"
						+ "	DATE_SOLD 		TEXT	 		,"
						+ "	SELLING_PRICE 	REAL 			,"
						+ "	PAID 			REAL 			,"
						+ "	DUE			 	REAL 			,"
						+ " GOLD			REAL			,"
						+ " STONE			REAL			,"
						+ " CHARGE			REAL			,"
						+ " VAT				REAL			,"
						+ "	C_ID 			TEXT 			,"
						+ "	C_NAME 			TEXT 			,"
						+ "	C_MOBILE 		TEXT 			,"
						+ "	C_ADDR 			TEXT 			,"
						+ "	T_ID 			TEXT 			,"
						+ "	T_TYPE 			TEXT 			,"
						+ "	DATE_BOOKING 	TEXT	 		);";
				st.executeUpdate(myqurey1);
			}
			dbres.close();
			
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from createDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void createDBDailyStockDB() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:dldb.db");
			st = conn.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name='DATE_MGR_ADD';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				myqurey1 = "CREATE TABLE DATE_MGR_ADD (LAST_DATE TEXT);";
				st.executeUpdate(myqurey1);
				myqurey1 = "INSERT INTO DATE_MGR_ADD (LAST_DATE) VALUES('BEGIN');";
				st.executeUpdate(myqurey1);
			}
			dbres.close();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name='DATE_MGR_SELL';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				myqurey1 = "CREATE TABLE DATE_MGR_SELL (LAST_DATE TEXT);";
				st.executeUpdate(myqurey1);
				myqurey1 = "INSERT INTO DATE_MGR_SELL (LAST_DATE) VALUES('BEGIN_SELL');";
				st.executeUpdate(myqurey1);
			}
			dbres.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from createDBDailyStockDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void createDBTokenDB() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:tkdb.db");
			st = conn.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name='TOKEN_COUNTER_TABLEE';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				myqurey = "CREATE TABLE TOKEN_COUNTER_TABLEE (P_NAME TEXT, TOKEN_LAST INTEGER);";
				st.executeUpdate(myqurey);
//				myqurey = "INSERT INTO TOKEN_COUNTER_TABLEE(P_NAME, TOKEN_LAST) VALUES('DEFAULT', 1);";
//				st.executeUpdate(myqurey);
			}
			dbres.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from createDBTokenDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void createDBAccountsDB() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:acddb.db");
			st = conn.createStatement();
			st.close();
			conn.close();
			
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:acedb.db");
			st = conn.createStatement();
			st.close();
			conn.close();
			
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:acdb.db");
			st = conn.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name='DATE_MGR_ACCOUNTS';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				myqurey1 = "CREATE TABLE DATE_MGR_ACCOUNTS (LAST_DATE TEXT);";
				st.executeUpdate(myqurey1);
				myqurey1 = "INSERT INTO DATE_MGR_ACCOUNTS (LAST_DATE) VALUES('BEG_DATE1');";
				st.executeUpdate(myqurey1);
			}
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name='ACCOUNT_BALANCE';";
			dbres1 = st.executeQuery(myqurey1);
			if(!dbres1.next()) {
				myqurey2 = "CREATE TABLE ACCOUNT_BALANCE "
						+ "(DATE 			TEXT	,"
						+ "BALANCE			REAL	,"
						+ "BEG_BALANCE		REAL	,"
						+ "LAST_DATE 		TEXT	);";
				st.executeUpdate(myqurey2);
				myqurey2 = "INSERT INTO ACCOUNT_BALANCE (DATE, BALANCE, BEG_BALANCE, LAST_DATE)"
						 + " VALUES('BEG_DATE2', 0, 0, 'BEFORE_BEG');";
				st.executeUpdate(myqurey2);
			}
			dbres1.close();
			dbres.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from createDBAccountsDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void createDBMakerDB() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:mkdb.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name='MAKER_TABLEE';";
			dbres1 = st.executeQuery(myqurey1);
			if(!dbres1.next()) {
				myqurey1 = "CREATE TABLE MAKER_TABLEE "
						+ "(DATE 		TEXT	,"
						+ "	ITEM_NO 	TEXT	,"
						+ "	GIVE	 	TEXT	,"
						+ "	RECIEVE		TEXT	);";
				st.executeUpdate(myqurey1);
			}
			dbres1.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from createDBMakerDB()", "Database Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void addNewProductDB(String date, int qty, String pid, String pname, JTextField []tokenlist, JTextField []weightlist) {
		String tok;
		double weight;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			for(int i=0; i<qty; i++) {
				String msg = "<html>wrong token at <font color=red size=+1> "+(i+1)+" </font>!</html>";
				tok = tokenlist[i].getText();
				myqurey = "SELECT * FROM MAIN_TABLEE WHERE P_TOKEN='"+tok+"' AND P_NAME='"+pname+"';";
				dbres = st.executeQuery(myqurey);
				if(dbres.next()) {
					JOptionPane.showMessageDialog(new JFrame(), msg, "Wrong Input", JOptionPane.WARNING_MESSAGE);
					dbres.close();
					st.close();
					conn.close();
					return;
				}
			}
			int yes = JOptionPane.showConfirmDialog(null, "Add to database?", "Confirmaion", JOptionPane.YES_NO_OPTION);
			if(yes==JOptionPane.YES_OPTION) {
				try {
					for(int i=0; i<qty; i++) {
						tok = tokenlist[i].getText();
						weight = Double.valueOf(weightlist[i].getText());
						myqurey = "INSERT INTO MAIN_TABLEE"
								+ "(P_TOKEN, P_WEIGHT, P_ID, P_NAME, P_STATUS, DATE_ADDED)"
								+ "VALUES('"+tok+"', "+weight+", '"+pid+"', '"+pname+"', "+"'AVAILABLE', '"+date+"');";
						st.executeUpdate(myqurey);
					}
				} catch (Exception e) {
					return;
				}
				JOptionPane.showMessageDialog(new JFrame(), "Added to Database!" , "Success", JOptionPane.INFORMATION_MESSAGE);
				incTokenDB4(pname, qty);
				addProdToDailyStockDB5(date, pid, pname, qty);
			}
			st.close();
			conn.close();
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from addNewProductDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void bookProductDB(String date, String tid, String pname, int qty, JTextField []tokenfieldlist, String cid, String cname, String cmob, String caddr, double gold, double stone, double charge, double vat, double total, double paid, double due) {
		boolean exists;
		String tok;
		String msgbook = "<html>Product <font color=blue size=+1>Booked!</font></html>";
		String msgsellwrong1 = "<html><font color=red size=+1>Token not in Database!</font></html>";
		String msgsellwrong2 = "<html>Product <font color=red size=+1>not Available!</font></html>";
		String []tokenListForExport = new String[qty];
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			for(int i=0; i<qty; i++) {
				tok = tokenfieldlist[i].getText();
				myqurey = "SELECT * FROM MAIN_TABLEE WHERE P_TOKEN='"+tok+"' AND P_NAME='"+pname+"';";
				dbres = st.executeQuery(myqurey);
				if(!dbres.next()) {
					JOptionPane.showMessageDialog(new JFrame(), msgsellwrong1, "Wrong Input", JOptionPane.WARNING_MESSAGE);
					dbres.close();
					st.close();
					conn.close();
					return;
				}
				myqurey = "SELECT * FROM MAIN_TABLEE WHERE P_TOKEN='"+tok+"' AND P_NAME='"+pname+"' AND P_STATUS='AVAILABLE';";
				dbres = st.executeQuery(myqurey);
				if(!dbres.next()) {
					JOptionPane.showMessageDialog(new JFrame(), msgsellwrong2, "Wrong Input", JOptionPane.WARNING_MESSAGE);
					dbres.close();
					st.close();
					conn.close();
					return;
				}
			}
			dbres.close();
			
			myqurey = "SELECT * FROM MAIN_TABLEE WHERE C_ID = '"+cid+"';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				exists = false;
			}
			else {
				exists = true;
			}
			dbres.close();
			
			int yes = JOptionPane.showConfirmDialog(null, "Book Product?", "Confirmaion", JOptionPane.YES_NO_OPTION);
			if(yes==JOptionPane.YES_OPTION) {
				bookedflag = true;
				for(int i=0; i<qty; i++) {
					tok = tokenfieldlist[i].getText();
					tokenListForExport[i] = tok;
					myqurey = "UPDATE MAIN_TABLEE SET P_STATUS='BOOKED/NO DELIVERY', DATE_SOLD='"
							+date+"', SELLING_PRICE="+total+", PAID="+paid+", DUE="+due+", GOLD="
							+gold+", STONE="+stone+", CHARGE="+charge+", VAT="+vat+", C_ID='"+cid+"', "
							+ "C_NAME='"+cname+"', C_MOBILE='"+cmob+"', C_ADDR='"+caddr+"', T_ID='"
							+tid+"', T_TYPE='ADVANCED', DATE_BOOKING='"+date+"' WHERE P_TOKEN = '"+tok+"' AND P_NAME='"+pname+"';";
//					}
//					else {
//						myqurey = "UPDATE MAIN_TABLEE SET P_STATUS='BOOKED/NO DELIVERY', DATE_SOLD='"
//								+date+"', SELLING_PRICE="+0+", PAID="+0+", DUE="+0+", GOLD="+gold+", STONE="
//								+stone+", CHARGE="+charge+", VAT="+vat+", C_ID='"+cid+"', C_NAME='"+cname+"', C_MOBILE='"
//								+cmob+"', C_ADDR='"+caddr+"', T_ID='"+tid+"', T_TYPE='ADVANCED', DATE_BOOKING='"
//								+date+"' WHERE P_TOKEN = '"+tok+"' AND P_NAME='"+pname+"';";
//					}
					st.executeUpdate(myqurey);
				}
				JOptionPane.showMessageDialog(new JFrame(), msgbook, "Product Booked!", JOptionPane.INFORMATION_MESSAGE);
				//-----
				double gtotal = total*qty;
				new BillCreatorBook(date, tid, cname, cid, cmob, caddr, pname, gold, stone, charge,
						vat, total, qty, gtotal, paid, due, tokenListForExport).createBillBook();
				// update here
				double balance = total*qty;
				updateAccountsTableDB(date, balance);
				addTidIntDB_2();
				if(!exists)
					addCidIntDB_2();
			}
			st.close();
			conn.close();
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from bookProductDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void completePaymentDB(String date, String tid, double paid) {
		String msgbook = "<html>Payment <font color=green size=+1>Completed!</font></html>";
		String pname;
		int qty;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "UPDATE MAIN_TABLEE SET P_STATUS='SOLD', DATE_SOLD='"+date+"', PAID="+paid+
					", DUE=0 WHERE T_ID = '"+tid+"';";
			st.executeUpdate(myqurey);
			JOptionPane.showMessageDialog(new JFrame(), msgbook, "Payment Completed!", JOptionPane.INFORMATION_MESSAGE);
			myqurey1 = "SELECT * FROM MAIN_TABLEE WHERE T_ID='"+tid+"';";
			dbres5 = st.executeQuery(myqurey1);
			dbres5.next();
			pname = dbres5.getString("P_NAME");
			myqurey1 = "SELECT count(*) AS NUM FROM MAIN_TABLEE WHERE T_ID='"+tid+"';";
			dbres6 = st.executeQuery(myqurey1);
			dbres6.next();
			qty = dbres6.getInt("NUM");
			dbres6.close();
			dbres5.close();
			st.close();
			conn.close();
			addSellToDailyStokDB5(date, pname, qty);
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from completePaymentDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void exchangeProductDB(String date, String tid, String pname, int qty, JTextField []tokenfieldlist, String cid, String cname, String cmob, String caddr, double balance) {
		boolean exists, exyes = false;
		String tok;
		String msgwrong1 = "<html>Token  <font color=red size=+1>not in Database!</font></html>";
		String msgwrong2 = "<html>Product  <font color=red size=+1>not Available!</font></html>";
		String msgexch2 = "Exchanged!";
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			for(int i=0; i<qty; i++) {
				tok = tokenfieldlist[i].getText();
				myqurey = "SELECT * FROM MAIN_TABLEE WHERE P_TOKEN='"+tok+"' AND P_NAME='"+pname+"';";
				dbres = st.executeQuery(myqurey);
				if(!dbres.next()) {
					JOptionPane.showMessageDialog(new JFrame(), msgwrong1, "Wrong Input", JOptionPane.WARNING_MESSAGE);
					return;
				}
				myqurey = "SELECT * FROM MAIN_TABLEE WHERE P_TOKEN='"+tok+"' AND P_NAME='"+pname+"' AND P_STATUS='AVAILABLE';";
				dbres = st.executeQuery(myqurey);
				if(!dbres.next()) {
					JOptionPane.showMessageDialog(new JFrame(), msgwrong2, "Wrong Input", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			dbres.close();
			
			myqurey = "SELECT * FROM MAIN_TABLEE WHERE C_ID = '"+cid+"';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				exists = false;
			}
			else {
				exists = true;
			}
			dbres.close();
			
			int yes = JOptionPane.showConfirmDialog(null, "Exchange?", "Confirmaion", JOptionPane.YES_NO_OPTION);
			if(yes==JOptionPane.YES_OPTION) {
				exchangeflag = true;
				exyes = true;
				for(int i=0; i<qty; i++) {
					tok = tokenfieldlist[i].getText();
					myqurey = "UPDATE MAIN_TABLEE SET P_STATUS='SOLD', DATE_SOLD='"+date+"', SELLING_PRICE="
							+balance+", PAID="+balance+", DUE=0, C_ID='"+cid+"', C_NAME='"+cname+"', C_MOBILE='"
							+cmob+"', C_ADDR='"+caddr+"', T_ID='"+tid+"', T_TYPE='EXCHANGE' WHERE P_TOKEN = '"+tok+"' AND P_NAME='"+pname+"';";
//					}
//					else {
//						myqurey = "UPDATE MAIN_TABLEE SET P_STATUS='SOLD', DATE_SOLD='"+date+"', SELLING_PRICE="
//								+balance+", PAID="+0+", DUE=0, C_ID='"+cid+"', C_NAME='"+cname+"', C_MOBILE='"
//								+cmob+"', C_ADDR='"+caddr+"', T_ID='"+tid+"', T_TYPE='EXCHANGE' WHERE P_TOKEN = '"+tok+"' AND P_NAME='"+pname+"';";
//					}
					st.executeUpdate(myqurey);
				}
				JOptionPane.showMessageDialog(new JFrame(), msgexch2, "Exchanged!", JOptionPane.INFORMATION_MESSAGE);
				addTidIntDB_2();
				if(!exists)
					addCidIntDB_2();
			}
			st.close();
			conn.close();
			if(exyes)
				addSellToDailyStokDB5(date, pname, qty);
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from exchangeProductDB()", "Error!", JOptionPane.ERROR_MESSAGE);
			eAdd.printStackTrace();
		}
	}
	
	public ResultSet searchCustomerDB(String cinfo) {
		boolean found = false;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "SELECT * FROM MAIN_TABLEE WHERE C_ID = '"+cinfo+"';";
			dbres3 = st.executeQuery(myqurey);
			if(!dbres3.next()) {
				myqurey = "SELECT * FROM MAIN_TABLEE WHERE C_MOBILE = '"+cinfo+"';";
				dbres4 = st.executeQuery(myqurey);
				if(!dbres4.next()) {
					JOptionPane.showMessageDialog(new JFrame(), "Customer Not in Database!", "Not found", JOptionPane.WARNING_MESSAGE);
					dbres3.close();
					dbres4.close();
				}
				else {
					found = true;
					dbres3.close();
					dbres4.close();
					dbres5 = st.executeQuery(myqurey);
				}
			}
			else {
				found = true;
				dbres5 = st.executeQuery(myqurey);
			}
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from searchCusomerDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		if(!found)
			return null;
		else
			return dbres5;
	}
	
	public ResultSet searchTidComPayDB(String tid) {
		boolean found = false;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "SELECT * FROM MAIN_TABLEE WHERE T_ID = '"+tid+"';";
			dbres3 = st.executeQuery(myqurey);
			if(!dbres3.next()) {
				dbres3.close();
				//flag5=0;
				JOptionPane.showMessageDialog(new JFrame(), "Transaction ID not in database!", "Not found", JOptionPane.WARNING_MESSAGE);
			}
			else {
				found = true;
				//flag5=1;
				dbres6 = st.executeQuery(myqurey);
			}
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from searchTidComPayDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		if(!found)
			return null;
		else
			return dbres6;
	}

	public void sellProductDB(String date, String tid, String pname, int qty, 
			JTextField []tokenfieldlist, String cid, String cname, String cmob, String caddr, 
			double gold, double stone, double charge, double vat, double total) {
		boolean exists, sellyes=false;
		String tok;
		String msgsell = "<html>Product <font color=green size=+1>Sold!</font></html>";
		String msgsellwrong1 = "<html><font color=red size=+1>Token not in Database!</font></html>";
		String msgsellwrong2 = "<html>Product <font color=red size=+1>not Available!</font></html>";
		String []tokenListForExport = new String[qty];
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			for(int i=0; i<qty; i++) {
				tok = tokenfieldlist[i].getText();
				myqurey = "SELECT * FROM MAIN_TABLEE WHERE P_TOKEN='"+tok+"' AND P_NAME='"+pname+"';";
				dbres = st.executeQuery(myqurey);
				if(!dbres.next()) {
					JOptionPane.showMessageDialog(new JFrame(), msgsellwrong1, "Wrong Input", JOptionPane.WARNING_MESSAGE);
					dbres.close();
					st.close();
					conn.close();
					return;
				}
				myqurey = "SELECT * FROM MAIN_TABLEE WHERE P_TOKEN='"+tok+"' AND P_NAME='"+pname+"' AND P_STATUS='AVAILABLE';";
				dbres = st.executeQuery(myqurey);
				if(!dbres.next()) {
					JOptionPane.showMessageDialog(new JFrame(), msgsellwrong2, "Wrong Input", JOptionPane.WARNING_MESSAGE);
					dbres.close();
					st.close();
					conn.close();
					return;
				}
				dbres.close();
			}
			
			myqurey = "SELECT * FROM MAIN_TABLEE WHERE C_ID = '"+cid+"';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				exists = false;
			}
			else {
				exists = true;
			}
			dbres.close();
			
			int yes = JOptionPane.showConfirmDialog(null, "Sell Product?", "Confirmaion", JOptionPane.YES_NO_OPTION);
			if(yes==JOptionPane.YES_OPTION) {
				soldflag = true;
				sellyes = true;
				for(int i=0; i<qty; i++) {
					tok = tokenfieldlist[i].getText();
					tokenListForExport[i] = tok;
					myqurey = "UPDATE MAIN_TABLEE SET P_STATUS='SOLD', DATE_SOLD='"+date+"', SELLING_PRICE="
							+total+", PAID="+total+", DUE=0, GOLD="+gold+", STONE="+stone+", CHARGE="+charge+", "
							+ "VAT="+vat+", C_ID='"+cid+"', C_NAME='"+cname+"', C_MOBILE='"+cmob+"', C_ADDR='"
							+caddr+"', T_ID='"+tid+"', T_TYPE='REGULAR' WHERE P_TOKEN = '"+tok+"' AND P_NAME='"+pname+"';";
//					}
//					else {
//						myqurey = "UPDATE MAIN_TABLEE SET P_STATUS='SOLD', DATE_SOLD='"+date+"', SELLING_PRICE="
//								+0+", PAID="+0+", DUE=0, GOLD="+gold+", STONE="+stone+", CHARGE="+charge+", VAT="+vat+", "
//								+ "C_ID='"+cid+"', C_NAME='"+cname+"', C_MOBILE='"+cmob+"', C_ADDR='"+caddr+"', T_ID='"
//								+tid+"', T_TYPE='REGULAR' WHERE P_TOKEN = '"+tok+"' AND P_NAME='"+pname+"';";
//					}
					st.executeUpdate(myqurey);
				}
				JOptionPane.showMessageDialog(new JFrame(), msgsell, "Product Sold!", JOptionPane.INFORMATION_MESSAGE);
				dbres.close();
				//-----
				double gtotal = total*qty;
				new BillCreatorSell(date, tid, cname, cid, cmob, caddr, pname, gold, stone, charge,
						vat, total, qty, gtotal, tokenListForExport).createBillSell();
				// update here
				double balance = total*qty;
				updateAccountsTableDB(date, balance);
				addTidIntDB_2();
				if(!exists)
					addCidIntDB_2();
			}
			st.close();
			conn.close();
			if(sellyes)
				addSellToDailyStokDB5(date, pname, qty);
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from sellProductDB()", "Error!", JOptionPane.ERROR_MESSAGE);
			eAdd.printStackTrace();
		}
	}
	
	public boolean productSoldDB() {
		if(soldflag) {
			soldflag = false;
			return true;
		}
		else
			return false;
	}
	
	public boolean productBookedDB() {
		if(bookedflag) {
			bookedflag = false;
			return true;
		}
		else
			return false;
	}
	
	public boolean productExchangedDB() {
		if(exchangeflag) {
			exchangeflag = false;
			return true;
		}
		else
			return false;
	}
	
	public ResultSet showPendingDB() {
		String msgsellwrong1 = "No Pending Products!";
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "SELECT P_NAME 'Product Name', P_TOKEN 'Token', P_WEIGHT 'Weight',SELLING_PRICE 'Selling Price',PAID 'Paid',DUE 'Due',C_ID 'Cust ID',C_MOBILE 'Cust Mob',T_ID 'Trans ID',DATE_BOOKING 'Booking Date' FROM MAIN_TABLEE WHERE P_STATUS='BOOKED/NO DELIVERY';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				JOptionPane.showMessageDialog(new JFrame(), msgsellwrong1, "Empty", JOptionPane.INFORMATION_MESSAGE);
				dbres = null;
				flag=0;
			}
			else {
				flag=1;
				dbres = st.executeQuery(myqurey);
			}
		} catch (Exception ePend) {
			JOptionPane.showMessageDialog(new JFrame(), ePend.getClass().getName()+":"+ePend.getMessage()+" -mm- Error from showPendingDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return dbres;
	}

	public ResultSet stockSummaryDB() {
//		String msgsstock1 = "<html>Stock <font color=red size=+1>Empty!</font></html>";
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "SELECT P_TOKEN 'TOKEN', P_WEIGHT 'WEIGHT', P_NAME 'PRODUCT NAME',DATE_ADDED 'DATE ADDED', P_STATUS 'STATUS' FROM MAIN_TABLEE WHERE P_STATUS='AVAILABLE';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				JOptionPane.showMessageDialog(new JFrame(), "Stock Empty!", "Stock Empty", JOptionPane.INFORMATION_MESSAGE);
				dbres = null;
				flag2=0;
			}
			else {
				flag2=1;
				dbres = st.executeQuery(myqurey);
			}
		} catch (Exception ePend) {
			JOptionPane.showMessageDialog(new JFrame(), ePend.getClass().getName()+" : "+ePend.getMessage()+" -mm- Error from stockSummaryDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return dbres;
	}
	
	public void addProdToDailyStockDB5(String date, String pid, String pname, int qty) {
		String lastTableName;
		String tablename = "\""+date+"\"";
		try {
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:dldb.db");
			st1 = conn1.createStatement();
			st2 = conn1.createStatement();
			myqurey = "SELECT LAST_DATE FROM DATE_MGR_ADD;";
			dbres1 = st1.executeQuery(myqurey);
			String temp = dbres1.getString("LAST_DATE");
			lastTableName = "\""+temp+"\"";
			dbres1.close();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
			dbres1 = st1.executeQuery(myqurey1);
			if(!dbres1.next()) {	// table does not exist
				myqurey2 = "CREATE TABLE "+tablename+" "
						+ "(DATE 			TEXT 		,"
						+ "	P_NAME	 		TEXT 		,"
						+ "	PREV_TOTAL	 	INTEGER 	,"
						+ "	ADDED_TODAY	 	INTEGER 	,"
						+ "	SOLD_TODAY	 	INTEGER		,"
						+ "	TOTAL_TODAY	 	INTEGER		,"
						+ "	FINAL_TOTAL		INTEGER		);";
				st1.executeUpdate(myqurey2);
				if(lastTableName.equals("\"BEGIN\"")) {
					myqurey2 = "INSERT INTO "+tablename+" "
							+  "(DATE, P_NAME, PREV_TOTAL, ADDED_TODAY, TOTAL_TODAY, SOLD_TODAY, FINAL_TOTAL)"
							+  "VALUES('"+date+"', '"+pname+"', "+0+", "+qty+", "+qty+", "+0+", "+qty+");";
					st1.executeUpdate(myqurey2);
				}
				else {	// prev table Exists
					myqurey2 = "SELECT * FROM "+lastTableName+";";
					dbres2 = st1.executeQuery(myqurey2);
					if(!dbres2.next()) {
					}
					else {		// copy from prev table
						myqurey3 = "SELECT * FROM "+lastTableName+";";
						dbres3 = st1.executeQuery(myqurey3);
						while(dbres3.next()) {
							String pname1 = dbres3.getString("P_NAME");
							int prev = dbres3.getInt("FINAL_TOTAL");
							myqurey4 = "INSERT INTO "+tablename+""
									+  "(DATE, P_NAME, PREV_TOTAL, ADDED_TODAY, TOTAL_TODAY, SOLD_TODAY, FINAL_TOTAL)"
									+  "VALUES('"+date+"', '"+pname1+"', "+prev+", "+0+", "+0+", "+0+", "+prev+");";
							st2.executeUpdate(myqurey4);
						}
						dbres3.close();
					}
					myqurey2 = "SELECT * FROM "+tablename+" WHERE P_NAME='"+pname+"';";
					dbres4 = st1.executeQuery(myqurey2);
					if(!dbres4.next()) {
						myqurey2 = "INSERT INTO "+tablename+" "
								+  "(DATE, P_NAME, PREV_TOTAL, ADDED_TODAY, TOTAL_TODAY, SOLD_TODAY, FINAL_TOTAL)"
								+  "VALUES('"+date+"', '"+pname+"', "+0+", "+qty+", "+qty+", "+0+", "+qty+");";
						st1.executeUpdate(myqurey2);
					}
					else { // product exists
						myqurey2 = "SELECT * FROM "+tablename+" WHERE P_NAME='"+pname+"';";
						dbres5 = st1.executeQuery(myqurey2);
						int prev = dbres5.getInt("PREV_TOTAL");
						int finaltotal = prev+qty;
						myqurey2 = "UPDATE "+tablename+" SET ADDED_TODAY="+qty+", TOTAL_TODAY="+qty+", FINAL_TOTAL="+finaltotal+" WHERE P_NAME='"+pname+"';";
						st1.executeUpdate(myqurey2);
						dbres5.close();
					}
					dbres4.close();
					dbres2.close();
				}
			}
			else {		// table exists
				myqurey2 = "SELECT * FROM "+tablename+" WHERE P_NAME='"+pname+"';";
				dbres2 = st1.executeQuery(myqurey2);
				if(!dbres2.next()) {	// product does NOT exist
					myqurey2 = "INSERT INTO "+tablename+" "
							+  "(DATE, P_NAME, PREV_TOTAL, ADDED_TODAY, TOTAL_TODAY, SOLD_TODAY, FINAL_TOTAL)"
							+  "VALUES('"+date+"','"+pname+"', "+0+", "+qty+", "+qty+", "+0+", "+qty+");";
					st1.executeUpdate(myqurey2);
				}
				else {	//ok
					myqurey2 = "SELECT * FROM "+tablename+" WHERE P_NAME='"+pname+"';";
					dbres3 = st1.executeQuery(myqurey2);
					int totaltoday = dbres3.getInt("TOTAL_TODAY");
					int addedtoday = dbres3.getInt("ADDED_TODAY");
					int finaltotal = dbres3.getInt("FINAL_TOTAL");
					totaltoday+=qty;
					addedtoday+=qty;
					finaltotal+=qty;
					myqurey2 = "UPDATE "+tablename+" SET ADDED_TODAY="+addedtoday+", TOTAL_TODAY="+totaltoday+", FINAL_TOTAL="+finaltotal+" WHERE P_NAME='"+pname+"';";
					st1.executeUpdate(myqurey2);
					dbres3.close();
				}
				dbres2.close();
			}
			myqurey = "UPDATE DATE_MGR_ADD SET LAST_DATE="+tablename+";";
			st1.executeUpdate(myqurey);
			dbres1.close();
			st2.close();
			st1.close();
			conn1.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from addProdToDailyStockDB5()", "Error!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
	
	public void addSellToDailyStokDB5(String date, String pname, int qty) {
		String lastTableName;
		String tablename = "\""+date+"\"";
		try {
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:dldb.db");
			st1 = conn1.createStatement();
			st2 = conn1.createStatement();
			myqurey = "SELECT LAST_DATE FROM DATE_MGR_SELL;";
			dbres1 = st1.executeQuery(myqurey);
			String temp = dbres1.getString("LAST_DATE");
			lastTableName = "\""+temp+"\"";
			dbres1.close();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
			dbres1 = st1.executeQuery(myqurey1);
			if(!dbres1.next()) {	// table does not exist
				myqurey2 = "CREATE TABLE "+tablename+" "
						+ "(DATE 			TEXT 		,"
						+ "	P_NAME	 		TEXT 		,"
						+ "	PREV_TOTAL	 	INTEGER 	,"
						+ "	ADDED_TODAY	 	INTEGER 	,"
						+ "	SOLD_TODAY	 	INTEGER		,"
						+ "	TOTAL_TODAY	 	INTEGER		,"
						+ "	FINAL_TOTAL		INTEGER		);";
				st1.executeUpdate(myqurey2);
				
				myqurey2 = "SELECT * FROM "+lastTableName+";";
				dbres2 = st1.executeQuery(myqurey2);		// exc
				while(dbres2.next()) {
					String pname1 = dbres2.getString("P_NAME");
					int prev = dbres2.getInt("FINAL_TOTAL");
					myqurey2 = "INSERT INTO "+tablename+""
							+  "(DATE, P_NAME, PREV_TOTAL, ADDED_TODAY, TOTAL_TODAY, SOLD_TODAY, FINAL_TOTAL)"
							+  "VALUES('"+date+"', '"+pname1+"', "+prev+", "+0+", "+0+", "+0+", "+prev+");";
					// sold_today updated here. total_today & final_total updated below.
					st2.executeUpdate(myqurey2);
				}
				
				myqurey2 = "SELECT * FROM "+tablename+" WHERE P_NAME='"+pname+"';";
				dbres3 = st1.executeQuery(myqurey2);
				int prev = dbres3.getInt("PREV_TOTAL");
				int finaltotal = prev-qty;
				int totaltoday = 0-qty;
				myqurey2 = "UPDATE "+tablename+" SET SOLD_TODAY="+qty+", TOTAL_TODAY="+totaltoday+", FINAL_TOTAL="+finaltotal+" WHERE P_NAME='"+pname+"';";
				st1.executeUpdate(myqurey2);
				dbres3.close();
				dbres2.close();
			}
			else {		// table exists
				myqurey2 = "SELECT * FROM "+tablename+" WHERE P_NAME='"+pname+"';";
				dbres2 = st1.executeQuery(myqurey2);
				int soldtoday = dbres2.getInt("SOLD_TODAY");
				int totaltoday = dbres2.getInt("TOTAL_TODAY");
				int finaltotal = dbres2.getInt("FINAL_TOTAL");
				soldtoday+=qty;
				totaltoday-=qty;
				finaltotal-=qty;
				myqurey2 = "UPDATE "+tablename+" SET SOLD_TODAY="+soldtoday+", TOTAL_TODAY="+totaltoday+", FINAL_TOTAL="+finaltotal+" WHERE P_NAME='"+pname+"';";
				st1.executeUpdate(myqurey2);
				dbres2.close();
			}
			myqurey = "UPDATE DATE_MGR_SELL SET LAST_DATE="+tablename+";";
			st1.executeUpdate(myqurey);
			dbres1.close();
			st2.close();
			st1.close();
			conn1.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from addSellToDailyStokDB5()", "Error!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
	
	public ResultSet showDailyStockDB5(String date) {
		String resdate = "\""+date+"\"";
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:dldb.db");
			st = conn.createStatement();
			try {
				myqurey = "SELECT DATE, P_NAME 'Product Name', PREV_TOTAL 'Beginning Total', ADDED_TODAY 'Added Today', SOLD_TODAY 'Sold Today', TOTAL_TODAY 'Total Today', FINAL_TOTAL 'Total' FROM "+resdate+";";
				dbres = st.executeQuery(myqurey);
			} catch (Exception e) {
			}
			if(!dbres.next()) {
				flag7=0;
				dbres=null;
				JOptionPane.showMessageDialog(null, "No data on this date!", "Empty", JOptionPane.WARNING_MESSAGE);
				st.close();
				conn.close();
			}
			else {
				flag7=1;
				dbres = st.executeQuery(myqurey);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from showDailyStockDB5()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return dbres;
	}

	public void addDepositDB(String date, JTextField []fieldArray, JTextField []depositArray) {
		String tablename = "\""+date+"\"";
		double totaldep=0;
		int sz = fieldArray.length;
		String field;
		double deposit;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:acddb.db");
			st = conn.createStatement();
			int yes = JOptionPane.showConfirmDialog(null, "Add to database?", "Confirmaion", JOptionPane.YES_NO_OPTION);
			if(yes==JOptionPane.YES_OPTION) {
				myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
				dbres1 = st.executeQuery(myqurey1);
				if(!dbres1.next()) {
					myqurey2 = 	"CREATE TABLE "+tablename+" "
							+ "(DATE 		TEXT 	,"
							+ "	FIELD_DEP 	TEXT 	,"
							+ "	DEPOSIT 	REAL 	,"
							+ "	TOTAL_DEP	REAL	);";		
					st.executeUpdate(myqurey2);
					totaldep = 0;
					for(int i=0; i<=sz-2; i++) {
						field = fieldArray[i].getText();
						deposit = Double.valueOf(depositArray[i].getText());
						totaldep+=deposit;
						myqurey2 = "INSERT INTO "+tablename+""
								+ "(DATE, FIELD_DEP, DEPOSIT, TOTAL_DEP) "
								+ "VALUES('"+date+"', '"+field+"', "+deposit+", "+deposit+")";
						st.executeUpdate(myqurey2);
					}
					myqurey2 = "UPDATE "+tablename+" SET TOTAL_DEP="+totaldep+";";
					st.executeUpdate(myqurey2);
				}
				else {
					myqurey2 = "SELECT TOTAL_DEP FROM "+tablename+";";
					dbres2 = st.executeQuery(myqurey2);
					totaldep = dbres2.getDouble("TOTAL_DEP");
					for(int i=0; i<=sz-2; i++) {
						field = fieldArray[i].getText();
						deposit = Double.valueOf(depositArray[i].getText());
						totaldep+=deposit;
						myqurey2 = "INSERT INTO "+tablename+""
								+ "(DATE, FIELD_DEP, DEPOSIT, TOTAL_DEP) "
								+ "VALUES('"+date+"', '"+field+"', "+deposit+", "+totaldep+")";
						st.executeUpdate(myqurey2);
					}
					myqurey2 = "UPDATE "+tablename+" SET TOTAL_DEP="+totaldep+";";
					st.executeUpdate(myqurey2);
					dbres2.close();
				}
				updateAccountsTableDB(date, totaldep);
				dbres1.close();
				JOptionPane.showMessageDialog(new JFrame(), "Accounts updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
				st.close();
				conn.close();
			}
			else {
				st.close();
				conn.close();
				return;
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from addDepositDB()", "Error!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
	
	public void addExpenseDB(String date, JTextField []fieldArray, JTextField []expenseArray) {
		String tablename = "\""+date+"\"";
		double totalexp=0;
		int sz = fieldArray.length;
		String field;
		double expense;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:acedb.db");
			st = conn.createStatement();
			int yes = JOptionPane.showConfirmDialog(null, "Add to database?", "Confirmaion", JOptionPane.YES_NO_OPTION);
			if(yes==JOptionPane.YES_OPTION) {
				myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
				dbres1 = st.executeQuery(myqurey1);
				if(!dbres1.next()) {
					myqurey2 = 	"CREATE TABLE "+tablename+" "
							+ "(DATE 		TEXT 	,"
							+ "	FIELD_EXP 	TEXT 	,"
							+ "	EXPENSE 	REAL 	,"
							+ "	TOTAL_EXP	REAL	);";				
					st.executeUpdate(myqurey2);
					totalexp = 0;
					for(int i=0; i<=sz-2; i++) {
						field = fieldArray[i].getText();
						expense = Double.valueOf(expenseArray[i].getText());
						totalexp+=expense;
						myqurey2 = "INSERT INTO "+tablename+" "
								+ "(DATE, FIELD_EXP, EXPENSE, TOTAL_EXP) "
								+ "VALUES('"+date+"', '"+field+"', "+expense+", "+expense+")";
						st.executeUpdate(myqurey2);
					}
					myqurey2 = "UPDATE "+tablename+" SET TOTAL_EXP="+totalexp+";";
					st.executeUpdate(myqurey2);
				}
				else {
					myqurey2 = "SELECT TOTAL_EXP FROM "+tablename+";";
					dbres2 = st.executeQuery(myqurey2);
					totalexp = dbres2.getDouble("TOTAL_EXP");
					for(int i=0; i<=sz-2; i++) {
						field = fieldArray[i].getText();
						expense = Double.valueOf(expenseArray[i].getText());
						totalexp+=expense;
						myqurey2 = "INSERT INTO "+tablename+""
								+ "(DATE, FIELD_EXP, EXPENSE, TOTAL_EXP) "
								+ "VALUES('"+date+"', '"+field+"', "+expense+", "+totalexp+")";
						st.executeUpdate(myqurey2);
					}
					myqurey2 = "UPDATE "+tablename+" SET TOTAL_EXP="+totalexp+";";
					st.executeUpdate(myqurey2);
					dbres2.close();
				}
				dbres1.close();
				updateAccountsTableDB(date, totalexp);
				JOptionPane.showMessageDialog(new JFrame(), "Accounts updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
				st.close();
				conn.close();
			}
			else {
				st.close();
				conn.close();
				return;
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from addExpenseDB()", "Error!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
	
	public ResultSet showDepAccountsDB(String date) {
		String tablename = "\""+date+"\"";
		try {
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:acddb.db");
			st1 = conn1.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
			dbres = st1.executeQuery(myqurey);
			if(!dbres.next()) {
				dbres1 = null;
				flag9=0;
				JOptionPane.showMessageDialog(null, "No Deposit on this date!", "Not Found", JOptionPane.WARNING_MESSAGE);
			}
			else {
				flag9=1;
				myqurey1 = "SELECT DATE 'Date', FIELD_DEP 'Field', DEPOSIT 'Deposit Amount' FROM "+tablename+";";
				dbres1 = st1.executeQuery(myqurey1);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from showDepAccountsDB()", "Error!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		return dbres1;
	}
	
	public ResultSet showExpAccountsDB(String date) {
		String tablename = "\""+date+"\"";
		try {
			conn2 = null;
			st2 = null;
			Class.forName("org.sqlite.JDBC");
			conn2 = DriverManager.getConnection("jdbc:sqlite:acedb.db");
			st2 = conn2.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
			dbres = st2.executeQuery(myqurey);
			if(!dbres.next()) {
				dbres2 = null;
				flag10=0;
				JOptionPane.showMessageDialog(null, "No Expense on this date!", "Not Found", JOptionPane.WARNING_MESSAGE);
			}
			else {
				flag10=1;
				myqurey2 = "SELECT DATE 'Date', FIELD_EXP 'Field', EXPENSE 'Expense Amount' FROM "+tablename+";";
				dbres2 = st2.executeQuery(myqurey2);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from showExpAccountsDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return dbres2;
	}
	
	public void updateAccountsTableDB(String date, double balance) {
		String lastDate;
		double newbalance=0, begbalance=0;
		try {
			conn4 = null;
			st4 = null;
			Class.forName("org.sqlite.JDBC");
			conn4 = DriverManager.getConnection("jdbc:sqlite:acdb.db");
			st4 = conn4.createStatement();
			myqurey = "SELECT LAST_DATE FROM DATE_MGR_ACCOUNTS;";
			dbres = st4.executeQuery(myqurey);
			lastDate = dbres.getString("LAST_DATE");
			myqurey = "SELECT * FROM ACCOUNT_BALANCE WHERE DATE='"+date+"';";
			dbres1 = st4.executeQuery(myqurey);
			if(!dbres1.next()) {
				if(lastDate.equals("BEG_DATE1")) {
					myqurey1 = "INSERT INTO ACCOUNT_BALANCE(DATE, BALANCE, BEG_BALANCE, LAST_DATE) "
						     + "VALUES('"+date+"', "+balance+", 0, 'BEG_DATE2');";
					st4.executeUpdate(myqurey1);
					myqurey1 = "UPDATE DATE_MGR_ACCOUNTS SET LAST_DATE='"+date+"';";
					st4.executeUpdate(myqurey1);
				}
				else {		// bug found -fixed- check if ok- value ok
					myqurey1 = "SELECT * FROM ACCOUNT_BALANCE WHERE DATE='"+lastDate+"';";
					dbres2 = st4.executeQuery(myqurey1);
					begbalance = dbres2.getDouble("BALANCE");
					newbalance = begbalance+balance;
					myqurey1 = "INSERT INTO ACCOUNT_BALANCE(DATE, BALANCE, BEG_BALANCE, LAST_DATE) "
						     + "VALUES('"+date+"', "+newbalance+", "+begbalance+", '"+lastDate+"');";
					st4.executeUpdate(myqurey1);
					myqurey1 = "UPDATE DATE_MGR_ACCOUNTS SET LAST_DATE='"+date+"';";
					st4.executeUpdate(myqurey1);
					dbres2.close();
				}
			}
			else {			// 	date exists in table
				newbalance = dbres1.getDouble("BEG_BALANCE") + balance;
				myqurey1 = "UPDATE ACCOUNT_BALANCE SET BALANCE="+newbalance+" WHERE DATE='"+date+"';";
				st4.executeUpdate(myqurey1);
			}
			dbres1.close();
			dbres.close();
			st4.close();
			conn4.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from updateAccountsTableDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

/*
	public double getAccountsBalanceDB(String date) {
		String tablename = "\""+date+"\"";
		double dep=0, exp=0, totalsell=0, balance=0, finalbalance=0;
		try {
			conn2 = null;
			st2 = null;
			Class.forName("org.sqlite.JDBC");
			conn2 = DriverManager.getConnection("jdbc:sqlite:acddb.db");
			st2 = conn2.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
			dbres = st2.executeQuery(myqurey);
			if(!dbres.next()) {
			}
			else {
				myqurey1 = "SELECT TOTAL_DEP FROM "+tablename+";";
				dbres1 = st2.executeQuery(myqurey1);
				dep = dbres1.getDouble("TOTAL_DEP");
				dbres1.close();
			}
			dbres.close();
			
			conn3 = null;
			st3 = null;
			Class.forName("org.sqlite.JDBC");
			conn3 = DriverManager.getConnection("jdbc:sqlite:acedb.db");
			st3 = conn3.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
			dbres = st3.executeQuery(myqurey);
			if(!dbres.next()) {
			}
			else {
				myqurey1 = "SELECT TOTAL_EXP FROM "+tablename+";";
				dbres2 = st3.executeQuery(myqurey1);
				exp = dbres2.getDouble("TOTAL_EXP");
				dbres2.close();
			}
			dbres.close();
			
			totalsell = getTotalSellDB(date);
			
			balance = totalsell+dep-exp;		// balance this date
			
			finalbalance = updateAccountsTableDB(date, balance);
			
			st3.close();
			conn3.close();
			st2.close();
			conn2.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from getAccountsBalanceDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return finalbalance;
	}
*/
	
	public double getAccountsBalanceDB(String date) {
		double balance=0;
		try {
			conn2 = null;
			st2 = null;
			Class.forName("org.sqlite.JDBC");
			conn2 = DriverManager.getConnection("jdbc:sqlite:acdb.db");
			st2 = conn2.createStatement();
			myqurey = "SELECT BALANCE FROM ACCOUNT_BALANCE WHERE DATE='"+date+"';";
			dbres = st2.executeQuery(myqurey);
			if(!dbres.next()) {
			}
			else {
				balance = dbres.getDouble("BALANCE");
			}
			dbres.close();
			st2.close();
			conn2.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from getAccountsBalanceDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return balance;
	}
	
	public double getTotalDepAccountsDB(String date) {
		String tablename = "\""+date+"\"";
		double totaldep=0;
		try {
			conn3 = null;
			st3 = null;
			Class.forName("org.sqlite.JDBC");
			conn3 = DriverManager.getConnection("jdbc:sqlite:acddb.db");
			st3 = conn3.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
			dbres = st3.executeQuery(myqurey);
			if(!dbres.next()) {
			}
			else {
				myqurey1 = "SELECT TOTAL_DEP FROM "+tablename+";";
				dbres3 = st3.executeQuery(myqurey1);
				totaldep = dbres3.getDouble("TOTAL_DEP");
				dbres3.close();
			}
			dbres.close();
			st3.close();
			conn3.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from getTotalDepAccountsDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return totaldep;
	}
	
	public double getTotalExpAccountsDB(String date) {
		String tablename = "\""+date+"\"";
		double totalexp=0;
		try {
			conn3 = null;
			st3 = null;
			Class.forName("org.sqlite.JDBC");
			conn3 = DriverManager.getConnection("jdbc:sqlite:acedb.db");
			st3 = conn3.createStatement();
			myqurey = "SELECT * FROM sqlite_master WHERE type='table' AND name="+tablename+";";
			dbres = st3.executeQuery(myqurey);
			if(!dbres.next()) {
			}
			else {
				myqurey1 = "SELECT TOTAL_EXP FROM "+tablename+";";
				dbres3 = st3.executeQuery(myqurey1);
				totalexp = dbres3.getDouble("TOTAL_EXP");
				dbres3.close();
			}
			dbres.close();
			st3.close();
			conn3.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from getTotalExpAccountsDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return totalexp;
	}
	
	public double getBegBalanceAccountsDB(String date) {
		double retbalance = 0;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:acdb.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM ACCOUNT_BALANCE WHERE DATE='"+date+"';";
			dbres1 = st.executeQuery(myqurey1);
			if(!dbres1.next()) {
			}
			else {
				retbalance = dbres1.getDouble("BEG_BALANCE");
			}
			dbres1.close();
			st.close();
			conn.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from getBegBalanceAccountsDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return retbalance;
	}
	
	public String getBegBalDateAccountsDB(String date) {
		String retdate=null;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:acdb.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM ACCOUNT_BALANCE WHERE DATE='"+date+"';";
			dbres1 = st.executeQuery(myqurey1);
			if(!dbres1.next()) {
			}
			else {
				retdate = dbres1.getString("LAST_DATE");
			}
//			dbres1.close();
			st.close();
			conn.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from getBegBalDateAccountsDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return retdate;
	}

	public double getTotalSellDB(String date) {
		double retsum = 0;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "SELECT sum(SELLING_PRICE) AS TEMP_COL FROM MAIN_TABLEE WHERE (P_STATUS='SOLD' OR P_STATUS='BOOKED/NO DELIVERY') AND DATE_SOLD='"+date+"';";
			dbres = st.executeQuery(myqurey);
			if(!dbres.next()) {
				return 0;
			}
			else {
				dbres1 = st.executeQuery(myqurey);
				retsum = dbres1.getDouble("TEMP_COL");
				dbres1.close();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from totalSellDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		try {
			dbres.close();
			st.close();
			conn.close();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(new JFrame(), e2.getClass().getName()+" : "+e2.getMessage()+" -mm- DB closing error totalsell!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return retsum;
	}

	public void addToMakerDB3(String date, String itemno, String give, String recieve) {
		int yes;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:mkdb.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM MAKER_TABLEE WHERE ITEM_NO='"+itemno+"';";
			dbres1 = st.executeQuery(myqurey1);
			if(dbres1.next()) {
				JOptionPane.showMessageDialog(null, "Item No Already exists!", "Failed", JOptionPane.WARNING_MESSAGE);
			}
			else {
				myqurey2 = "INSERT INTO MAKER_TABLEE"
						+ "(DATE, ITEM_NO, GIVE, RECIEVE) "
						+ "VALUES('"+date+"', '"+itemno+"', '"+give+"', '"+recieve+"');";
				yes = JOptionPane.showConfirmDialog(null, "Add to Database?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if(yes==JOptionPane.YES_OPTION) {
					st.executeUpdate(myqurey2);
					JOptionPane.showMessageDialog(null, "Database updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			dbres1.close();
			st.close();
			conn.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getClass().getName()+" : "+e1.getMessage()+" -mm- Error from addToMakerDB3()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ResultSet searchMakerItemDB3(String itemno) {
		boolean found = false;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:mkdb.db");
			st = conn.createStatement();
			myqurey = "SELECT * FROM MAKER_TABLEE WHERE ITEM_NO = '"+itemno+"';";
			dbres3 = st.executeQuery(myqurey);
			if(!dbres3.next()) {
				JOptionPane.showMessageDialog(new JFrame(), "Item Not in Database!", "Not found", JOptionPane.WARNING_MESSAGE);
				dbres3.close();
			}
			else {
				found = true;
				dbres6 = st.executeQuery(myqurey);
			}
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from searchMakerItemDB3()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		if(!found)
			return null;
		else
			return dbres6;
	}

	public String getTokenLastDB4(String pname) {
		int retval = 0;
		String token = null;
		try {
			conn2 = null;
			st2 = null;
			Class.forName("org.sqlite.JDBC");
			conn2 = DriverManager.getConnection("jdbc:sqlite:tkdb.db");
			st2 = conn2.createStatement();
			myqurey = "SELECT * FROM TOKEN_COUNTER_TABLEE WHERE P_NAME='"+pname+"';";
			dbres = st2.executeQuery(myqurey);
			if(!dbres.next()) {
				token = "1";
			}
			else {
				retval = dbres.getInt("TOKEN_LAST");
				retval++;
				token = String.valueOf(retval);
			}
			
			dbres.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from getTokenLastDB4()", "Database Error!", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
		} finally {
			try {
				st2.close();
				conn2.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(new JFrame(), e2.getClass().getName()+" : "+e2.getMessage()+" -mm- DB closing error getTokenLastDB4!", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
		return token;
	}
	
	public void incTokenDB4(String pname, int qty) {
		int qtynew=0, toklast=0;
		try {
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:tkdb.db");
			st1 = conn1.createStatement();
			myqurey = "SELECT * FROM TOKEN_COUNTER_TABLEE WHERE P_NAME='"+pname+"'";
			dbres = st1.executeQuery(myqurey);
			if(!dbres.next()) {
				myqurey1 = "INSERT INTO TOKEN_COUNTER_TABLEE(P_NAME, TOKEN_LAST) VALUES('"+pname+"', "+qty+")";
				st1.executeUpdate(myqurey1);
			}
			else {
				toklast = Integer.valueOf(getTokenLastDB4(pname));
				toklast--;
				qtynew = toklast+qty;
				myqurey1 = "UPDATE TOKEN_COUNTER_TABLEE SET TOKEN_LAST="+qtynew+" WHERE P_NAME='"+pname+"';";
				st1.executeUpdate(myqurey1);
			}
//			myqurey1 = "UPDATE TOKEN_COUNTER_TABLEE SET P_NAME='"+pname+"', TOKEN_LAST="+qtynew+" WHERE P_NAME='DEFAULT';";
//			myqurey1 = "INSERT INTO TOKEN_COUNTER_TABLEE (P_NAME, TOKEN_LAST) VALUES('DEFAULT', 1);";
//			st1.executeUpdate(myqurey1);
			dbres.close();
			st1.close();
			conn1.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from incTokenDB4()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void createDB_2() {
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:IDGen.db");
			st = conn.createStatement();
			myqurey1 = "SELECT * FROM sqlite_master WHERE type='table' AND name='C_TABLEE';";
			dbres = st.executeQuery(myqurey1);
			if(!dbres.next()) {
				myqurey1 = 	"CREATE TABLE C_TABLEE (C_INT INTEGER);";
				st.executeUpdate(myqurey1);
			}
			myqurey1 = "SELECT * FROM C_TABLEE";
			dbres1 = st.executeQuery(myqurey1);
			if(!dbres1.next()) {
				myqurey1 = 	"INSERT INTO C_TABLEE"
							+ "(C_INT)"
							+ "VALUES(101);";
				st.executeUpdate(myqurey1);
			}
			dbres.close();
			dbres1.close();
			
			myqurey2 = "SELECT * FROM sqlite_master WHERE type='table' AND name='T_TABLEE';";
			dbres = st.executeQuery(myqurey2);
			if(!dbres.next()) {
				myqurey2 = 	"CREATE TABLE T_TABLEE (T_INT INTEGER);";				
				st.executeUpdate(myqurey2);
			}
			myqurey2 = "SELECT * FROM T_TABLEE";
			dbres1 = st.executeQuery(myqurey2);
			if(!dbres1.next()) {
				myqurey2 = 	"INSERT INTO T_TABLEE"
							+ "(T_INT)"
							+ "VALUES(101);";
				st.executeUpdate(myqurey2);
			}
			dbres.close();
			dbres1.close();

			st.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from getTidIntDB_2()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int getCidIntDB_2() {
		int retval = 0;
		try {
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:IDGen.db");
			st1 = conn1.createStatement();
			myqurey1 = "SELECT * FROM C_TABLEE ORDER BY C_INT DESC LIMIT 1;";
			dbres = st1.executeQuery(myqurey1);
			
			retval = dbres.getInt("C_INT");
			
			dbres.close();
			st1.close();
			conn1.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from getCidIntDB_2()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
		return retval;
	}

	public void addCidIntDB_2() {
		int val = getCidIntDB_2()+1;
		try {
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:IDGen.db");
			st1 = conn1.createStatement();
			myqurey1 = "INSERT INTO C_TABLEE(C_INT) VALUES("+val+");";
			st1.executeUpdate(myqurey1);
			
			st1.close();
			conn1.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from addCidIntDB_2()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public int getTidIntDB_2() {
		int retval = 0;
		try {
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:IDGen.db");
			st1 = conn1.createStatement();
			myqurey1 = "SELECT * FROM T_TABLEE ORDER BY T_INT DESC LIMIT 1;";
			dbres = st1.executeQuery(myqurey1);
			
			retval = dbres.getInt("T_INT");
			
			dbres.close();
			st1.close();
			conn1.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from getTidIntDB_2()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
		return retval;
	}
	
	public void addTidIntDB_2() {
		int val = getTidIntDB_2()+1;
		try {
			conn1 = null;
			st1 = null;
			Class.forName("org.sqlite.JDBC");
			conn1 = DriverManager.getConnection("jdbc:sqlite:IDGen.db");
			st1 = conn1.createStatement();
			myqurey1 = "INSERT INTO T_TABLEE(T_INT) VALUES("+val+");";
			st1.executeUpdate(myqurey1);
			
			st1.close();
			conn1.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getClass().getName()+":"+e.getMessage()+" -mm- Error from addTidIntDB_2()", "Database Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet searchWithDateDB(String date) {
		boolean found = false;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "SELECT P_NAME 'Product Name', P_TOKEN 'Token', P_WEIGHT 'Weight', SELLING_PRICE 'Selling Price',T_ID 'Trans ID',C_ID 'Cust ID',C_MOBILE 'Cust Mobile',T_TYPE 'Payment Type',P_STATUS 'Status' FROM MAIN_TABLEE WHERE DATE_SOLD = '"+date+"';";
			dbres3 = st.executeQuery(myqurey);
			if(!dbres3.next()) {
				dbres3.close();
				flag3=0;
				JOptionPane.showMessageDialog(new JFrame(), "No transaction!", "Not found", JOptionPane.WARNING_MESSAGE);
			}
			else {
				found = true;
				flag3=1;
				dbres6 = st.executeQuery(myqurey);
			}
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from searchWithDateDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		if(!found)
			return null;
		else
			return dbres6;
	}
	
	public ResultSet searchWithTidDB(String tid) {
		boolean found = false;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "SELECT P_NAME 'Product Name', P_TOKEN 'Token', P_WEIGHT 'Weight', P_STATUS 'Status', SELLING_PRICE 'Selling Price',DATE_SOLD 'Selling Date',C_ID 'Cust ID',C_MOBILE 'Cust Mobile',T_TYPE 'Payment Type',PAID 'Paid',DUE 'Due' FROM MAIN_TABLEE WHERE T_ID = '"+tid+"';";
			dbres3 = st.executeQuery(myqurey);
			if(!dbres3.next()) {
				dbres3.close();
				flag5=0;
				JOptionPane.showMessageDialog(new JFrame(), "Transaction ID not in database!", "Not found", JOptionPane.WARNING_MESSAGE);
			}
			else {
				found = true;
				flag5=1;
				dbres6 = st.executeQuery(myqurey);
			}
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from searchWithTidDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		if(!found)
			return null;
		else
			return dbres6;
	}
	
	public ResultSet searchWithCidMobDB(String cidmob) {
		boolean found = false;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			myqurey = "SELECT C_ID 'Cust ID', C_MOBILE 'Mobile', C_NAME 'Cust Name', P_NAME 'Product Name', P_TOKEN 'Token',  P_WEIGHT 'Weight', P_STATUS 'Status', T_ID 'Trans ID', SELLING_PRICE 'Selling Price', DATE_SOLD 'Selling Date', T_TYPE 'Payment Type', PAID 'Paid', DUE 'Due' FROM MAIN_TABLEE WHERE C_ID = '"+cidmob+"';";
			dbres3 = st.executeQuery(myqurey);
			if(!dbres3.next()) {
				myqurey = "SELECT C_ID 'Cust ID', C_MOBILE 'Mobile', C_NAME 'Cust Name', P_NAME 'Product Name', P_TOKEN 'Token',  P_WEIGHT 'Weight', P_STATUS 'Status', T_ID 'Trans ID', SELLING_PRICE 'Selling Price', DATE_SOLD 'Selling Date', T_TYPE 'Payment Type', PAID 'Paid', DUE 'Due' FROM MAIN_TABLEE WHERE C_MOBILE = '"+cidmob+"';";
				dbres4 = st.executeQuery(myqurey);
				if(!dbres4.next()) {
					flag4=0;
					JOptionPane.showMessageDialog(new JFrame(), "Customer Not in Database!", "Not found", JOptionPane.WARNING_MESSAGE);
					dbres3.close();
					dbres4.close();
				}
				else {
					flag4=1;
					found = true;
					dbres3.close();
					dbres4.close();
					dbres5 = st.executeQuery(myqurey);
				}
			}
			else {
				flag4=1;
				found = true;
				dbres5 = st.executeQuery(myqurey);
			}
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from searchWithCidMobDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		if(!found)
			return null;
		else
			return dbres5;
	}
	
	public ResultSet searchWithPnameDB(String pname) {
		boolean found = false;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			
			myqurey = "SELECT P_TOKEN 'Token', P_WEIGHT 'Weight', P_STATUS 'Status', DATE_ADDED 'Adding Date', SELLING_PRICE 'Sell Price', DATE_SOLD 'Selling Date',T_ID 'Trans ID', C_ID 'Cust ID',C_MOBILE 'Cust Mob',T_TYPE 'Pay Type',PAID 'Paid',DUE 'Due', GOLD 'Gold', STONE 'Stone', CHARGE 'Charge', VAT 'VAT' FROM MAIN_TABLEE WHERE P_NAME = '"+pname+"';";
			dbres3 = st.executeQuery(myqurey);
			if(!dbres3.next()) {
				dbres3.close();
				flag6=0;
				JOptionPane.showMessageDialog(new JFrame(), "Product NOT in database!", "Not found", JOptionPane.WARNING_MESSAGE);
			}
			else {
				flag6=1;
				found = true;
				dbres6 = st.executeQuery(myqurey);
			}
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from searchWithTokenNoDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		if(!found)
			return null;
		else
			return dbres6;
	}
	
	public ResultSet searchWithCnameDB(String cname) {
		boolean found = false;
		try {
			conn = null;
			st = null;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:jwldb.db");
			st = conn.createStatement();
			
			myqurey = "SELECT C_ID 'Cust ID', C_MOBILE 'Cust Mobile', P_NAME 'Product Name', P_TOKEN 'Token', P_WEIGHT 'Weight', P_STATUS 'Status', SELLING_PRICE 'Sell Price', DATE_SOLD 'Selling Date',T_ID 'Trans ID', T_TYPE 'Pay Type',PAID 'Paid',DUE 'Due', GOLD 'Gold', STONE 'Stone', CHARGE 'Charge', VAT 'VAT' FROM MAIN_TABLEE WHERE C_NAME = '"+cname+"';";
			dbres3 = st.executeQuery(myqurey);
			if(!dbres3.next()) {
				dbres3.close();
				flag8=0;
				JOptionPane.showMessageDialog(new JFrame(), "Customer Name NOT in database!", "Not found", JOptionPane.WARNING_MESSAGE);
			}
			else {
				flag8=1;
				found = true;
				dbres6 = st.executeQuery(myqurey);
			}
		} catch (Exception eAdd) {
			JOptionPane.showMessageDialog(new JFrame(), eAdd.getClass().getName()+":"+eAdd.getMessage()+" -mm- Error from searchWithTokenNoDB()", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		if(!found)
			return null;
		else
			return dbres6;
	}
	
}
