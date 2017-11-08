package YccSenaoOOP;

import java.util.Iterator;

//public interface FileFinder<Candidate> extends java.util.Enumeration<Candidate>, java.util.List<Candidate> {
public interface FileFinder<Candidate> extends Iterable<Candidate>, Iterator<Candidate> {
}
