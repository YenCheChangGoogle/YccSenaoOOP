package YccSenaoOOP.ObserverSample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundUtils {

	public static float SAMPLE_RATE = 8000f;

	public static void tone(int hz, int msecs) throws LineUnavailableException {
		tone(hz, msecs, 1.0);
	}

	public static void tone(int hz, int msecs, double vol) throws LineUnavailableException {

		byte[] buf = new byte[1];
		AudioFormat af = new AudioFormat(
				SAMPLE_RATE, // sampleRate
				8,           // sampleSizeInBits
				1,           // channels
				true,        // signed
				false);      // bigEndian

		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();
		for (int i = 0; i < msecs * 8; i++) {
			double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
			buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
			sdl.write(buf, 0, 1);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}

	public static void main(String[] args) throws Exception {
		
		SoundUtils.tone(1000, 100);
		
		Thread.sleep(1000);		
		SoundUtils.tone(100, 1000);
		
		Thread.sleep(1000);
		SoundUtils.tone(5000, 100);
		
		Thread.sleep(1000);
		SoundUtils.tone(400, 500);
		
		Thread.sleep(1000);
		SoundUtils.tone(400, 500, 0.2);
		
		File f=new File("D:/Git/Repository/Senao/github.com/YccSenaoOOP/src/YccSenaoOOP/ObserverSample/Ring08.wav");
		SoundUtils su=new SoundUtils();
		su.playSound(f);
		
		Thread.sleep(11000);
		f=new File("D:/Git/Repository/Senao/github.com/YccSenaoOOP/src/YccSenaoOOP/ObserverSample/Ring05.wav");		
		su.playSoundInternal(f);
	}

	//播放音樂檔案
	public void playSound(File f) {
		Runnable r = new Runnable() {
			private File f;

			public void run() {
				playSoundInternal(this.f);
			}

			public Runnable setFile(File f) {
				this.f = f;
				return this;
			}
		}.setFile(f);

		new Thread(r).start();
	}

	//播放音樂檔案
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
