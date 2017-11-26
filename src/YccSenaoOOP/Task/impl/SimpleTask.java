package YccSenaoOOP.Task.impl;

import org.apache.log4j.Logger;

import YccSenaoOOP.Config;
import YccSenaoOOP.Schedule;
import YccSenaoOOP.MyBackupCandidate.Candidate;

public class SimpleTask extends AbstractTask {

	private static Logger logger = Logger.getLogger(SimpleTask.class);
	
	@Override
	public void execute(Config cfg, Schedule sche) {
		super.execute(cfg, sche);
		
		//logger.debug("SimpleTask.execute()");
		
		for (Candidate candidate : fileFinder) {
			logger.debug("SimpleTask.execute() 處理副檔名是 "+candidate.getConfig().getExt());
			this.broadcastToHandlers(candidate);
		}
	}

}
