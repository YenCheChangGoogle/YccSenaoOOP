package YccSenaoOOP;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConfigManager {

	private List<Config> configs=new java.util.ArrayList<Config>();	
	private JSONParser parser = new JSONParser();
	
	public int getCount() { return configs.size(); }
	public Config getConfig(int index) {
		try {
			return configs.get(index);
		}
		catch(Exception e) {
			return null;
		}
	}	

	//���\���㪺JSONObject�]�FJSONArray�άO�����OJSONArray
	public void processConfigs(String s) {
		try {
			Object obj = parser.parse(s);
			if (obj instanceof JSONObject) {
				JSONObject jo=(JSONObject)obj;
				String schedulesJsonArrayString=jo.get("configs").toString();
				processConfigsFromJSONArray(schedulesJsonArrayString);
			}
			else if (obj instanceof JSONArray) {
				processConfigsFromJSONArray(s);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void processConfigsFromJSONArray(String configJsonArrayString) {
		try {
			JSONArray ja=(JSONArray)parser.parse(configJsonArrayString);
			for(int i=0; i<ja.size(); i++) {
				JSONObject jo=(JSONObject)ja.get(i);
				Config cfg=new Config(jo.toJSONString());
				configs.add(cfg);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
