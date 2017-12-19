package YccSenaoOOP.ObserverSample;

import java.awt.Color;

public class SubscribeClockDemo {

	public static void main(String[] args) throws Exception {

		System.out.println("可以設定要幾分被喚醒撥放音樂");
		
		SubscribePublishClock sc=new SubscribePublishClock();
	
		//設定要幾分被喚醒撥放音樂
		Subscriber subscriber1=new Subscriber(1);
		Subscriber subscriber2=new Subscriber(1);
		Subscriber subscriber3=new Subscriber(1);		
		Subscriber subscriber4=new Subscriber(5);		
		Subscriber subscriber5=new Subscriber(32);		
		Subscriber subscriber6=new Subscriber(49);		
		Subscriber subscriber7=new Subscriber(49);		
		Subscriber subscriber8=new Subscriber(60);
		
		sc.addSubscriber(subscriber1);
		sc.addSubscriber(subscriber2);
		sc.addSubscriber(subscriber3);
		sc.addSubscriber(subscriber4);
		sc.addSubscriber(subscriber5);
		sc.addSubscriber(subscriber6);
		sc.addSubscriber(subscriber7);
		sc.addSubscriber(subscriber8);
	}

}
