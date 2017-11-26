package YccSenaoOOP.FileFinder;

import java.util.Iterator;

//public interface FileFinder<Candidate> extends java.util.Enumeration<Candidate>, java.util.List<Candidate> {
public interface IFileFinder<Candidate> extends Iterable<Candidate>, Iterator<Candidate> {
}
