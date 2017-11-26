package YccSenaoOOP.FileFinder.impl;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;

import YccSenaoOOP.Config;
import YccSenaoOOP.FileFinder.IFileFinder;
import YccSenaoOOP.MyBackupCandidate.Candidate;
import YccSenaoOOP.Task.impl.SimpleTask;

public abstract class AbstractFileFinder implements IFileFinder {
	
	private static Logger logger = Logger.getLogger(AbstractFileFinder.class);
	protected Config cfg;
	protected List<String> filepaths = new java.util.ArrayList<String>();
	protected int index = -1;

	public AbstractFileFinder() {

	}

	public AbstractFileFinder(Config cfg) {
		if (cfg != null)
			this.cfg = cfg;
	}

	protected abstract Candidate createCandidate(String filename);

	public Iterator iterator() {
		return this;
	}

	public boolean hasNext() {
		return (1 + this.index) < this.filepaths.size();
	}
	
	public Object next() {
		this.index++;
		if (this.index < filepaths.size()) { //仍然有值的時候
			Candidate c=createCandidate(filepaths.get(index));
			logger.debug("處理的檔案名稱="+c.getName());
			return c;
		} else {
			return null;
		}
	}
	
	public void remove() {
		index = -1;
		filepaths.clear();
	}

	
	
	
	/*
	@Override
	public Iterator<Candidate> iterator() {
		return this.iterator();
	}
	
	@Override
	public boolean hasMoreElements() {		
		return (1+this.index)<this.filepaths.size();
	}

	@Override
	public Object nextElement() {		
		this.index++;
		if(this.index<filepaths.size()) { //仍然有值的時候
			return createCandidate(filepaths.get(index));	
		}
		else {
			return null;
		}	
	}
	
	@Override
	public Object[] toArray() {
		return this.toArray();
		return filepaths.toArray();
	}

	@Override
	public Object[] toArray(Object[] a) {		
		return filepaths.toArray(a);
	}	
	
	@Override
	public int size() {
		return filepaths.size();
	}

	@Override
	public boolean isEmpty() {
		return filepaths.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return filepaths.contains(o);
	}

	@Override
	public boolean add(Object o) {		
		return filepaths.add((String)o);
	}

	@Override
	public boolean remove(Object o) {
		this.index--;
		return filepaths.remove(o);
	}

	@Override
	public boolean containsAll(Collection c) {		
		return filepaths.containsAll(c);
	}

	@Override
	public boolean addAll(Collection c) {		
		return filepaths.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection c) {		
		return filepaths.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection c) {
		if(filepaths.removeAll(c)) {
			this.index=filepaths.size()-1;
			return true;
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		if(filepaths.retainAll(c)) {
			this.index=filepaths.size()-1;
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		this.index=-1;
		filepaths.clear();		
	}

	@Override
	public Object get(int index) {		
		return filepaths.get(index);
	}

	@Override
	public Object set(int index, Object element) {
		return filepaths.set(index, (String)element);
	}

	@Override
	public void add(int index, Object element) {
		filepaths.add(index, (String)element);		
	}

	@Override
	public Object remove(int index) {	
		this.index--;
		return filepaths.remove(index);
	}

	@Override
	public int indexOf(Object o) {		
		return filepaths.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return filepaths.lastIndexOf(o);
	}

	@Override
	public ListIterator listIterator() {
		return filepaths.listIterator();
	}

	@Override
	public ListIterator listIterator(int index) {
		return filepaths.listIterator(index);
	}

	@Override
	public List subList(int fromIndex, int toIndex) {		
		return filepaths.subList(fromIndex, toIndex);
	}
	*/	
}
