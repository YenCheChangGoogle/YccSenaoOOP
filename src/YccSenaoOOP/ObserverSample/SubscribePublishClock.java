package YccSenaoOOP.ObserverSample;

import org.apache.log4j.Logger;

//定時音樂鬧鐘(可訂閱區間通知: 例如: 每分, 每5分, 每30分, 每60分通知)
public class SubscribePublishClock implements java.lang.Runnable {
	
	private static Logger logger = Logger.getLogger(DigitalClock.class);
	private static java.text.NumberFormat nf=java.text.NumberFormat.getInstance();
	static {
		nf.setMaximumIntegerDigits(2);
		nf.setMinimumIntegerDigits(2);
	}
	
	private java.util.HashMap<String, java.util.List<ISubscriber>> Subscribers=new java.util.HashMap<String, java.util.List<ISubscriber>>();
	
	private int doInvokeMinute=-1; //有執行過的喚醒當下的分鐘為何
	private Clock clock=new Clock();
	public SubscribePublishClock() {
		Thread t=new Thread(this);
		t.start();
	}
	
	//加入訂閱者
	public void addSubscriber(ISubscriber subscriber) {
		String ID=getSubscribersKey(subscriber.getSubscriberMin());
		java.util.List<ISubscriber> list=null;
		list=Subscribers.get(ID);
		if(list==null) {
			list=new java.util.ArrayList<ISubscriber>();			
		}
		list.add(subscriber);
		Subscribers.put(ID, list);
	}
	
	private String getSubscribersKey(int i) {
		return "T"+i;
	}
	
	//取得訂閱者的清單(T0~T60)
	private java.util.List<ISubscriber> getTheSubscribers(String ID) {
		return Subscribers.get(ID);
	}
	
	//觸發呼叫訂閱者
	public void invoke() {
		//System.out.println(nf.format(clock.HOUR_OF_DAY)+":"+nf.format(clock.MINUTE)+":"+nf.format(clock.SECOND));
		
		if(this.doInvokeMinute==clock.MINUTE) {
			//此分鐘已經有喚醒過, 即不再喚醒一次
		}
		else {
			doInvokeMinute=-1;
			java.util.List<ISubscriber> list = this.getTheSubscribers(getSubscribersKey(clock.MINUTE));
			if (list != null) {
				doInvokeMinute = clock.MINUTE;
				for (ISubscriber client : list) {
					client.update();
				}
			}
		}		
	}

	public void run() {		
		while (true) {
			synchronized (clock) {
				try { clock.wait(); } catch (Exception e) {}
				invoke();
			}
		}
	}
	
}
