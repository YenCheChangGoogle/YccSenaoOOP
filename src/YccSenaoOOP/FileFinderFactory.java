package YccSenaoOOP;

import org.apache.log4j.Logger;

import YccSenaoOOP.FileFinder.IFileFinder;
import YccSenaoOOP.FileFinder.impl.LocalFileFinder;
import YccSenaoOOP.MyBackupCandidate.Candidate;

public class FileFinderFactory {
	private static Logger logger = Logger.getLogger(FileFinderFactory.class);
	private static FileFinderFactory instance;
	private FileFinderFactory() {}
	public static FileFinderFactory getInstance() {
		if(instance==null) {
			instance=new FileFinderFactory();
		}
		return instance;
	}
	
	public static IFileFinder<Candidate> create(String finder, Config cfg) {
		logger.debug("finder="+finder+", cfg="+cfg);
		if (finder.equals("file"))
			return new LocalFileFinder(cfg);
		else
			return null;
	}
}
