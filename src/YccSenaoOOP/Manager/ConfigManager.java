package YccSenaoOOP.Manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import YccSenaoOOP.Config;

public class ConfigManager extends JsonManager {
	private static Logger logger = Logger.getLogger(ConfigManager.class);
	private String PATH = "D:\\Git\\Repository\\Senao\\github.com\\YccSenaoOOP\\src\\config.json";

	private List<Config> configs = new java.util.ArrayList<Config>();

	public List<Config> getConfigs() {
		return configs;
	}

	public Config getConfig(int index) {
		try {
			return configs.get(index);
		} catch (Exception e) {
			return null;
		}
	}

	//主要實作Config的解析
	@Override
	public void processJsonConfig() {
		//logger.debug("Config的解析");
		try {
			Object obj = this.getJsonObject();
			if (obj instanceof JSONObject) {
				JSONObject jo = (JSONObject) obj;
				JSONArray jsons = (JSONArray) jo.get("configs");
				for (int i = 0; i < jsons.size(); i++) {
					JSONObject json = (JSONObject) jsons.get(i);
					
					//Config cfg = new Config(json.toJSONString());
					Config cfg = new Config(
							json.get("ext").toString(), 
							json.get("location").toString(), 
							(json.get("subDirectory").toString().equalsIgnoreCase("true") ? true : false), 
							json.get("unit").toString(), 
							(json.get("remove").toString().equalsIgnoreCase("true") ? true : false),  
							(json.get("handlers").toString().replace("[", "").replaceAll("]", "").replaceAll("\"", "").split(",")),
							json.get("destination").toString(),
							json.get("dir").toString(), 
							json.get("connectionString").toString());
					
					
					configs.add(cfg);
					logger.debug("[" + i + "] config ext=" + cfg.getExt() + ", location=" + cfg.getLocation() + ", subDirectory=" + cfg.isSubDirectory() + ", unit=" + cfg.getUnit() + ", remove="							+ cfg.isRemove() + ", handler=" + cfg.getHandlers() + ", destination=" + cfg.getDestination() + ", dir=" + cfg.getDir() + ", connectionString=" + cfg.getConnectionString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	@Override
	public String getPATH() {
		return this.PATH;
	}

}
