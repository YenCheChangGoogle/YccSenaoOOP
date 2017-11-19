package YccSenaoOOP.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import YccSenaoOOP.AbstractHandler;
import YccSenaoOOP.HandlerFactory;
import YccSenaoOOP.myBackupCandidate.Candidate;
import YccSenaoOOP.util.File2ByteUtil;
import YccSenaoOOP.util.FileCopyUtil;

//將檔案複製到指定目錄
public class DirectoryHandler extends AbstractHandler {
	private static Logger logger = Logger.getLogger(DirectoryHandler.class);
	
	@Override
	public byte[] perform(Candidate candidate, byte[] target) {
		super.perform(candidate, target);
		byte[] result = target;

		//(1)當第二個參數為 null時, 不做任何複製
		//(2)當傳入byte[]時, 複製到其他目錄
		if (target != null) {
			result = this.copyToDirectory(candidate, target);
		}
		return result;
	}

	private byte[] copyToDirectory(Candidate candidate, byte[] target) {
		logger.debug("");
		
		File srcFile = File2ByteUtil.convertByteArrayToFile(candidate, target);
		String filepath = candidate.getConfig().getDir() + File.separator + candidate.getName();
		File destFile =new File(filepath);
		
		try {
			FileCopyUtil.copyFileUsingApacheCommonsIO(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return target;
		
	}

}
