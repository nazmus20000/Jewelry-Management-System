package jewelary;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.*;

 public class Token {
    	public JFrame frame;
    	public JPanel main_panel;
    	public JPanel panel1;
    	public JPanel panel2;
    	public JPanel panel3;
    	public JTextField datefield_token;
    	public JTextField pnamefield_token;
    	public JTextField pidfield_token;
    	public JTextField pqty_token;
    	public JTextField [] storeText;
    	public BookProduct a;
    	public Sell s;
    	public Exchange e;
    	int fields;
    	public JButton OkBut;
    	int chk;
    	String dt;
    	String t_id;
    	String c_id;
    	String c_name;
    	String c_mob;
    	String c_addr;
    	String pname;
    	double gl;
    	double st;
    	double chrg;
    	double vt;
    	double tot;
    	double pd;
    	double du;
    	double balance;
    	public Token(String date,String tid,String pname,String pid,String qty,String cid,String cname,String mobile,String adrs,double balnce,int chk,Exchange b){
    		
    		try{
    			//exchange
    			e=b;
    			OkBut=new JButton("OK");
        		datefield_token = new JTextField();
        		pnamefield_token = new JTextField();
        		pidfield_token = new JTextField();
        		pqty_token = new JTextField();
        		this.pidfield_token.setText(pid);
        		this.pnamefield_token.setText(pname);
        		this.datefield_token.setText(date);
        		this.pqty_token.setText(qty);
    			fields=Integer.parseInt(qty);
    			this.pname=pname;
    			this.chk=chk;
        		this.balance=balnce;
        		this.c_addr=adrs;
        		this.c_id=cid;
        		this.c_mob=mobile;
        		this.c_name=cname;
        		this.t_id=tid;
        		this.dt=date;
        		prepareToken();
    		}catch(Exception sqlex){
    			JOptionPane.showMessageDialog(new JFrame(), "Invalid Input!!!", "Error!", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	public Token(String date,String Pname,String Id,String quantity,int check){
    		
    		try{
    			OkBut=new JButton("OK");
        		datefield_token = new JTextField();
        		pnamefield_token = new JTextField();
        		pidfield_token = new JTextField();
        		this.pname=Pname;
        		pqty_token = new JTextField();
        		datefield_token.setText(date);
        		pidfield_token.setText(Id);
        		pnamefield_token.setText(Pname);
        		pqty_token.setText(quantity);
    			fields=Integer.parseInt(quantity);
    			chk=check;
    			this.dt=date;
        		prepareToken();
    		}catch(Exception sqlex){
    			JOptionPane.showMessageDialog(new JFrame(), "Invalid Input!!!", "Error!", JOptionPane.ERROR_MESSAGE);
    		}
    		
    	}
    	public Token(String date,String tid,String Pname,String Pid,String cid,String Cname,String mobile,String adrs,double gold,double stone,double charge,double vat,double total,String quantity,int chk,Sell b){
    		
    		try{
    			//Sell
    			this.s=b;
    			gl=gold;
    	   		st=stone;
    	   		chrg=charge;
    	   		vt=vat;
    	   		c_mob=mobile;
    	   		c_name=Cname;
    	   		c_addr=adrs;
    	   		t_id=tid;
    	   		dt=date;
    	   		c_id=cid;
    	   		tot=total; 
    	   		this.chk=chk;
    	   		OkBut=new JButton("OK");
    	    	datefield_token = new JTextField();
    	    	pnamefield_token = new JTextField();
    	    	pidfield_token = new JTextField();
    	    	pqty_token = new JTextField();
    	    	datefield_token.setText(dt);
    	    	pidfield_token.setText(Pid);
    	    	pnamefield_token.setText(Pname);
    	    	this.pname=Pname;
    	    	pqty_token.setText(quantity);
    			fields=Integer.parseInt(quantity);
    			this.chk=chk;
        		prepareToken();	
    		}catch(Exception sqlex){
    			JOptionPane.showMessageDialog(new JFrame(), "Invalid Input!!!", "Error!", JOptionPane.ERROR_MESSAGE);
    		}
    		

    	}
    	public Token(String date, String Pname,String Id,String quantity, String tid, String cid, String cname, String cmob, String caddr, double gold, double stone, double charge, double vat, double total, double paid, double due,int check,BookProduct b){
    		
    		try{
    			//Bookproduct
    			this.a=b;
    			OkBut=new JButton("OK");
        		datefield_token = new JTextField();
        		pnamefield_token = new JTextField();
        		pidfield_token = new JTextField();
        		pqty_token = new JTextField();
        		datefield_token.setText(date);
        		pidfield_token.setText(Id);
        		pnamefield_token.setText(Pname);
        		this.pname=Pname;
        		pqty_token.setText(quantity);
    			fields=Integer.parseInt(quantity);
    			t_id=tid;
    			chk=check;
        		c_id=cid;
        		c_name=cname;
        		c_mob=cmob;
        		c_addr=caddr;
        		gl=gold;
        		st=stone;
        		chrg=charge;
        		vt=vat;
        		tot=total;
        		pd=paid;
        		du=due;
        		dt=date;
        		prepareToken();
    		}catch(Exception sqlex){
    			JOptionPane.showMessageDialog(new JFrame(), "Invalid Input!!!", "Error!", JOptionPane.ERROR_MESSAGE);
    		}
    	}
		public void prepareToken(){
    		storeText=new JTextField[1000];
    		frame=new JFrame("Token");
    		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		frame.setSize(500, 600);
    		frame.setResizable(true);
    		frame.setLocationRelativeTo(null);
    		
            
            try {
        		URL iconurl = getClass().getResource("res/Icon_Main.png");
        		ImageIcon icon = new ImageIcon(iconurl);
        		frame.setIconImage(icon.getImage());
    		} catch (Exception e) {
    		}
            
    		
    		main_panel=new JPanel(new GridLayout(0,1));
    		panel1=new JPanel();
    		panel1.add(new JLabel("Date", JLabel.CENTER));
    		
    		datefield_token.setColumns(10);
    		datefield_token.setEditable(false);
    		datefield_token.setBackground(Color.LIGHT_GRAY);
    		datefield_token.setHorizontalAlignment(JTextField.CENTER);
    		
    		panel1.add(datefield_token);
    		panel1.add(new JLabel("Product Name", JLabel.CENTER));
    	
    		pnamefield_token.setColumns(10);
    		pnamefield_token.setEditable(false);
    		pnamefield_token.setBackground(Color.LIGHT_GRAY);
    		pnamefield_token.setHorizontalAlignment(JTextField.CENTER);
    		panel1.add(pnamefield_token);
    		JPanel panel2 = new JPanel();
    	
    		
    		pidfield_token.setColumns(10);
    		pidfield_token.setEditable(false);
    		pidfield_token.setBackground(Color.LIGHT_GRAY);
    		pidfield_token.setHorizontalAlignment(JTextField.CENTER);
   
    		panel2.add(new JLabel("Quantity", JLabel.CENTER));
    		
    		pqty_token.setColumns(10);
    		pqty_token.setEditable(false);
    		pqty_token.setBackground(Color.LIGHT_GRAY);
    		pqty_token.setHorizontalAlignment(JTextField.CENTER);
    		panel2.add(pqty_token);
    	    panel3 = new JPanel();
    		panel3.add(new JLabel("Enter Token Numbers --- ", JLabel.CENTER));
    		main_panel.add(panel1);
    		main_panel.add(panel2);
    		main_panel.add(panel3);
    		JScrollPane spane = new JScrollPane(main_panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    		spane.getVerticalScrollBar().setUnitIncrement(15);
    		
    		frame.setContentPane(spane);
    		int i=1;
    		for(i=0;i<fields;i++){
    			main_panel.add(createPane(i));
    		}
            main_panel.add(createPane1());
    		frame.setVisible(true);
    	}
    	public JPanel createPane(int i){
    		JPanel retpanel=new JPanel();
    		JTextField retText=new JTextField();
    		retText.setHorizontalAlignment(JTextField.CENTER);		// -mm
    		retText.setColumns(10);
    		retpanel.add(new JLabel(Integer.toString(i+1)));
    		retpanel.add(retText);
    		storeText[i]=retText;
    		return retpanel;
    	}
    	
    	public JPanel createPane1(){
    		JPanel retpanel=new JPanel();
    		OkBut.setFont(new java.awt.Font("Tahoma", 0, 12));
            OkBut.setPreferredSize(new java.awt.Dimension(100, 30));
            OkBut.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    OkButonActionPerformed(evt);
                }
            });
            retpanel.add(OkBut);
    		return retpanel;
    	}
    	
    	protected void OkButonActionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
    		if(chk==2){
    			DBManager db=new DBManager();
    	    	db.bookProductDB(dt, t_id, pname,fields, storeText, c_id, c_name, c_mob, c_addr, gl, st, chrg, vt, tot, pd, du);
    	    	if(db.productBookedDB())
    	    	{
    	    		frame.dispose();
        	    	a.dispose();
    	    	}
    		}
    		else if(chk==3){
    			DBManager db=new DBManager();
    			db.sellProductDB(dt, t_id,pname ,fields, storeText, c_id, c_name, c_mob, c_addr, gl, st, chrg, vt, tot);
    			if(db.productSoldDB())
    			{
    				frame.dispose();
        			s.dispose();
    			}
    		}
    		else if(chk==4){
    			DBManager db=new DBManager();
    			db.exchangeProductDB(dt, t_id,pname, fields, storeText, c_id, c_name, c_mob, c_addr, balance);
    			if(db.productExchangedDB())
    			{
    				frame.dispose();
        			e.dispose();
    			}
    		}
		}
    }