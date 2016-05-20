package jewelary;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class BillCreatorSell {
	
	String date, tid, cname, cid, cmob, caddr, pname;
	String []tokenList;
	double gold, stone, charge, vat, total, gtotal;
	int qty; 
	
	String billBody;
	
	public BillCreatorSell() {
	}
	
	public BillCreatorSell(String date, String tid, String cname, String cid, String cmob, String caddr,
			String pname, double gold, double stone, double charge, double vat, double total, int qty, 
			double gtotal, String []tokenList) {
		
		this.date = date;
		this.tid = tid;
		this.cname = cname;
		this.cid = cid;
		this.cmob = cmob;
		this.caddr = caddr;
		this.pname = pname;
		this.gold = gold;
		this.stone = stone;
		this.charge = charge;
		this.vat = vat;
		this.total = total;
		this.gtotal = gtotal;
		this.qty = qty;
		this.tokenList = tokenList;
	}
	
	String tokenAll = "";
	
	public String getAllToken() {
		for(int i=0; i<qty; i++) {
			tokenAll+=tokenList[i];
			if(i!=qty-1)
				tokenAll+=", ";
		}
		return tokenAll;
	}
	
	public void createBillSell() {
		this.billBody = "<html>" +
				"<CENTER>"+
					"<FONT SIZE=+2>SONALI JEWELLERS</FONT><br>"+
					"Shop: x, Level-x<br>"+
					"Bashundhara City,<br>"+
					"Pantha Path, Tejgaon, Dhaka-1215<br>"+
					"Phone: 01xxxxxxxxx, 01xxxxxxxxx"+
				"</CENTER>"+
				"<p>"+
				"<table  ALIGN=\"RIGHT\" width=\"100\">"+
					"<tr>"+
						"<td ALIGN=\"left\">Bill/Invoice</td>"+
					"</tr>"+
				"</table>"+
				"</p>"+
				"<br>"+
				"<p>"+
				"<table  border=\"1\" style=\"border-spacing:0px\" ALIGN=\"RIGHT\" width=\"150\">"+
					"<tr>"+
						"<td ALIGN=\"CENTER\">Date</td>"+
						"<td ALIGN=\"LEFT\">"+date+"</td>"+		// date
					"</tr>"+
					"<tr>"+
						"<td ALIGN=\"CENTER\">Transaction ID</td>"+
						"<td ALIGN=\"CENTER\">"+tid+"</td>"+		// tid
					"</tr>"+
				"</table>"+
				"</p>"+
				"<br>"+
				"<p>"+
					"<table ALIGN=\"LEFT\" border=\"0\" width=\"220\">"+
						"<tr>"+
							"<td>Client Name</td>"+
							"<td>"+cname+"</td>"+					// cname
						"</tr>"+
						"<tr>"+
							"<td>ID</td>"+
							"<td>"+cid+"</td>"+						// cid
						"</tr>"+
						"<tr>"+
							"<td>Mobile</td>"+
							"<td>"+cmob+"</td>"+					// cmob
						"</tr>"+
						"<tr>"+
							"<td>Address</td>"+
							"<td>"+caddr+"</td>"+					//caddr
						"</tr>"+
					"</table>"+
				"</p>"+
				"<br><br><br><br><br><br><br>"+
				"<CENTER>"+
				"<table style=\"border-spacing:0px\" border=\"1\" cellpadding=\"15\">"+
				"<tr>"+
				  "<th>Product Name</th>"+
				  "<th>Gold<br>(per qty)</th>	"+	
				  "<th>Stone<br>(per qty)</th>	"+
				  "<th>Charge<br>(per qty)</th>	"+
				  "<th>VAT<br>(per qty)</th>	"+
				  "<th>Total</th>	"+
				  "<th>Quantity</th>	"+
				  "<th>Grand Total</th>"+
				"</tr>"+
				"<tr>"+
					"<td>"+pname+"</td>"+							//  all
					"<td ALIGN=\"CENTER\">"+gold+"<br>Tk.</td>"+
					"<td ALIGN=\"CENTER\">"+stone+"<br>Tk.</td>"+
					"<td ALIGN=\"CENTER\">"+charge+"<br>Tk.</td>"+
					"<td ALIGN=\"CENTER\">"+vat+"<br>Tk.</td>"+
					"<td ALIGN=\"CENTER\">"+total+"<br>Tk.</td>"+
					"<td ALIGN=\"CENTER\">"+qty+"</td>"+
					"<td ALIGN=\"CENTER\">"+gtotal+"<br>Tk.</td>"+
				"</tr>"+
				"</table>"+
				"</CENTER>"+
				"<p ALIGN=\"CENTER\">"+
					"Sold Token No: "+this.getAllToken()+""+
				"</p>"+
				"<br><br><br><br><br><br><br>"+
				"<p>"+
					"<table ALIGN=\"LEFT\" border=\"0\" width=\"800\">"+
						"<tr>"+
							"<td ALIGN=\"CENTER\">________________</td>"+
							"<td ALIGN=\"CENTER\">___________________</td>"+
						"</tr>"+
						"<tr>"+
							"<td ALIGN=\"CENTER\">Customer's Sign</td>"+
							"<td ALIGN=\"CENTER\">Payment Recieved By</td>"+
						"</tr>"+
						"</table>"+
				"</p>"+
			"</html>";
		
		try {
			String thisDate = this.currectdata();
			String path = "D:/Sonali Jewellers Bills/Sell/"+thisDate+"";
			boolean dirCreated = new File(path).mkdirs();
			File billFile = new File(path+"/"+tid+".html");
			billFile.createNewFile();
			FileWriter writer = new FileWriter(billFile);
			writer.write(billBody);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "blCer", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public String currectdata(){
        Calendar cal=new GregorianCalendar();
        int month=cal.get(Calendar.MONTH)+1;
        int year=cal.get(Calendar.YEAR);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        return day+"."+month+"."+year;
	}
}
