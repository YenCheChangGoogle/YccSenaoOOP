package YccSenaoOOP;

import java.util.Date;

// 描述待處理檔案的資訊
public class Candidate implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Config config;
	private Date fileDateTime; // 檔案的日期與時間
	private String name; //檔案名稱
	private String processName; // 處理檔案的 process
	private long size; // 檔案 size

	public Candidate(Config config) {
		this.config = config;
	}

	public Candidate(Config config, Date fileDateTime, String name, String processName, long size) {
		this.config = config;
		this.fileDateTime = fileDateTime;
		this.name = name;
		this.processName = processName;
		this.size = size;
	}

	public Config getConfig() {
		return config;
	}

	public Date getFileDateTime() {
		return fileDateTime;
	}

	public void setFileDateTime(Date fileDateTime) {
		this.fileDateTime = fileDateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
