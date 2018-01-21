package YccSenaoOOP.AbstractFactoryPattern;

//PoDream寶可夢
public class PoDreamEquipFactory extends AbstractFactory {
	
	@Override
	public Weapon productWeapon() {
		Bow product = new Bow();
		product.setAtk(10);
		product.setRange(10);
		return product;
	}

	@Override
	public Clothes productArmor() {
		Leather product = new Leather();
		product.setDef(5);
		return product;
	}

	@Override
	Boots productBoots() {
		Boots boots=new FlyBoots();
		boots.setSpeed(100);
		return boots;
	}

	@Override
	Helmet productHelmet() {
		Helmet helmet=new RockyHelmet();
		helmet.setDef(40);
		return helmet;
	}

	@Override
	Hat productHat() {
		Hat hat=new CuteHat();
		hat.setDef(0);
		return hat;
	}
	
}
