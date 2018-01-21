package YccSenaoOOP.AbstractFactoryPattern;

//PoDream, Warcraft
//Clothes(Protective Force): PowerHelmet, RockyHelmet, Leather, Armor
//Weapon(Arms): Armor, LongSword
//Boots(Action): FlyBoots, SpeedBoots
public class Main {

	public static void main(String args[]) {
		Set poDreamSet, warcrftSet;
		
		//寶可夢服裝零件
		AbstractFactory poDreamEquipFactory=new PoDreamEquipFactory();
		poDreamSet=new Set(
				"寶可夢服裝零件",
				poDreamEquipFactory.productHat(), 
				poDreamEquipFactory.productHelmet(),
				poDreamEquipFactory.productArmor(),
				poDreamEquipFactory.productWeapon(), 
				poDreamEquipFactory.productBoots());
		System.out.println(poDreamSet);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//魔獸爭霸服裝零件
		AbstractFactory warcrftEquipFactory=new WarcraftEquipFactory();
		warcrftSet=new Set(
				"魔獸爭霸服裝零件",
				warcrftEquipFactory.productHat(), 
				warcrftEquipFactory.productHelmet(),
				warcrftEquipFactory.productArmor(),
				warcrftEquipFactory.productWeapon(), 
				warcrftEquipFactory.productBoots());
		System.out.println(warcrftSet);
	}
}
