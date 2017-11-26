package YccSenaoOOP.Task.impl;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import YccSenaoOOP.Config;
import YccSenaoOOP.FileFinderFactory;
import YccSenaoOOP.Schedule;
import YccSenaoOOP.MyBackupCandidate.Candidate;

public class ScheduledTask extends AbstractTask {

	private static Logger logger = Logger.getLogger(ScheduledTask.class);
	
	@Override
	public void execute(Config cfg, Schedule sche) {
		super.execute(cfg, sche);
		logger.debug("ScheduledTask.execute()");
		
		
		Calendar now = Calendar.getInstance();

		Calendar startTime = Calendar.getInstance();
		startTime.set(Calendar.HOUR_OF_DAY, sche.getHour());
		startTime.set(Calendar.MINUTE, sche.getMinute());

		String interval = sche.getInterval();
		long period = 0;
		int theDay=sche.getDay(interval);
		//如果執行時間小於現在時刻會即立刻執行, 所以要設到下一次再開始
		if(theDay==0) { //Everyday
			if (now.after(startTime)) startTime.add(Calendar.DATE, 1);
			period = 24 * 60 * 60 * 1000L;
		} else { //Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
			if (now.after(startTime)) {
				startTime.add(Calendar.DATE, 7);
			}
			else {
				startTime.set(Calendar.DAY_OF_WEEK, theDay);
			}			
			period = 7 * 24 * 60 * 60 * 1000L;
		}
		
		for (final Candidate candidate : fileFinder) {
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					broadcastToHandlers(candidate);
				}
			}, startTime.getTime(), period);
		}
	}

}
