package YccSenaoOOP.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import YccSenaoOOP.HandlerFactory;
import YccSenaoOOP.MyBackupCandidate.Candidate;

public class File2ByteUtil {
	private static Logger logger = Logger.getLogger(File2ByteUtil.class);
	
	//將檔案轉成byte[]
	public static byte[] convertFileToByteArray(Candidate candidate) {
		String filepath = candidate.getConfig().getLocation() + File.separator + candidate.getName();
		logger.debug(filepath);
		try {
			
			/*
			Path fileLocation = Paths.get(filepath);
			byte[] data = Files.readAllBytes(fileLocation);
			logger.debug("######## "+data.length);
			*/
			
			//Stream<String> lines=Files.lines(fileLocation, StandardCharsets.UTF_8);
			
			StringBuffer sb=new StringBuffer();
			java.io.File file=new java.io.File(filepath);
			java.io.FileInputStream fis=new java.io.FileInputStream(file);			
			java.io.InputStreamReader isr=new java.io.InputStreamReader(fis, StandardCharsets.UTF_8);
			java.io.BufferedReader br=new java.io.BufferedReader(isr, 2048);
			
			while(true) {
				String line=null;
				try { line=br.readLine(); }catch(Exception ex) { break; }
				if(line==null) break;
				else sb.append(line);
			}
			br.close();
			isr.close();		
			byte[] data=sb.toString().getBytes();
			
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//將byte[]轉成檔案
	public static File convertByteArrayToFile(Candidate candidate, byte[] target) {
		File file=null;
		FileOutputStream fileOuputStream = null;
		try {
			//String filepath = candidate.getConfig().getLocation() + File.separator + candidate.getName();
			String filepath = candidate.getConfig().getDir() + File.separator + candidate.getName();
			
			file=new File(filepath);
			fileOuputStream = new FileOutputStream(file);

			fileOuputStream.write(target);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOuputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
}
