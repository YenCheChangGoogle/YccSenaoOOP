package YccSenaoOOP;

import java.util.ArrayList;
import java.util.List;

import YccSenaoOOP.Manager.ConfigManager;
import YccSenaoOOP.Manager.JsonManager;
import YccSenaoOOP.Manager.ScheduleManager;
import YccSenaoOOP.MyBackupCandidate.Candidate;

public class MyBackupService {

	private List<JsonManager> managers = new ArrayList<JsonManager>();
	private TaskDispatcher taskDispatcher;

	public MyBackupService() {
		managers.add(new ConfigManager());
		managers.add(new ScheduleManager());
		
		taskDispatcher = new TaskDispatcher();
		init();
	}

	private void init() {
		processJsonConfig();
	}
	
	private void processJsonConfig() {
		for (JsonManager manager : managers) {
			manager.processJsonConfig();
		}
	}
	
	//處理簡單備份
	public void simpleBackup() {
		this.taskDispatcher.simpleBackup(managers);
	}
	//處理排程備份
	public void scheduledBackup() {
		this.taskDispatcher.scheduledBackup(managers);
	}
	
	public static void main(String s[]) {
		MyBackupService m = new MyBackupService();
		m.simpleBackup();
		//m.scheduledBackup();
	}
	
}
