package YccSenaoOOP;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Schedule {

	private String ext; //設定此排程所處理的檔案格式 (cs, docx, jpg, ...)
	private String time; //設定此排程所處理的時間 (12:00)
	private String interval; //設定此排程執行的間隔 (Everyday, Sunday, Monday, ...)
	
	private Timestamp t;
	public static final Map<String, Integer> weekDays = new HashMap<String, Integer>() {
		{
			put("Everyday",  0);
			put("Sunday",    Calendar.SUNDAY);
			put("Monday",    Calendar.MONDAY);
			put("Tuesday",   Calendar.TUESDAY);
			put("Wednesday", Calendar.WEDNESDAY);
			put("Thursday",  Calendar.THURSDAY);
			put("Friday",    Calendar.FRIDAY);
			put("Saturday",  Calendar.SATURDAY);
		}
	};

	public Schedule(String ext, String time, String interval) throws java.text.ParseException {
		super();
		this.ext = ext;
		this.time = time;
		this.interval = interval;
		
		this.t = new Timestamp(dateFormat.parse(time).getTime());
	}

	public Schedule(String scheduleJsonString) throws ParseException, java.text.ParseException {
		JSONParser parser = new JSONParser();
		Object o = parser.parse(scheduleJsonString);
		JSONObject j = (JSONObject) o;
		this.ext = j.get("ext").toString();
		this.time = j.get("time").toString();
		this.interval = j.get("interval").toString();
		
		this.t = new Timestamp(dateFormat.parse(time).getTime());
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
	
	private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	private static final DateFormat dateFormatHour = new SimpleDateFormat("HH");
	private static final DateFormat dateFormatMinute = new SimpleDateFormat("mm");
	public int getHour() {
		return Integer.parseInt(dateFormatHour.format(t));
	}	
	public int getMinute() {
		return Integer.parseInt(dateFormatMinute.format(t));
	}
	
	public static boolean isInterval(String interval) {
		return weekDays.containsKey(interval);
	}
	public boolean isInterval() {
		return weekDays.containsKey(interval);
	}
	public static int getDay(String interval) {
		return weekDays.get(interval);
	}
}
