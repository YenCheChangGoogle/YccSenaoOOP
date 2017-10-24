package YccSenaoOOP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.log4j.Logger;

public abstract class JsonManager {

	private static Logger logger = Logger.getLogger(JsonManager.class);
	private String encoding="UTF-8";
	private int bufferSize=1024;
	
	//取得組態檔案路徑
	public abstract String getPATH();		
	
	//自檔案讀取內容回傳JSONObject
	public Object getJsonObject() throws FileNotFoundException, UnsupportedEncodingException, ParseException {		
		File file=new File(getPATH());
		FileInputStream fis=new FileInputStream(file);
		InputStreamReader isr=new InputStreamReader(fis, encoding);
		BufferedReader br=new BufferedReader(isr, bufferSize);
		
		StringBuffer sb=new StringBuffer();
		try {
			while (true) {
				String line = null;
				try {
					line = br.readLine();
					if (line == null) break;
					sb.append(line);
				} catch (IOException ioex) { break; }
			}
		}catch(Exception e) { logger.error(e.getMessage()); }
		finally {
			if(br!=null) try { br.close(); }catch(Exception ex) {}
			if(isr!=null) try { isr.close(); }catch(Exception ex) {}
			if(fis!=null) try { fis.close(); }catch(Exception ex) {}
		}
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(sb.toString());
		return obj;
	}
	
	//處置
	public abstract void processJsonConfig();
	
}
