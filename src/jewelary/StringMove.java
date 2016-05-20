package jewelary;
import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class StringMove extends JPanel {
//	public JFrame frame;
	public JDialog frame;
	String main;
	String sakib;
	String sakib_phone;
	String sourav;
	String sourav_phone;
	String minar;
	String minar_phone;
	int x_main=30;
	int y_main=550;
	int sakib_x=30;
	int sakib_y=600;
	int sourav_x=30;
	int sourav_y=680;
	int minar_x=30;
	int minar_y=640;
	int sakib_phone_x=180;
	int sakib_phone_y=600;
	int minar_phone_x=180;
	int minar_phone_y=640;
	int sourav_phone_x=180;
	int sourav_phone_y=680;
	int ple_x=130;
	int ple_y=250;
	String pleasure;
	String satisfaction;
	public void stringsAndints(){
	main="Developed By :";
	 sakib="Nazmus Sakib";
	 sakib_phone="(01677 560055)";
	 minar="Minar Mahmud";
	 minar_phone="(01680 242818)";
	 sourav="Sourav Saha";
	 sourav_phone="(01677 059861)";
	}
	public void paintComponent(Graphics d){
		this.stringsAndints();
		super.paintComponent(d);
		this.setBackground(Color.WHITE);
		d.setColor(Color.BLUE);
		d.setFont(new Font("default",Font.BOLD,30));
		d.drawString(main, x_main, y_main);
		d.setFont(new Font("default",Font.LAYOUT_LEFT_TO_RIGHT,20));
		d.drawString(sakib, sakib_x, sakib_y);
		d.drawString(sakib_phone, sakib_phone_x, sakib_phone_y);
		d.drawString(minar, minar_x, minar_y);
		d.drawString(minar_phone, minar_phone_x, minar_phone_y);
		d.drawString(sourav, sourav_x, sourav_y);
		d.drawString(sourav_phone, sourav_phone_x, sourav_phone_y);
		if(y_main==100){
			d.setFont(new Font("default",Font.ITALIC,20));
			d.drawString("YOUR PLEASURE IS OUR SATISFACTION", 60, 350);
			d.setFont(new Font("default",Font.ITALIC,40));
			d.drawString("Thank You :)",140,400);
		}
		

	}
	public StringMove(){
//		frame=new JFrame("Developers Info");
		frame = new JDialog();
		frame.setTitle("Developers Info");
		frame.setSize(500,500);
		frame.add(this);
		try {
			URL iconurl = getClass().getResource("res/dev4.png");
			ImageIcon icon = new ImageIcon(iconurl);
			frame.setIconImage(icon.getImage());
		} catch (Exception e) {
		}
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
//		frame.setModal(true);
		frame.setVisible(true);
	}
}