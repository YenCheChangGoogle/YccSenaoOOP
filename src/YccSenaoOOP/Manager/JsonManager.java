package YccSenaoOOP.Manager;

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

import YccSenaoOOP.Util.JsonUtil;

import org.apache.log4j.Logger;

public abstract class JsonManager {

	private static Logger logger = Logger.getLogger(JsonManager.class);
	private String encoding = "UTF-8";
	private int bufferSize = 1024;
	JsonUtil jsonUtil = new JsonUtil();

	//取得組態檔案路徑
	public abstract String getPATH();

	//自檔案讀取內容回傳JSONObject
	public Object getJsonObject() throws FileNotFoundException, UnsupportedEncodingException, ParseException {
		return jsonUtil.getJsonObjectFromJsonFile(getPATH(), encoding);
	}

	//處置
	public abstract void processJsonConfig();

}
