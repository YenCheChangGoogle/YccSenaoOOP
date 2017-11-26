package YccSenaoOOP.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtil {
	private Logger logger = Logger.getLogger(JsonUtil.class);

	//自檔案讀取內容回傳JSONObject
	public JSONObject getJsonObjectFromJsonFile(String jsonFilePath, String encoding) {
		try {
			int bufferSize = 4096000;
			File file = new File(jsonFilePath);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, encoding);
			BufferedReader br = new BufferedReader(isr, bufferSize);
			StringBuffer sb = new StringBuffer();
			try {
				while (true) {
					String line = null;
					try {
						line = br.readLine();
						if (line == null) break;
						sb.append(line);
					} catch (IOException ioex) {
						break;
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			} finally {
				if (br != null) try { br.close(); } catch (Exception ex) { }
				if (isr != null) try { isr.close(); } catch (Exception ex) { }
				if (fis != null) try { fis.close(); } catch (Exception ex) { }
			}
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(sb.toString());
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
