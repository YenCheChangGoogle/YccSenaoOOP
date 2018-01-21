package YccSenaoOOP.AbstractFactoryPattern;

//魔獸爭霸 盔甲(ConcreteProduct)
public class Armor extends Clothes {

	//客製化 防護力
	public void display() {
		super.display();
		System.out.println("@@@@@@ 穿上魔獸爭霸 盔甲防護力提升 @@@@@");
	}
}
