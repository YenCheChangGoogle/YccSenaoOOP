package YccSenaoOOP.Singleton;

public class SingletonDemo {

	private static final SingletonDemo instance=new SingletonDemo();
	
	private SingletonDemo() {}
	
	public static SingletonDemo getInstance() {
		return instance;
	}
}
