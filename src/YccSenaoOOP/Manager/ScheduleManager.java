package YccSenaoOOP.Manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import YccSenaoOOP.Schedule;

public class ScheduleManager extends JsonManager {
	private static Logger logger = Logger.getLogger(ScheduleManager.class);
	private String PATH = "D:\\Git\\Repository\\Senao\\github.com\\YccSenaoOOP\\src\\schedule.json";

	private List<Schedule> schedules = new java.util.ArrayList<Schedule>();
	
	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public Schedule getSchedule(int index) {
		try {
			return schedules.get(index);
		} catch (Exception e) {
			return null;
		}
	}

	//主要實作Schedules的解析
	@Override
	public void processJsonConfig() {
		//logger.debug("Schedules的解析");
		try {
			Object obj = this.getJsonObject();
			if (obj instanceof JSONObject) {
				JSONObject jo = (JSONObject) obj;
				JSONArray jsons = (JSONArray) jo.get("schedules");
				for (int i = 0; i < jsons.size(); i++) {
					JSONObject json = (JSONObject) jsons.get(i);
					Schedule sche = new Schedule(json.toJSONString());
					schedules.add(sche);
					logger.debug("[" + i + "] schedule ext=" + sche.getExt() + ", time=" + sche.getTime() + ", interval=" + sche.getInterval());
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public String getPATH() {
		return this.PATH;
	}

	public static void main(String s[]) {
		ScheduleManager sh = new ScheduleManager();
		sh.processJsonConfig();
	}
}
