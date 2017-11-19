package YccSenaoOOP;

import java.util.List;

public class TaskDispatcher {

	//private Task task;
	private TaskFactory taskFactory=TaskFactory.getInstance();
	
	//處理簡單備份
	public void simpleBackup(List<JsonManager> managers) {
		Task task=taskFactory.create("simple");
		
		for(JsonManager jm:managers) {
			if(jm instanceof ConfigManager) {
				ConfigManager configManager=(ConfigManager)jm;
				for(Config cfg:configManager.getConfigs()) {
					task.execute(cfg, null);
				}
			}
		}
	}
	
	//處理排程備份
	public void scheduledBackup(List<JsonManager> managers) {
		Task task=taskFactory.create("scheduled");
		
		for(JsonManager jm:managers) {			
			if(jm instanceof ScheduleManager) {
				ScheduleManager scheduleManager=(ScheduleManager)jm;
				for(Schedule sche:scheduleManager.getSchedules()) {
					task.execute(null, sche);
				}
			}
		}
	}
}
