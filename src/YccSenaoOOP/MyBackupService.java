package YccSenaoOOP;

import java.util.ArrayList;
import java.util.List;

import YccSenaoOOP.myBackupCandidate.Candidate;

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
	
	
	
	//已經轉到simpleBackup()與scheduledBackup()
	/*
	//執行備份
	public void doBackup() {		
		FileFinder<Candidate> fileFinder = findFiles();
		for (Candidate candidate : fileFinder) {
			broadcastToHanders(candidate); //以 廣播 的方式，通知所有 handler 進行處理
		}
		
		//FileFinder<Candidate> fileFinder=FileFinderFactory.create("file", null);		
		//for (Candidate candidate : fileFinder) {
		//	broadcastToHanders(candidate); //以 廣播 的方式，通知所有 handler 進行處理
		//}		
	}
	*/
	
	//轉移到AbstractTask
	//根據 findHandlers() 與 candidate 得知總共有哪些 handler, 再一一執行, 並將處理完的資料 target, 交給下一個handler處理
	/*
	private void broadcastToHanders(Candidate candidate) {
		byte[] target = null;
		List<Handler> handlers = findHandlers(candidate); //總共有哪些 handler
		for (Handler handler : handlers) {
			target = handler.perform(candidate, target);
		}
	}		
	private FileFinder<Candidate> findFiles() {
		FileFinder<Candidate> fileFinder=FileFinderFactory.create("file", null);
		return fileFinder;
	}	
	private FileFinder<Candidate> findFiles(String finder, Config cfg) {
		FileFinder<Candidate> fileFinder=FileFinderFactory.create(finder, cfg);
		return fileFinder;
	}	
	*/
	
	//轉移到AbstractTask
	/*
	private List<Handler> findHandlers(Candidate candidate) {
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(HandlerFactory.create("file")); //其中 FileHandler為每種檔案格式都需要
		Config config = candidate.getConfig();
		for (String handler : config.getHandlers()) {
			handlers.add(HandlerFactory.create(handler));
		}

		handlers.add(HandlerFactory.create(config.getDestination())); //最後由 destination key 決定 DirectoryHandler
		return handlers;
	}
	*/

	/*
	public static void main(String s[]) {
		MyBackupService m = new MyBackupService();
		m.processJsonConfig();
	}
	*/
}
