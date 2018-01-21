package YccSenaoOOP.AbstractFactoryPattern;

//魔獸爭霸 力量頭盔
public class PowerHelmet extends Helmet {

	//客製化 防護力
	public void display() {
		super.display();
		System.out.println("@@@@@@  力量頭盔防護力提升 @@@@@");
	}
}
