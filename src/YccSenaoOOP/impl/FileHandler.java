package YccSenaoOOP.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

import YccSenaoOOP.AbstractHandler;
import YccSenaoOOP.Candidate;
import YccSenaoOOP.ConfigManager;
import YccSenaoOOP.util.File2ByteUtil;

public class FileHandler extends AbstractHandler {
	private static Logger logger = Logger.getLogger(FileHandler.class);

	@Override
	public byte[] perform(Candidate candidate, byte[] target) {
		super.perform(candidate, target);

		logger.debug("");
		byte[] result = target;

		// (1)將檔案轉成byte[]
		// (2)或將byte[]轉成 檔案
		if (target == null) {
			result = File2ByteUtil.convertFileToByteArray(candidate);
		} else {
			File2ByteUtil.convertByteArrayToFile(candidate, target);
		}
		return result;
	}

	
}
