package jewelary;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class UpdateAccount {
	public JFrame frame;
	public JPanel DepositPanel;
	public JPanel ExpensePanel;
	public JTabbedPane tabpane;
	public JPanel MainPanel;
	public JButton button;
	public JTextField field_expense;
	public JTextField field_deposit;
	public JTextField [] ExpStore;
	public JTextField [] Reason_of_expense_Store;
	public JTextField [] DepStore;
	public JTextField [] Reason_of_deposit_Store;
	public JButton Okbutton;
	public JButton OkButton2;
	public JButton done;
	public JButton done2;
	public String date;
	public UpdateAccount(){
		tabpane=new JTabbedPane();
		
		
		currectdata();
		
		prepareDepositPanel();
		prepareExpensePanel();
		
		
		tabpane.add("expense",ExpensePanel);
		tabpane.add("deposit",DepositPanel);
		
		frame=new JFrame("Update Accounts");
		frame.setSize(700, 600);
		try {
    		URL iconurl = getClass().getResource("res/Icon_Main.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		frame.setIconImage(icon.getImage());
		} catch (Exception e) {
		}
		frame.setLocationRelativeTo(null);
		frame.add(tabpane);
		frame.setVisible(true);
		
	}

	public void prepareDepositPanel(){
		this.DepositPanel=new JPanel(new GridLayout(0,1));
		JPanel panel1=new JPanel();
		OkButton2=new JButton("OK");
        OkButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Okbutton2ActionPerformed(evt);
            }
        });
		JLabel label=new JLabel();
		label.setFont(new Font("tahoma",Font.BOLD,24));
		label.setText("DEPOSIT");
	
		
		panel1.add(label);
		JPanel panel3=new JPanel();
		JLabel datelabel=new JLabel();
		datelabel.setFont(new Font("tahoma",Font.BOLD,12));
		datelabel.setText("Date :");
		JTextField DateTxt=new JTextField();
		DateTxt.setColumns(10);
		panel3.add(datelabel);
		panel3.add(new JLabel("     "));
		panel3.add(DateTxt);
		DateTxt.setText(date);
//		DateTxt.setEditable(false);
		DateTxt.setHorizontalAlignment(JTextField.CENTER);
		JPanel panel2=new JPanel();
//		panel2.add(new JLabel("Deposit Fields:"));
		panel2.add(new JLabel("No of Entry:  "));
		field_deposit=new JTextField();
		field_deposit.setColumns(10);
		field_deposit.setHorizontalAlignment(JTextField.CENTER);
		panel2.add(field_deposit);
		panel2.add(OkButton2);
		this.DepositPanel.add(panel1);
		this.DepositPanel.add(panel3);
		this.DepositPanel.add(panel2);
	}
	public void  Okbutton2ActionPerformed(ActionEvent evt){
		int a = 0;
		try {
			a=Integer.parseInt(this.field_deposit.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check input!", "Wrong Input", JOptionPane.ERROR_MESSAGE);
			return;
		}
		DepStore=new JTextField[a+1];
		Reason_of_deposit_Store=new JTextField[a+1];
		this.field_deposit.setEditable(false);
		this.OkButton2.setEnabled(false);
		dynamicExpense(a,'d');
		tabpane.add(this.DepositPanel,"deposit");
		
		tabpane.setSelectedComponent(DepositPanel);
		 JScrollPane spane = new JScrollPane(DepositPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 		spane.getVerticalScrollBar().setUnitIncrement(15);
	 		tabpane.add(spane);
	 		tabpane.setTitleAt(1, "Deposit");
	 		tabpane.setSelectedIndex(1);
	 		frame.add(tabpane);
	}
	public void prepareExpensePanel(){
		ExpensePanel=new JPanel(new GridLayout(0,1));
		JPanel panel1=new JPanel();
		Okbutton=new JButton("OK");
        Okbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkbuttonActionPerformed(evt);
            }
        });
		JLabel label=new JLabel();
		label.setFont(new Font("tahoma",Font.BOLD,24));
		label.setText("EXPENSE");
		panel1.add(label);
		JPanel panel3=new JPanel();
		JLabel datelabel=new JLabel();
		datelabel.setFont(new Font("tahoma",Font.BOLD,12));
		datelabel.setText("Date :");
		JTextField DateTxt=new JTextField();
		DateTxt.setColumns(10);
		panel3.add(datelabel);
		panel3.add(new JLabel("     "));
		panel3.add(DateTxt);
		DateTxt.setText(date);
//		DateTxt.setEditable(false);
		DateTxt.setHorizontalAlignment(JTextField.CENTER);
		JPanel panel2=new JPanel();
