package YccSenaoOOP;

import org.apache.log4j.Logger;

public abstract class AbstractHandler implements Handler {
	
	public byte[] perform(Candidate candidate, byte[] target) {
		
		System.out.println("基本共用執行的程序部位");
		
		return target;
	}

}
