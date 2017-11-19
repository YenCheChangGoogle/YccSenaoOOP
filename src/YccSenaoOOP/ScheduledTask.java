package YccSenaoOOP;

import YccSenaoOOP.myBackupCandidate.Candidate;

public class ScheduledTask extends AbstractTask {

	@Override
	public void execute(Config cfg, Schedule sche) {
		super.execute(cfg, sche);

		for (Candidate candidate : fileFinder) {
			this.broadcastToHandlers(candidate);
		}
	}

}
