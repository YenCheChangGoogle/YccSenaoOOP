package YccSenaoOOP.Handler.impl;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;

import YccSenaoOOP.Handler.AbstractHandler;
import YccSenaoOOP.MyBackupCandidate.Candidate;
import YccSenaoOOP.Util.File2ByteUtil;
import YccSenaoOOP.Util.FileCopyUtil;

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
		
		File2ByteUtil.convertByteArrayToFile(candidate, target);
		
		/*
		File srcFile = File2ByteUtil.convertByteArrayToFile(candidate, target);
		String filepath = candidate.getConfig().getDir() + File.separator + candidate.getName();
		File destFile =new File(filepath);
		
		logger.debug(srcFile.getAbsolutePath());
		logger.debug(destFile.getAbsolutePath());
		try {
			//FileCopyUtil.copyFileUsingApacheCommonsIO(srcFile, destFile);
			//FileCopyUtil.copyFileUsingStream(srcFile, destFile);
			FileCopyUtil.copyFileUsingChannel(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		return target;
		
	}

}
