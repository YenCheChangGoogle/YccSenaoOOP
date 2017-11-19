package YccSenaoOOP.myBackupCandidate;

import java.util.Date;

import YccSenaoOOP.Config;

public class CandidateFactory {
	
	private static CandidateFactory instance;
	private CandidateFactory() {}
	public static CandidateFactory getInstance() {
		if(instance==null) {
			instance=new CandidateFactory();
		}
		return instance;
	}
	
	//提供一個一致的建立與初始化 Candidate 的方式, 因此使用Simple Factory Pattern, 將原本到處 new 改成統一個CandidateFactory.create()
	//public static Candidate create(Config config, String name, Date fileDateTime, String processName, long size) {
	//	return new Candidate(config, fileDateTime, name, processName, size);
	//}
	
	//改成透過  singleton pattern 方式取得
	private Candidate c;
	public Candidate create(Config config, String name, Date fileDateTime, String processName, long size) {
		c=new Candidate(config, fileDateTime, name, processName, size);
		return c;
	}	
}
