package YccSenaoOOP.Handler.impl;

import org.apache.log4j.Logger;

import YccSenaoOOP.Handler.AbstractHandler;
import YccSenaoOOP.Handler.impl.DB.IDBHandler;
import YccSenaoOOP.Handler.impl.DB.impl.DBBackupHandler;
import YccSenaoOOP.Handler.impl.DB.impl.DBLogHandler;
import YccSenaoOOP.MyBackupCandidate.Candidate;

public class DBAdapter extends AbstractHandler {

	private static Logger logger = Logger.getLogger(DBAdapter.class);
	
	IDBHandler backupHandler = new DBBackupHandler();
	IDBHandler logHandler = new DBLogHandler();

	Candidate candidate;
	byte[] target;
	
	public DBAdapter() {
		this.init();
	}
	private void init() {
		logger.debug("");
	}

	public byte[] perform(Candidate candidate, byte[] target) {

		super.perform(candidate, target);
		byte[] result = target;
		if (target != null) {
			if (candidate.getConfig().getDestination().equals("db")) {
				super.perform(candidate, target);

				this.candidate = candidate;
				this.target = target;

				this.saveBackupToDB();
				this.saveLogToDB();
			}
		}
		return target;
	}

	private void saveBackupToDB() {
		logger.debug("saveBackupToDB()");
		this.backupHandler.openConnection();
		this.backupHandler.perform(candidate, target);
		this.backupHandler.closeConnection();
	}

	private void saveLogToDB() {
		logger.debug("saveLogToDB()");
		this.logHandler.openConnection();
		this.logHandler.perform(candidate, target);
		this.logHandler.closeConnection();
	}
}
