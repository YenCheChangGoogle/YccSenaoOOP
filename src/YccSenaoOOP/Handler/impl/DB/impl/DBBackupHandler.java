package YccSenaoOOP.Handler.impl.DB.impl;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import YccSenaoOOP.MyBackupCandidate.Candidate;

public class DBBackupHandler extends AbstractDBHandler {

	//實際將log存進MyBackup表格	
	@Override
	public byte[] doPerform(Candidate candidate, byte[] target) {
		PreparedStatement ps=null;
		try {		
			ps= this.getConnect().prepareStatement("insert into MyBackup(binaryData, backupDate, backupUser) values (?, ?, ?)");
			ByteArrayInputStream bais = new ByteArrayInputStream(target);
			ps.setBinaryStream(1, bais);
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
