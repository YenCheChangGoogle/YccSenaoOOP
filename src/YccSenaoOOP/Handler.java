package YccSenaoOOP;

import YccSenaoOOP.myBackupCandidate.Candidate;

public interface Handler {
	public byte[] perform(Candidate candidate, byte[] target);
}
