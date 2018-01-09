package designpattern.factorymethod.demo;

public class 鮪魚蛋三明治工廠  implements 三明治工廠{

	@Override
	public 三明治 製作三明治() {		
		return new 鮪魚蛋三明治();
	}

}