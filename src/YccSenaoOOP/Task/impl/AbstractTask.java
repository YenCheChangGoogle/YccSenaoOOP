package YccSenaoOOP.Task.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import YccSenaoOOP.Config;
import YccSenaoOOP.FileFinderFactory;
import YccSenaoOOP.HandlerFactory;
import YccSenaoOOP.Schedule;
import YccSenaoOOP.TaskDispatcher;
import YccSenaoOOP.FileFinder.IFileFinder;
import YccSenaoOOP.Handler.IHandler;
import YccSenaoOOP.MyBackupCandidate.Candidate;
import YccSenaoOOP.Task.ITask;

public abstract class AbstractTask implements ITask {
	private static Logger logger = Logger.getLogger(AbstractTask.class);
	protected IFileFinder<Candidate> fileFinder;

	// 一開始一定要將要備份的檔案全部找出來
	public void execute(Config cfg, Schedule sche) {
		fileFinder = FileFinderFactory.getInstance().create("file", cfg);
		//fileFinder = FileFinderFactory.getInstance().create("file", cfg);
	}

	protected List<IHandler> findHandlers(Candidate candidate) {
		List<IHandler> handlers = new ArrayList<IHandler>();
		handlers.add(HandlerFactory.create("file")); // 其中 FileHandler為每種檔案格式都需要
		
		Config config = candidate.getConfig();
		
		for (String handler : config.getHandlers()) {
			logger.debug("處置的動作是 "+handler);
			handlers.add(HandlerFactory.create(handler));
		}
		handlers.add(HandlerFactory.create(config.getDestination())); // 最後由 destination key 決定 DirectoryHandler
		return handlers;
	}

	protected final void broadcastToHandlers(Candidate candidate) {
		byte[] target = null;
		List<IHandler> handlers = findHandlers(candidate); // 總共有哪些 handler
		for (IHandler handler : handlers) {
			logger.debug(handler+", "+candidate.getName()+", "+candidate.getConfig().getConnectionString());
			target = handler.perform(candidate, target);
			logger.debug(target.length);
		}
	}

}
