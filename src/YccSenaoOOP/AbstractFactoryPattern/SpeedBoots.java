package YccSenaoOOP.AbstractFactoryPattern;

//魔獸爭霸 速度之靴
public class SpeedBoots extends Boots {

	//客製化 行動力
	public void display() {
		super.display();
		System.out.println("@@@@@@ 行動力加速 衝衝衝 @@@@@");
	}
}
