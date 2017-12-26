package YccSenaoOOP.Singleton;

public class Demo {

	public static void main(String[] args) {
		SingletonDemo s=SingletonDemo.getInstance();
		SingletonDemo s2=SingletonDemo.getInstance();
		
		System.out.println(s);
		System.out.println(s2);

	}

}
