package jewelary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    public class cliked implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getActionCommand().equals("Sell")){
    			Sell s=new Sell();
    			s.setVisible(true);
    			s.setob(s);
    		}
    		else if(e.getActionCommand().equals("Exchange")){
    			Exchange s=new Exchange();
    			s.setVisible(true);
    			s.setob(s);
    		}
    		else if(e.getActionCommand().equals("AcountInfo")){
    			new Accounts().setVisible(true);
    
    		}
    		else if(e.getActionCommand().equals("add")){
    			new Addprodect().setVisible(true);
    
    		}
    		else if(e.getActionCommand().equals("pending")){
    			DBManager db=new DBManager();
    			db.showPendingDB();
    			if(db.flag==1)new ShowPending().setVisible(true);
    
    		}
    		else if(e.getActionCommand().equals("stock")){
    			Stock s=new Stock();
    			s.setVisible(true);
    		}
    		else if(e.getActionCommand().equals("Advance")){
    			new AdvancePayment().setVisible(true);
    
    		}
    		else if(e.getActionCommand().equals("Others")){
    			new Others().setVisible(true);
    
    		}
    	}
    }