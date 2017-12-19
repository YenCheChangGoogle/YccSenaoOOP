package YccSenaoOOP.ObserverSample;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.log4j.Logger;

//訂閱者
public class Subscriber extends DigitalClock implements ISubscriber {

	private static Logger logger = Logger.getLogger(Subscriber.class);
	private int SubscriberMin=0;
	
	private File soundFile=null;
	private static File soundFile1=new File("D:/Git/Repository/Senao/github.com/YccSenaoOOP/src/YccSenaoOOP/ObserverSample/Ring08.wav");
	private static File soundFile2=new File("D:/Git/Repository/Senao/github.com/YccSenaoOOP/src/YccSenaoOOP/ObserverSample/Ring05.wav");
	
	public Subscriber(int min)throws Exception {
		super("★★★【每小時的第"+min+"分鐘撥放音樂】★★★");
		if(min<0 || min>60) throw new Exception("[(每小時60分鐘] 合理的指定值是0~60] 無法指定負數的值或是大於60的數值, 你目前設定的是"+min);
		this.SubscriberMin=min;
		
		//單數或偶數分的撥放聲音不同
		if(min%2==0) {
			soundFile=soundFile1;
		}
		else {
			soundFile=soundFile2;
		}
	}
	
	public void update() {		
		playSound(soundFile);	
	}

	public int getSubscriberMin() {
		return SubscriberMin;		
	}
	
	//播放音樂檔案
	public void playSound(File f) {
		Runnable r = new Runnable() {
			private File f;
			public void run() {
				Color c=getLabelColor();
				setLabelColor(Color.yellow);
				//System.out.println(getLabelColor());
				playSoundInternal(this.f);				
				setLabelColor(c);				
			}
			public Runnable setFile(File f) {
				this.f = f;
				return this;
			}
		}.setFile(f);

		new Thread(r).start();
	}
	
	public void playSoundInternal(File f) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				try {
					clip.start();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					clip.drain();
				} finally {
					clip.close();
				}
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} finally {
				audioInputStream.close();
			}
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
