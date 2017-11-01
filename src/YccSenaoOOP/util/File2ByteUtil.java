package YccSenaoOOP.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import YccSenaoOOP.Candidate;

public class File2ByteUtil {
	
	// 將檔案轉成byte[]
	public static byte[] convertFileToByteArray(Candidate candidate) {
		String filepath = candidate.getConfig().getLocation() + File.separator + candidate.getName();
		try {
			Path fileLocation = Paths.get(filepath);
			byte[] data = Files.readAllBytes(fileLocation);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 將byte[]轉成檔案
	public static File convertByteArrayToFile(Candidate candidate, byte[] target) {
		File file=null;
		FileOutputStream fileOuputStream = null;
		try {
			String filepath = candidate.getConfig().getLocation() + File.separator + candidate.getName();
			fileOuputStream = new FileOutputStream(new File(filepath));

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
