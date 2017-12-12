package YccSenaoOOP.ObserverSample;

import java.time.temporal.TemporalField;

import org.apache.log4j.Logger;

public class Clock implements java.lang.Runnable {

	public static int HOUR_OF_DAY;
	public static int MINUTE;
	public static int SECOND;
	
	private java.util.Calendar cal=java.util.Calendar.getInstance();
	private static Logger logger = Logger.getLogger(Clock.class);	
	
	public Clock() {
		Thread t=new Thread(this);
		t.start();
	}
	
	public void run() {
		while(true) {
			
			cal.setTimeInMillis(System.currentTimeMillis());
			HOUR_OF_DAY=cal.get(cal.HOUR_OF_DAY);
			MINUTE=cal.get(cal.MINUTE);
			SECOND=cal.get(cal.SECOND);
			
			onTick();
			
			try { Thread.currentThread().sleep(1000); }catch(Exception e) {}
		}
	}
	
	public void onTick(){		
		synchronized(this) {
			this.notifyAll();
			//logger.debug(HOUR_OF_DAY+":"+MINUTE+":"+SECOND);
		}		
	}

	//public static void main(String[] args) {
	//	Clock c=new Clock();
	//}

}
