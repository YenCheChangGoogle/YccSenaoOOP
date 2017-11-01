package YccSenaoOOP.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

import org.apache.log4j.Logger;

import YccSenaoOOP.AbstractHandler;
import YccSenaoOOP.Candidate;

public class ZipHandler extends AbstractHandler {
	private static Logger logger = Logger.getLogger(ZipHandler.class);
	
	@Override
	public byte[] perform(Candidate candidate, byte[] target) {
		super.perform(candidate, target);
		byte[] result = target;

		// (1)當第二個參數為null時, 不做任何壓縮
		// (2)當傳入byte[]時, 壓縮後回傳byte[]
		if (target != null) {
			result = this.zipData(candidate, target);
		}
		return result;
	}

	// 將byte[]加以壓縮, 並傳回byte[]
	private byte[] zipData(Candidate candidate, byte[] target) {
		return compressor(target);
	}

	private static byte[] compressor(byte[] compressedData) {
		logger.debug("");
		
		Deflater compressor = new Deflater();
		compressor.setLevel(Deflater.BEST_COMPRESSION);
		compressor.setInput(compressedData);
		compressor.finish();

		ByteArrayOutputStream bos = new ByteArrayOutputStream(compressedData.length);
		try {
			byte[] buf = new byte[1024];
			while (!compressor.finished()) {
				int count = compressor.deflate(buf);
				bos.write(buf, 0, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null)
					bos.close();
			} catch (Exception ex) {
			}
		}
		byte result[] = bos.toByteArray();
		logger.debug("壓縮後：" + Arrays.toString(result));
		return result;
	}

	// 解壓縮
	private static byte[] decompressor(byte[] compressedData) {
		logger.debug("");
		
		Inflater decompressor = new Inflater();
		decompressor.setInput(compressedData);
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream(compressedData.length);
			byte[] buf = new byte[1024];
			while (!decompressor.finished()) {
				int count = decompressor.inflate(buf);
				bos.write(buf, 0, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null)
					bos.close();
			} catch (Exception ex) {
			}
		}
		byte[] result = bos.toByteArray();
		logger.debug("解壓縮後：" + Arrays.toString(result));
		return result;
	}
}
