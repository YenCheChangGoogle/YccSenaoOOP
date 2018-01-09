package designpattern.factorymethod.demo;

public class 培根蛋三明治  implements 三明治{
	
	public void 烤麵包() {
		System.out.println("麵包送進烤箱了");
	}
	
	public void 抹醬料() {		
		System.out.println("抹上美乃滋");
	}
	
	public void 煎蛋() {		
		System.out.println("煎荷包蛋");
	}
	
	public void 加料() {		
		System.out.println("加培根，蛋");
	}
	
	public void 包裝() {
		System.out.println("用紙袋包裝");
	}

}