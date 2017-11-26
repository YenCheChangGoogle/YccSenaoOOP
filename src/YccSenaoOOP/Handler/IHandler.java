package YccSenaoOOP.Handler;

import YccSenaoOOP.MyBackupCandidate.Candidate;

public interface IHandler {
	public byte[] perform(Candidate candidate, byte[] target);
}
