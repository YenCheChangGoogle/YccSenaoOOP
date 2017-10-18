package YccSenaoOOP;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Schedule {

	private String ext; //設定此排程所處理的檔案格式 (cs, docx, jpg, ...)
	private String time; //設定此排程所處理的時間 (12:00)
	private String interval; //設定此排程執行的間隔 (Everyday, Sunday, Monday, ...)
	
	public Schedule(String ext, String time, String interval) {
		super();
		this.ext = ext;
		this.time = time;
		this.interval = interval;
	}
	
	public Schedule(String scheduleJsonString) throws ParseException {
		JSONParser parser = new JSONParser();
		Object o=parser.parse(scheduleJsonString);
		JSONObject j=(JSONObject)o;
		this.ext=j.get("ext").toString();
		this.time=j.get("time").toString();
		this.interval=j.get("interval").toString();	
	}
	
	public String getExt() {
		return ext;
	}
	public String getTime() {
		return time;
	}
	public String getInterval() {
		return interval;
	}
}
