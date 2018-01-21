package YccSenaoOOP.AbstractFactoryPattern;

//魔獸爭霸 速度之帽
public class SpeedHat extends Hat {

	//客製化 帽子加入的防禦力
	public void display() {
		super.display();
		System.out.println("@@@@@@ 帽子加入的防禦力 @@@@@");
	}
}
