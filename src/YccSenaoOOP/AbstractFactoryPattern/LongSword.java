package YccSenaoOOP.AbstractFactoryPattern;

//長劍(ConcreteProduct) 武器
public class LongSword extends Weapon {

	//客製化攻擊武器
	public void display() {
		super.display();
		System.out.println("@@@@@@ 攻擊力加倍力道攻擊 @@@@@");
	}
	
}
