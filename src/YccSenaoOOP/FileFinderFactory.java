package YccSenaoOOP;

import YccSenaoOOP.impl.LocalFileFinder;

public class FileFinderFactory {
	
	public static FileFinder<Candidate> create(String finder, Config config) {
		if (finder == "file")
			return new LocalFileFinder(config);
		else
			return null;
	}
}
