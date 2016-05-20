package jewelary;

import java.util.*;

public class move extends Thread {
	StringMove moves;
	boolean a=true;
	public move(){
		moves=new StringMove();
	}
	public void run(){
		while(a){
			try{
				moves.y_main-=2;
				moves.sakib_y-=2;
				moves.sakib_phone_y-=2;
				moves.sourav_y-=2;
				moves.sourav_phone_y-=2;
				moves.minar_y-=2;
				moves.minar_phone_y-=2;
				if(moves.y_main==100){
					a=false;
				}
				moves.repaint();
				Thread.sleep(15);
				
			}
			catch(Exception e){
				
			}
		}
		
	}
	public static void main(String[] args){
		move a=new move();
		a.start();
	}
}