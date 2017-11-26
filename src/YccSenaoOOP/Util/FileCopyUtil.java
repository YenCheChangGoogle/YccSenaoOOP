package YccSenaoOOP.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class FileCopyUtil {
	private static Logger logger = Logger.getLogger(FileCopyUtil.class);
	
	//複製檔案方式1
	public static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	//複製檔案方式2
	public static void copyFileUsingChannel(File source, File dest) throws IOException {
		FileChannel sourceChannel = null;
		FileChannel destChannel = null;
		try {
			sourceChannel = new FileInputStream(source).getChannel();
			destChannel = new FileOutputStream(dest).getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} finally {
			sourceChannel.close();
			destChannel.close();
		}
	}

	//複製檔案方式3
	public static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
		logger.debug(source);
		logger.debug(dest);
		FileUtils.copyFile(source, dest);
	}
	
	public static void main(String args[]) throws IOException {
		File f1=new File("D:\\Git\\Repository\\Senao\\github.com\\YccSenaoOOP\\demo\\backupFrom1\\Demo.txt");
		File f2=new File("D:\\Git\\Repository\\Senao\\github.com\\YccSenaoOOP\\demo\\backupTo1\\Demo.txt");
		FileCopyUtil fcu=new FileCopyUtil();
		fcu.copyFileUsingStream(f1, f2);
		//fcu.copyFileUsingChannel(f1, f2);
		//fcu.copyFileUsingApacheCommonsIO(f1, f2);
	}
}
