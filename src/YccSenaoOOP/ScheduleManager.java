package YccSenaoOOP;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ScheduleManager {

	private List<Schedule> schedules = new java.util.ArrayList<Schedule>();
	private JSONParser parser = new JSONParser();

	public int getCount() {
		return schedules.size();
	}

	public Schedule getSchedule(int index) {
		try {
			return schedules.get(index);
		} catch (Exception e) {
			return null;
		}
	}

	//允許完整的JSONObject包了JSONArray或是直接是JSONArray
	public void processSchedules(String s) {
		try {
			Object obj = parser.parse(s);
			if (obj instanceof JSONObject) {
				JSONObject jo=(JSONObject)obj;
				String schedulesJsonArrayString=jo.get("schedules").toString();
				processSchedulesFromJSONArray(schedulesJsonArrayString);
			}
			else if (obj instanceof JSONArray) {
				processSchedulesFromJSONArray(s);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void processSchedulesFromJSONArray(String schedulesJsonArrayString) throws ParseException {
		Object obj = parser.parse(schedulesJsonArrayString);
		JSONArray ja = (JSONArray) obj;
		for (int i = 0; i < ja.size(); i++) {
			JSONObject jo = (JSONObject) ja.get(i);
			Schedule sche = new Schedule(jo.toJSONString());
			schedules.add(sche);
		}		
	}
}
