package designpattern.factorymethod.demo;

public class Main {

	public static void main(String[] args) {

		String 客人要的三明治 = args[0];
		三明治工廠 工廠 = null;

		if (客人要的三明治.equals("火腿蛋三明治")) {
			工廠 = new 火腿蛋三明治工廠();
		} else if (客人要的三明治.equals("鮪魚蛋三明治")) {
			工廠 = new 鮪魚蛋三明治工廠();
		} else if (客人要的三明治.equals("培根蛋三明治")) {
			工廠 = new 培根蛋三明治工廠();
		} else {
			System.out.println("目前不提供 " + 客人要的三明治);
		}

		三明治 三明治 = 工廠.製作三明治();
	}
}
