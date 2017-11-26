package YccSenaoOOP;

import org.apache.log4j.Logger;

import YccSenaoOOP.Task.ITask;
import YccSenaoOOP.Task.impl.ScheduledTask;
import YccSenaoOOP.Task.impl.SimpleTask;

public class TaskFactory {
	private static Logger logger = Logger.getLogger(TaskFactory.class);
	private static TaskFactory instance;
	private TaskFactory() {}
	public static TaskFactory getInstance() {
		if(instance==null) {
			instance=new TaskFactory();
		}
		return instance;
	}
	
	private ITask task=null;		
	public ITask create(String taskName) {
		logger.debug("taskName="+taskName);
		
		//若將來有更多的 Task, 可考慮使用reflection配合設定檔的方式, 將TaskFactory開放封閉 起來
		if (taskName.equals("simple")) task=new SimpleTask();
		else if (taskName.equals("scheduled")) task=new ScheduledTask();
		else task=null;		
		return task;
	}
}
