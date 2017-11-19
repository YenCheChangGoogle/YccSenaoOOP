package YccSenaoOOP;

public class TaskFactory {
	
	private static TaskFactory instance;
	private TaskFactory() {}
	public static TaskFactory getInstance() {
		if(instance==null) {
			instance=new TaskFactory();
		}
		return instance;
	}
	
	private Task task=null;		
	public Task create(String taskName) {
		//若將來有更多的 Task, 可考慮使用reflection配合設定檔的方式, 將TaskFactory開放封閉 起來
		if (taskName.equals("simple")) task=new SimpleTask();
		else if (taskName.equals("scheduled")) task=new ScheduledTask();
		else task=null;		
		return task;
	}
}
