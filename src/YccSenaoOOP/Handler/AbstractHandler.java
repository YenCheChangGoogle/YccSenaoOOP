package YccSenaoOOP.Handler;

import org.apache.log4j.Logger;

import YccSenaoOOP.MyBackupCandidate.Candidate;

public abstract class AbstractHandler implements IHandler {
	private static Logger logger = Logger.getLogger(AbstractHandler.class);
	
	public byte[] perform(Candidate candidate, byte[] target) {
		
		logger.debug("基本共用執行的程序部位");
		
		return target;
	}

}
