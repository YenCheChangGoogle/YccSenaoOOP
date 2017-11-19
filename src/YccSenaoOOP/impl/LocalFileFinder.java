package YccSenaoOOP.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import com.sun.istack.internal.logging.Logger;
import YccSenaoOOP.AbstractFileFinder;
import YccSenaoOOP.Config;
import YccSenaoOOP.myBackupCandidate.Candidate;
import YccSenaoOOP.myBackupCandidate.CandidateFactory;

public class LocalFileFinder extends AbstractFileFinder {

	public LocalFileFinder() {
		
	}
	
	public LocalFileFinder(final Config cfg) {
		if(cfg.isSubDirectory())
			this.filepaths=getSubDirectoryFiles(cfg);
		else {							
			java.io.File dir=new java.io.File(cfg.getLocation());
			
			//過濾後只留下組態內設定的檔案類型
			File fs[]=dir.listFiles(new FilenameFilter() {

				public boolean accept(File dir, String name) {
					return name.toUpperCase().endsWith(cfg.getExt().toUpperCase());
				}				
			});
			
			for(File f:fs) {
				this.filepaths.add(f.getAbsolutePath());
			}
		}		
	}
	
	@Override
	protected Candidate createCandidate(String filename) {
		String process="DEMO"; //處理檔案的 process
		Candidate c=null;
		File file=new File(cfg.getDir()+File.separator+filename);
		if(file.exists()) {
			CandidateFactory.getInstance().create(cfg, filename, new Date(file.lastModified()), process, file.length());
		}
		
		return c;		
	}

	//回傳目前目錄與子目錄下的所有檔案
	private List<String> getSubDirectoryFiles(Config cfg) {
		java.util.List<String> list=new java.util.ArrayList<String>();
		java.io.File dir=new java.io.File(cfg.getLocation());
		
		File files[]=dir.listFiles();
		for(File f:files) {
			if(f.isDirectory()) {
				String fromLocation=cfg.getLocation()+File.separator+f.getName();
				String toDir=cfg.getDir()+File.separator+f.getName();
				Config c=new Config(cfg.getExt(), fromLocation, cfg.isSubDirectory(), cfg.getUnit(), cfg.isRemove(), cfg.getHandlers(), cfg.getDestination(), toDir, cfg.getConnectionString());
				list.addAll(getSubDirectoryFiles(c));
			}
			else {
				if(f.getName().toUpperCase().endsWith(cfg.getExt().toUpperCase())) {
					list.add(f.getAbsolutePath());
				}
			}
		}
		return list;
	}
	
	//回傳目前目錄與子目錄下的所有檔案
	private List<File> getSubDirectoryFiles2(Config cfg) {
		java.util.ArrayList<File> returnList=new java.util.ArrayList<File>();
		java.io.File dir=new java.io.File(cfg.getLocation());		
		File files[]=dir.listFiles();
		for(File file:files) {
			
			if(file.isDirectory()) {
				String fromLocation=cfg.getLocation()+File.separator+file.getName();
				String toDir=cfg.getDir()+File.separator+file.getName();
				Config c=new Config(cfg.getExt(), fromLocation, cfg.isSubDirectory(), cfg.getUnit(), cfg.isRemove(), cfg.getHandlers(), cfg.getDestination(), toDir, cfg.getConnectionString());
				returnList.addAll(getSubDirectoryFiles2(c));
			}
			else {
				if(file.getName().toUpperCase().endsWith(cfg.getExt().toUpperCase())) {
					returnList.add(new File(file.getAbsolutePath()));
				}
			}
		}
		return returnList;
	}	

}
