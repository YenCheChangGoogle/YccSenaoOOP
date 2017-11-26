package YccSenaoOOP.Handler.impl.DB.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import YccSenaoOOP.MyBackupCandidate.Candidate;

public class DBLogHandler extends AbstractDBHandler {

	//實際將log存進MyLog表格	
	@Override
	public byte[] doPerform(Candidate candidate, byte[] target) {
		PreparedStatement ps=null;
		try {
			ps = this.getConnect().prepareStatement("insert into MyLog(logContent, logDate, logUser) values (?, ?, ?)");
			ps.setString(1, "candidate.getName()="+candidate.getName()+", candidate.getProcessName()= " + candidate.getProcessName() + " candidate.getConfig().getExt()=" + candidate.getConfig().getExt()+" ("+target.length+"), candidate.getConfig().getExt()="+candidate.getConfig().getExt());
			Calendar now = Calendar.getInstance();
			ps.setTimestamp(2, new Timestamp(now.getTimeInMillis()));
			ps.setString(3, "DEMO");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) try { ps.close(); }catch(Exception ex) {}
		}
		return target;
	}

}
