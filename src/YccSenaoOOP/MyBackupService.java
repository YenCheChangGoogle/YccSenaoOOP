package YccSenaoOOP;

import java.util.ArrayList;
import java.util.List;

public class MyBackupService {

	private List<JsonManager> managers = new ArrayList<JsonManager>();

	public MyBackupService() {
		managers.add(new ConfigManager());
		managers.add(new ScheduleManager());
	}

	public void processJsonConfig() {
		for (JsonManager manager : managers) {
			manager.processJsonConfig();
		}
	}

	public void doBackup() {
		List<Candidate> candidates = findFiles();
		for (Candidate candidate : candidates) {
			broadcastToHanders(candidate); // 以 廣播 的方式，通知所有 handler 進行處理
		}
	}

	// 根據 findHandlers() 與 candidate 得知總共有哪些 handler, 再一一執行, 並將處理完的資料 target, 交給下一個
	// handler處理
	private void broadcastToHanders(Candidate candidate) {
		byte[] target = null;
		List<Handler> handlers = findHandlers(candidate); // 總共有哪些 handler
		for (Handler handler : handlers) {
			target = handler.perform(candidate, target);
		}
	}

	// 得知總共有哪些 candidate, 再將每個candidate 以 廣播 的方式, 通知所有 handler 進行處理
	private List<Candidate> findFiles() {
		// 待實作
		return null;
	}

	private List<Handler> findHandlers(Candidate candidate) {
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(HandlerFactory.create("file")); // 其中 FileHandler為每種檔案格式都需要

		Config config = candidate.getConfig();
		for (String handler : config.getHandlers()) {
			handlers.add(HandlerFactory.create(handler));
		}

		handlers.add(HandlerFactory.create(config.getDestination())); // 最後由 destination key 決定 DirectoryHandler

		return handlers;
	}

	public static void main(String s[]) {
		MyBackupService m = new MyBackupService();
		m.processJsonConfig();
	}
}
