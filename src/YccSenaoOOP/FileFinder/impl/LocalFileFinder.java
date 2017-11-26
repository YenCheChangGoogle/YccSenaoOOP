package YccSenaoOOP.FileFinder.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;

import YccSenaoOOP.Config;
import YccSenaoOOP.Manager.ConfigManager;
import YccSenaoOOP.MyBackupCandidate.Candidate;
import YccSenaoOOP.MyBackupCandidate.CandidateFactory;

public class LocalFileFinder extends AbstractFileFinder {
	private static Logger logger = Logger.getLogger(LocalFileFinder.class);
	
	public LocalFileFinder(final Config cfg) {
		//logger.debug("LocalFileFinder()");
		this.cfg=cfg;
		
		if(cfg.isSubDirectory())
			this.filepaths=getSubDirectoryFiles(cfg);
		else {							
			java.io.File dir=new java.io.File(cfg.getLocation());
			
			logger.debug(dir);
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
		//logger.debug(this.filepaths.size());
	}
	
	@Override
	protected Candidate createCandidate(String filepath) {
		//logger.debug("createCandidate() filepath="+filepath);
		String process="DEMO"; //處理檔案的 process
		Candidate c=null;
		//cfg.getLocation(); //設定要備份檔案的目錄
		//cfg.getDir(); //處理後的目錄
		//File file=new File(cfg.getLocation()+File.separator+filename);
		File file=new File(filepath);
		if(file.exists()) {
			c=CandidateFactory.getInstance().create(cfg, file.getName(), new Date(file.lastModified()), process, file.length());
			//logger.debug(c+", "+c.getConfig());
		}		
		return c;		
	}

	//回傳目前目錄與子目錄下的所有檔案
	private List<String> getSubDirectoryFiles(Config cfg) {
		java.util.List<String> list=new java.util.ArrayList<String>();
		java.io.File dir=new java.io.File(cfg.getLocation());
		
		File files[]=dir.listFiles();
		for(File f:files) {
			logger.debug("此目錄("+dir+")下的檔案含有"+f);
			if(f.isDirectory()) {
				String fromLocation=cfg.getLocation()+File.separator+f.getName();
				String toDir=cfg.getDir()+File.separator+f.getName();
				logger.debug(fromLocation);
				logger.debug(toDir);
				Config c=new Config(cfg.getExt(), fromLocation, cfg.isSubDirectory(), cfg.getUnit(), cfg.isRemove(), cfg.getHandlers(), cfg.getDestination(), toDir, cfg.getConnectionString());
				list.addAll(getSubDirectoryFiles(c));
			}
			else {
				//logger.debug(f.getName().substring(f.getName().indexOf(".")).toUpperCase());
				//logger.debug(f.getName().toUpperCase().endsWith(cfg.getExt().toUpperCase()));
				if(f.getName().toUpperCase().endsWith(cfg.getExt().toUpperCase())) {
					list.add(f.getAbsolutePath());
				}				
			}
			//logger.debug(list.size());
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
