package YccSenaoOOP.AbstractFactoryPattern;

public abstract class AbstractFactory {
	
	//製造武器(攻擊力)
	abstract Weapon productWeapon();
	
	//製造衣服(防護力)
	abstract Clothes productArmor();
	
	//製造頭盔加入的防禦力(防護力)
	abstract Helmet productHelmet();
	
	//製造帽子加入的防禦力(防護力)
	abstract Hat productHat();	
	
	//製造靴子(行動力)
	abstract Boots productBoots();
	
}
