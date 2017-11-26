package YccSenaoOOP.Handler.impl.DB;

import YccSenaoOOP.MyBackupCandidate.Candidate;

public interface IDBHandler {
	public void openConnection();
	public byte[] perform(Candidate candidate, byte[] target);
	public void closeConnection();
}
