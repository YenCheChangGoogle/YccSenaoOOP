package YccSenaoOOP;

import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import YccSenaoOOP.util.JsonUtil;

public class HandlerFactory {
	private static JSONObject handlerDictionary;
	private static Logger logger = Logger.getLogger(HandlerFactory.class);
	private static String handlerMappingJsonFilePath = "D:\\Git\\Repository\\Senao\\github.com\\YccSenaoOOP\\src\\handler_mapping.json";
	private static String handlerMappingJsonFileEncoding = "UTF-8";
	private static JsonUtil jsonUtil = new JsonUtil();

	static {
		handlerDictionary = jsonUtil.getJsonObjectFromJsonFile(handlerMappingJsonFilePath, handlerMappingJsonFileEncoding);
	}

	public static Handler create(String key) {
		Handler handler = null;
		try {
			String theClass = handlerDictionary.get(key).toString();
			Class c = Class.forName(theClass);
			handler = (Handler) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return handler;
	}

	public static void main(String args[]) {

		String ext = "pdf";
		String location = "D:\\Git\\Repository\\Senao\\github.com\\YccSenaoOOP\\OOP教育訓練計畫\\3";
		boolean subDirectory = true;
		String unit = "file";
		boolean remove = false;
		String[] handlers = { "zip", "encode" };
		String destination = "directory";
		String dir = "D:\\Git\\Repository\\Senao\\github.com\\YccSenaoOOP\\備份目錄區";
		String connectionString = "";
		Config cfg = new Config(ext, location, subDirectory, unit, remove, handlers, destination, dir, connectionString);

		Date fileDateTime = new Date(); // 檔案的日期與時間
		String name = "Homework03.pdf";
		String processName = "DemoProcess"; // 處理檔案的 process
		long size = 2048; // 檔案 size

		Candidate candidate = new Candidate(cfg, fileDateTime, name, processName, size);

		byte[] target = null;
		target = HandlerFactory.create("file").perform(candidate, target);
		
		System.out.println(target.length);

	}
}
