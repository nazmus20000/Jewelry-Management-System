package jewelary;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Token_AddProduct {
	public JFrame frame;
	public JPanel main_panel;
	public JPanel panel1;
	public JPanel panel2;
	public JPanel panel3;
	public JPanel panel4;
	public JTextField datefield_token;
	public JTextField pnamefield_token;
	public JTextField pidfield_token;
	public JTextField pqty_token;
	public JTextField [] WeightTxt;
	public JTextField [] TokenTxt;
	public  String date;
	public  String pname;
	public String pid;
	int fields;
	public JButton OkBut;
	public void PrepareToken(){
		WeightTxt=new JTextField[1000];
		TokenTxt=new JTextField[1000];
		frame=new JFrame();
		OkBut=new JButton("OK");
		frame=new JFrame();
		frame.setSize(500,600);
		frame.getRootPane().setDefaultButton(OkBut);
		main_panel=new JPanel(new GridLayout(0,1));
		 panel1=new JPanel();
		 datefield_token=new JTextField();
		 datefield_token.setColumns(10);
		 datefield_token.setHorizontalAlignment(JLabel.CENTER);
		 datefield_token.setEditable(true);
		 panel1.add(new JLabel("Date :",JLabel.CENTER));
		 panel1.add(datefield_token);
		 panel1.add(new JLabel("product name:",JLabel.CENTER));
		 pnamefield_token=new JTextField(JTextField.CENTER);
		 pnamefield_token.setColumns(10);
		 pnamefield_token.setHorizontalAlignment(JTextField.CENTER);
		 panel1.add(pnamefield_token);
		 panel2=new JPanel();
		 pidfield_token=new JTextField();
		 pidfield_token.setHorizontalAlignment(JTextField.CENTER);
		 this.pidfield_token.setColumns(10);

		 panel2.add(new JLabel("Quantity :",JLabel.CENTER));
		 this.pqty_token=new JTextField();
		 pqty_token.setColumns(10);
		 pqty_token.setHorizontalAlignment(JTextField.CENTER);
		 panel2.add(pqty_token);
		 main_panel.add(panel1);
		 main_panel.add(panel2);
		 panel3=new JPanel();
		 panel3.add(new JLabel("Enter Token Numbers :",JLabel.CENTER));
		 main_panel.add(panel3);
		 panel4=new JPanel();
		 panel4.add(OkBut);
		 OkBut.addActionListener(new clik());
		 int c;
		 for(c=0;c<fields;c++){
			 JPanel  sr=new JPanel();
			 sr.add(new JLabel(Integer.toString(c+1)));
			 sr.add(new JLabel("Token NO :"));
			 JTextField txt=new JTextField();
			 txt.setHorizontalAlignment(JTextField.CENTER);
			 txt.setColumns(10);
			 TokenTxt[c]=txt;
			 sr.add(txt);
			 sr.add(new JLabel("Weight :"));
			 JTextField txt2=new JTextField();
			 txt2.setHorizontalAlignment(JTextField.CENTER);
			 txt2.setColumns(10);
			 WeightTxt[c]=txt2;
			 sr.add(txt2);
			 main_panel.add(sr);
		 }
		 main_panel.add(panel4);
		 JScrollPane spane = new JScrollPane(main_panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 		spane.getVerticalScrollBar().setUnitIncrement(15);
		frame.setContentPane(spane);
		frame.setTitle("Product Info - add Product");	// -mm
		try {
    		URL iconurl = getClass().getResource("res/Icon_Main.png");
    		ImageIcon icon = new ImageIcon(iconurl);
    		frame.setIconImage(icon.getImage());
		} catch (Exception e) {
		}
		this.frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
	}
	public Token_AddProduct(String date,String pname,String pid,String qty){
		this.date=date;
		this.pname=pname;
		this.pid=pid;
		this.fields=Integer.parseInt(qty);
		PrepareToken();
		this.datefield_token.setText(date);
		this.datefield_token.setEditable(false);
		this.pnamefield_token.setText(pname);
		this.pnamefield_token.setEditable(false);
		this.pidfield_token.setText(pid);
		this.pidfield_token.setEditable(false);
		this.pqty_token.setText(qty);
		this.pqty_token.setEditable(false);
		tokengenerate();
        }
	public void tokengenerate(){
		DBManager db=new DBManager();
		String s=db.getTokenLastDB4(pname);	// edited -mm
		int c,presentToken;
		for(c=0;c<fields;c++){
			TokenTxt[c].setText(s);
			TokenTxt[c].setEditable(false);
			presentToken=Integer.parseInt(s)+1;
			s=Integer.toString(presentToken);
		}
	}
	
	public class clik implements ActionListener{
		public void actionPerformed(ActionEvent e){
			 DBManager db=new DBManager();
			db.addNewProductDB(date, fields, pid, pname, TokenTxt, WeightTxt);
			frame.dispose();
		}
	}
}