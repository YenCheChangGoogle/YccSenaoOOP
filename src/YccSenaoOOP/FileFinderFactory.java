package YccSenaoOOP;

import YccSenaoOOP.impl.LocalFileFinder;
import YccSenaoOOP.myBackupCandidate.Candidate;

public class FileFinderFactory {
	
	public static FileFinder<Candidate> create(String finder, Config cfg) {
		if (finder.equals("file"))
			return new LocalFileFinder(cfg);
		else
			return null;
	}
}
