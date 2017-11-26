package YccSenaoOOP.Handler.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.log4j.Logger;

import YccSenaoOOP.Handler.AbstractHandler;
import YccSenaoOOP.Manager.ConfigManager;
import YccSenaoOOP.MyBackupCandidate.Candidate;
import YccSenaoOOP.Util.File2ByteUtil;

public class FileHandler extends AbstractHandler {
	private static Logger logger = Logger.getLogger(FileHandler.class);

	@Override
	public byte[] perform(Candidate candidate, byte[] target) {
		super.perform(candidate, target);
		
		byte[] result = target;

		//(1)將檔案轉成byte[]
		//(2)或將byte[]轉成 檔案
		if (target == null) {
			
			//for(String s:candidate.getConfig().getHandlers()) {
			//	if(s.equals("toBytes")) {
					result = File2ByteUtil.convertFileToByteArray(candidate);
			//		break;
			//	}
			//}					
			
		} else {
			//for(String s:candidate.getConfig().getHandlers()) {
			//	if(s.equals("toBytes")) {
					File2ByteUtil.convertByteArrayToFile(candidate, target);
			//		break;
			//	}
			//}
		}
		logger.debug("資料流長度="+result.length);
		return result;
	}

	
}
