package YccSenaoOOP.Handler.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import org.apache.log4j.Logger;

import YccSenaoOOP.Handler.AbstractHandler;
import YccSenaoOOP.MyBackupCandidate.Candidate;

public class ZipHandler extends AbstractHandler {
	private static Logger logger = Logger.getLogger(ZipHandler.class);
	
	@Override
	public byte[] perform(Candidate candidate, byte[] target) {
		super.perform(candidate, target);
		byte[] result =null;

		//(1)當第二個參數為null時, 不做任何壓縮
		//(2)當傳入byte[]時, 壓縮後回傳byte[]
		if (target != null) {
			for(String s:candidate.getConfig().getHandlers()) {
				if(s.equals("zip")) {
					result = this.zipData(candidate, target);
					logger.debug(result.length);
				}
			}
		}
		return result;
	}

	//將byte[]加以壓縮, 並傳回byte[]
	private byte[] zipData(Candidate candidate, byte[] target) {
		return compressor(target);
	}

	private static int cachesize = 1024; 
	private static Deflater compressor = new Deflater();
	private static Inflater decompressor = new Inflater();

	//壓縮
	private static byte[] compressor(byte[] compressedData) {
		logger.debug("壓縮");

		try {
			compressor.reset();
		} catch (Exception ex) {
			ex.printStackTrace();
			compressor = new Deflater();
		}

		compressor.setLevel(Deflater.BEST_COMPRESSION);
		compressor.setInput(compressedData);
		compressor.finish();
		logger.debug("壓縮前 (" + (compressedData.length)+")");
		//logger.debug("壓縮前 ：" + Arrays.toString(compressedData));
		ByteArrayOutputStream bos = new ByteArrayOutputStream(compressedData.length);
		long len = 0;
		byte result[] = null;
		try {
			byte[] buf = new byte[cachesize];
			int compressedDataLength;
			while (!compressor.finished()) {
				compressedDataLength = compressor.deflate(buf);
				len += compressedDataLength;
				bos.write(buf, 0, compressedDataLength);
			}
			//compressor.end();
			result = bos.toByteArray();
			logger.debug("壓縮後 (" + (result.length)+")");
			//logger.debug("壓縮後 ：" + Arrays.toString(result));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null)
					bos.close();
			} catch (Exception ex) {
			}
		}
		return result;
	}

	//解壓縮
	private static byte[] decompressor(byte[] compressedData) {
		logger.debug("解壓縮");

		byte[] result = null;
		try {
			decompressor.reset();
		} catch (Exception ex) {
			ex.printStackTrace();
			decompressor = new Inflater();
		}
		decompressor.setInput(compressedData);
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream(compressedData.length);
			byte[] buf = new byte[1024];
			while (!decompressor.finished()) {
				int count = decompressor.inflate(buf);
				bos.write(buf, 0, count);
			}
			// decompressor.end();
			result = bos.toByteArray();
			//logger.debug("解壓縮後 ：" + Arrays.toString(result));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null)
					bos.close();
			} catch (Exception ex) {
			}
		}

		return result;
	}
	
	
	
	
	
	
 
	
	public static void main(String args[]) {
		String s="11111111122222222222222223333333333";
		ZipHandler zip=new ZipHandler();
		try {
			byte b[]=zip.compressor(s.getBytes("UTF-8"));
			
			b=zip.decompressor(b);
			
			b=zip.compressor(s.getBytes("UTF-8"));
			
			b=zip.decompressor(b);			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/*
		try {
			// Encode a String into bytes
			String inputString = "DEMO";
			byte[] input = inputString.getBytes("UTF-8");

			System.out.println(input.length);
			// Compress the bytes
			byte[] output = new byte[100];
			Deflater compresser = new Deflater();
			compresser.setInput(input);
			compresser.finish();
			int compressedDataLength = compresser.deflate(output);
			compresser.end();

			System.out.println(output.length);
			// Decompress the bytes
			Inflater decompresser = new Inflater();
			decompresser.setInput(output, 0, compressedDataLength);
			byte[] result = new byte[100];
			int resultLength = decompresser.inflate(result);
			decompresser.end();

			// Decode the bytes into a String
			String outputString = new String(result, 0, resultLength, "UTF-8");
			System.out.println(outputString);
		} catch (java.io.UnsupportedEncodingException ex) {
			// handle
		} catch (java.util.zip.DataFormatException ex) {
			// handle
		}
		*/
	}
}
