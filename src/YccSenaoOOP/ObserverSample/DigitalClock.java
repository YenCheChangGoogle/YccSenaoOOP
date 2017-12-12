package YccSenaoOOP.ObserverSample;

import java.awt.FlowLayout;
import java.awt.Rectangle;

import org.apache.log4j.Logger;

public class DigitalClock implements java.lang.Runnable {

	private static Logger logger = Logger.getLogger(DigitalClock.class);
	private Clock clock=new Clock();
	
	private static java.text.NumberFormat nf=java.text.NumberFormat.getInstance();
	static {
		nf.setMaximumIntegerDigits(2);
		nf.setMinimumIntegerDigits(2);
	}
	private javax.swing.JFrame jframe=new javax.swing.JFrame("★★★★★【24小時制電子鐘】★★★★★");
	private javax.swing.JLabel H24=new javax.swing.JLabel("00");
	private javax.swing.JLabel Dot_H24_MI=new javax.swing.JLabel(":");
	private javax.swing.JLabel MI=new javax.swing.JLabel("00");
	private javax.swing.JLabel Dot_MI_SS=new javax.swing.JLabel(":");
	private javax.swing.JLabel SS=new javax.swing.JLabel("00");
	
	public DigitalClock() {
		init();
		
		Thread t=new Thread(this);
		t.start();
	}
	private void init() {
		jframe.setIconImage(jframe.getToolkit().getImage("D:/Git/Repository/Senao/github.com/YccSenaoOOP/src/icons-clock.jpg")); // 設定圖示
		
		jframe.setSize(460, 180);				
		
		//設定視窗開啟時的位置，有以下兩種常用設定方法
        jframe.setLocation(0,0); //設定視窗開啟時左上角的座標，也可帶入Point物件
        jframe.setLocationRelativeTo(null); //設定開啟的位置和某個物件相同，帶入null則會在畫面中間開啟

        //關閉選項(右上角的叉叉圖示)按下後的動作
        //EXIT_ON_CLOSE：      點選關閉時，關閉程式
        //DISPOSE_ON_CLOSE：點選關閉時，關閉顯示的視窗以及使用的資源，程式仍在背景執行
        //HIDE_ON_CLOSE：      點選關閉時，僅隱藏顯示的視窗，程式仍在背景執行
        jframe.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        java.awt.Font font=new java.awt.Font(H24.getFont().getName(), H24.getFont().getStyle(), 100);
        H24.setFont(font);
        Dot_H24_MI.setFont(font);
        MI.setFont(font);
        Dot_MI_SS.setFont(font);
        SS.setFont(font);
        
		jframe.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		jframe.add(H24);
		jframe.add(Dot_H24_MI);
		jframe.add(MI);
		jframe.add(Dot_MI_SS);
		jframe.add(SS);
		
		jframe.setResizable(false);
		//jframe.pack();
		jframe.setVisible(true);
		
	}
	
	public void update(int hours, int minutes, int seconds) {
			H24.setText(nf.format(hours));
			MI.setText(nf.format(minutes));
			SS.setText(nf.format(seconds));
			System.out.println(nf.format(hours)+":"+nf.format(minutes)+":"+nf.format(seconds));
	}
	
	public void run() {		
		while (true) {
			//logger.debug("更新畫面");
			synchronized (clock) {
				try { clock.wait(); } catch (Exception e) {}
				update(clock.HOUR_OF_DAY, clock.MINUTE, clock.SECOND);
			}
		}
	}

	public static void main(String[] args) {
		DigitalClock dc=new DigitalClock();
	}	
}
