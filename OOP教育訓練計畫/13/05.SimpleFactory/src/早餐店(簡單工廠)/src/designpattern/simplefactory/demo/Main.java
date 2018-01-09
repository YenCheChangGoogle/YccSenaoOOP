package designpattern.simplefactory.demo;
public class Main {

	public static void main(String[] args) {
		
		三明治工廠 工廠 = new 三明治工廠();
		String 客人要的三明治 = args[0];		
		三明治 三明治 = 工廠.製作三明治(客人要的三明治);
		三明治.烤麵包();
		三明治.煎蛋();
		三明治.抹醬料();
		三明治.加料();
		三明治.包裝();
	}
}
