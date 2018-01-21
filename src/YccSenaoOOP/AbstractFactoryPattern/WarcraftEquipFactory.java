package YccSenaoOOP.AbstractFactoryPattern;

//魔獸爭霸
public class WarcraftEquipFactory extends AbstractFactory {

	@Override
	Weapon productWeapon() {
		LongSword product = new LongSword();
        product.setAtk(1000);
        product.setRange(1);
        return product;
	}

	@Override
	Clothes productArmor() {
        Armor product = new Armor();
        product.setDef(10);
        return product;
	}

	@Override
	Boots productBoots() {
		Boots boots=new SpeedBoots();
		boots.setSpeed(5);
		return boots;
	}
	
	@Override
	Helmet productHelmet() {
		Helmet helmet=new PowerHelmet();
		helmet.setDef(500);
		return helmet;
	}

	@Override
	Hat productHat() {
		Hat hat=new SpeedHat();
		hat.setDef(10);
		return hat;
	}	
}
