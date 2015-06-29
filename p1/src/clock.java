import java.util.Calendar;

import javax.swing.JTextField;
import java.text.DateFormat;

public class clock extends Thread implements Runnable{

	private JTextField txt;
	private boolean stop;

	private final static java.text.SimpleDateFormat timerFormat = new java.text.SimpleDateFormat("mm : ss");
	
	public clock(JTextField txt)
	{
		this.txt = txt;
		stop = false;
		
	}
	
	
	public void run() 
	{
		long startTime = System.currentTimeMillis();
	
		while(!stop) 
		{			
				long now = (System.currentTimeMillis() - startTime);
			
				txt.setText(timerFormat.format(new java.util.Date(now)));
			
			try 
			{
				this.sleep(1000);
			} 
			catch (InterruptedException e) 
			{				
				e.printStackTrace();				
			}
		}
		
	}
	
	public void stopClock()
	{
		stop = true;
		
	}
	
	public void startClock(){
		stop = false;
		this.start();
		
	}

	
	
}
