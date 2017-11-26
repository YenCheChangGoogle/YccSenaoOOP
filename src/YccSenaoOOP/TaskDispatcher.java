package YccSenaoOOP;

import java.util.List;

import org.apache.log4j.Logger;

import YccSenaoOOP.Manager.ConfigManager;
import YccSenaoOOP.Manager.JsonManager;
import YccSenaoOOP.Manager.ScheduleManager;
import YccSenaoOOP.Task.ITask;

public class TaskDispatcher {
	private static Logger logger = Logger.getLogger(TaskDispatcher.class);
	
	//private Task task;
	private TaskFactory taskFactory=TaskFactory.getInstance();
	
	private List<Config> configs=new java.util.ArrayList<Config>();
	private void initConfigList(List<JsonManager> managers) {
		configs=new java.util.ArrayList<Config>();
		for(JsonManager jm:managers) {
			if(jm instanceof ConfigManager) {
				logger.debug(jm);
				ConfigManager configManager=(ConfigManager)jm;
				for(Config cfg:configManager.getConfigs()) {
					configs.add(cfg);					
				}
			}
		}		
	}
	
	//處理簡單備份
	public void simpleBackup(List<JsonManager> managers) {
		//logger.debug("處理簡單備份");
		ITask task=taskFactory.create("simple");
		
		for(JsonManager jm:managers) {
			if(jm instanceof ConfigManager) {
				ConfigManager configManager=(ConfigManager)jm;
				for(Config cfg:configManager.getConfigs()) {
					logger.debug("處理簡單備份 "+cfg.getExt());
					configs.add(cfg);
					
					task.execute(cfg, null);
				}
			}
		}
	}
	
	//處理排程備份
	public void scheduledBackup(List<JsonManager> managers) {
		logger.debug("處理排程備份");
		
		logger.debug(managers);
		logger.debug(configs.size());
		initConfigList(managers);
		
		ITask task=taskFactory.create("scheduled");		
		//logger.debug(task+", "+managers.size());
		for(JsonManager jm:managers) {
			logger.debug(jm+", "+configs.size());
			for (Config cfg : configs) {
				if (jm instanceof ScheduleManager) {
					logger.debug(jm);
					ScheduleManager scheduleManager = (ScheduleManager) jm;
					logger.debug(jm);
					for (Schedule sche : scheduleManager.getSchedules()) {
						if(cfg.getExt().equals(sche.getExt())) {
							logger.debug("execute()");
							task.execute(cfg, sche);
						}
					}

				}
			}
			
		}
	}
}