//		panel2.add(new JLabel("Expense Fields:"));
		panel2.add(new JLabel("No of Entry:  "));
		field_expense=new JTextField();
		field_expense.setColumns(10);
		field_expense.setHorizontalAlignment(JTextField.CENTER);
		panel2.add(field_expense);
		panel2.add(Okbutton);
		this.ExpensePanel.add(panel1);
		this.ExpensePanel.add(panel3);
		this.ExpensePanel.add(panel2);
	}
	public void OkbuttonActionPerformed(ActionEvent evt){
		int a = 0;
		try {
			a=Integer.parseInt(this.field_expense.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check input!", "Wrong Input", JOptionPane.ERROR_MESSAGE);
			return;
		}
		ExpStore=new JTextField[a+1];
		Reason_of_expense_Store=new JTextField[a+1];
		this.field_expense.setEditable(false);
		this.Okbutton.setEnabled(false);
		dynamicExpense(a,'e');
		tabpane.add(this.ExpensePanel,"expense");
		
		tabpane.setSelectedComponent(ExpensePanel);
		 JScrollPane spane = new JScrollPane(ExpensePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 		spane.getVerticalScrollBar().setUnitIncrement(15);
	 		tabpane.add(spane);
	 		tabpane.setTitleAt(1, "Expense");
	 		tabpane.setSelectedIndex(1);
	 		frame.add(tabpane);
	 		

	}
    public void currectdata(){
        Calendar cal=new GregorianCalendar();
        int month=cal.get(Calendar.MONTH)+1;
        int year=cal.get(Calendar.YEAR);
        int day=cal.get(Calendar.DAY_OF_MONTH);
       
        date=day+"/"+month+"/"+year;
        
    }
	public void dynamicExpense(int fields,char test){
		int c=0;
		for(c=0;c<fields;c++){
			JPanel retPanel=new JPanel();
			retPanel.add(new JLabel(Integer.toString(c+1)));
			retPanel.add(new JLabel(". As"));
			JTextField toadd=new JTextField();
			toadd.setColumns(10);
			retPanel.add(toadd);
			if(test=='e'){
			this.Reason_of_expense_Store[c]=toadd;
			retPanel.add(new JLabel("                                  "));
			retPanel.add(new JLabel("Expense :"));
			JTextField expns=new JTextField();
			expns.setColumns(10);
			this.ExpStore[c]=expns;
			retPanel.add(expns);
			this.ExpensePanel.add(retPanel);
			}
			else if(test=='d'){
				this.Reason_of_deposit_Store[c]=toadd;
				retPanel.add(new JLabel("                                  "));
				retPanel.add(new JLabel("deposit :"));
				JTextField depst=new JTextField();
				depst.setColumns(10);
				this.DepStore[c]=depst;
				retPanel.add(depst);
				this.DepositPanel.add(retPanel);
			
				
			}
		}
		if(test=='d'){
		JPanel b=new JPanel();
		done=new JButton("DONE");
		b.add(done);
		this.DepositPanel.add(b);
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donebuttonActionPerformed(evt);
            }
        });
		}
		else if(test=='e'){
			JPanel b=new JPanel();
			done2=new JButton("DONE");
			
			b.add(done2);
	        done2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                done2buttonActionPerformed(evt);
	            }
	        });
			this.ExpensePanel.add(b);
		}
	}
	public void donebuttonActionPerformed(ActionEvent evt){
		DBManager db=new DBManager();
		int i=0;
		String reason = null;
		double val=0;
		try {
			for(i=0; i<=Reason_of_deposit_Store.length-2; i++) {
				if(Reason_of_deposit_Store[i].getText().equals("")) {
					throw new NullPointerException();
				}
				val=Double.valueOf(DepStore[i].getText());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check input at   "+(i+1)+" !", "Wrong Input", JOptionPane.ERROR_MESSAGE);
			return;
		}
		db.addDepositDB(date,this.Reason_of_deposit_Store, this.DepStore);
	
	}
	public void done2buttonActionPerformed(ActionEvent evt){
		DBManager db=new DBManager();
		int i=0;
		String reason = null;
		double val=0;
		try {
			for(i=0; i<=Reason_of_expense_Store.length-2; i++) {
				if(Reason_of_expense_Store[i].getText().equals("")) {
					throw new NullPointerException();
				}
				val=Double.valueOf(ExpStore[i].getText());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check input at   "+(i+1)+" !", "Wrong Input", JOptionPane.ERROR_MESSAGE);
			return;
		}
		db.addExpenseDB(date,this.Reason_of_expense_Store, this.ExpStore);
	}
	

}
