package YccSenaoOOP;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Schedule {

	private String ext; //�]�w���Ƶ{�ҳB�z���ɮ׮榡 (cs, docx, jpg, ...)
	private String time; //�]�w���Ƶ{�ҳB�z���ɶ� (12:00)
	private String interval; //�]�w���Ƶ{���檺���j (Everyday, Sunday, Monday, ...)
	
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
