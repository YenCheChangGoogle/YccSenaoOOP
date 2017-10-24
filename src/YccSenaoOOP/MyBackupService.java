package YccSenaoOOP;

import java.util.ArrayList;
import java.util.List;

public class MyBackupService {
	
	private List<JsonManager> managers=new ArrayList<JsonManager>();

	public MyBackupService() {
		managers.add(new ConfigManager());
		managers.add(new ScheduleManager());
	}
	
	public void processJsonConfig() {
		for(JsonManager manager:managers) {
			manager.processJsonConfig();
		}
	}
	
	public void doBackup() {
		//待實作
	}
	
	public static void main(String s[]) {
		MyBackupService m=new MyBackupService();
		m.processJsonConfig();
	}	
}
