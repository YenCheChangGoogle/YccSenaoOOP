package YccSenaoOOP;

import java.util.ArrayList;
import java.util.List;

import YccSenaoOOP.myBackupCandidate.Candidate;

public abstract class AbstractTask implements Task {

	protected FileFinder<Candidate> fileFinder;

	// 一開始一定要將要備份的檔案全部找出來
	public void execute(Config cfg, Schedule sche) {
		fileFinder = FileFinderFactory.create("file", cfg);
	}

	protected List<Handler> findHandlers(Candidate candidate) {
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(HandlerFactory.create("file")); // 其中 FileHandler為每種檔案格式都需要
		Config config = candidate.getConfig();
		for (String handler : config.getHandlers()) {
			handlers.add(HandlerFactory.create(handler));
		}
		handlers.add(HandlerFactory.create(config.getDestination())); // 最後由 destination key 決定 DirectoryHandler
		return handlers;
	}

	protected void broadcastToHandlers(Candidate candidate) {
		byte[] target = null;
		List<Handler> handlers = findHandlers(candidate); // 總共有哪些 handler
		for (Handler handler : handlers) {
			target = handler.perform(candidate, target);
		}
	}

}
