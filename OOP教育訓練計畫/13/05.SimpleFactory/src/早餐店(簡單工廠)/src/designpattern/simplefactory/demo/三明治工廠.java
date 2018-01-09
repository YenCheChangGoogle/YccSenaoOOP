package designpattern.simplefactory.demo;

public class 三明治工廠 {
	
	public 三明治 製作三明治(String 種類) {
		三明治 產品 = null;
		
		if (種類.equals("火腿蛋三明治")) {
			產品 = new 火腿蛋三明治();
		} else if (種類.equals("鮪魚蛋三明治")) {
			產品 = new 鮪魚蛋三明治();
		};
		
		return 產品;
	}

}
