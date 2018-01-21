package YccSenaoOOP.AbstractFactoryPattern;

public class Set {

	public String name;
	public Hat hat;
	public Helmet helmet;
	public Clothes clothes;
	public Weapon weapon;
	public Boots boots;
	
	public Set(String name, Hat hat, Helmet helmet, Clothes clothes, Weapon weapon, Boots boots) {
		this.name=name;
		System.out.println("--------------------------------------------------");
		System.out.println("【"+name+"】");
		
		this.hat=hat;
		this.helmet=helmet;
		this.clothes=clothes;
		this.weapon=weapon;
		this.boots=boots;
		hat.display();
		helmet.display();
		clothes.display();
		weapon.display();
		boots.display();
		
		this.speed=boots.getSpeed();
		this.atk=weapon.getAtk();
		this.range=weapon.getRange();
		this.def=hat.getDef()+helmet.getDef()+clothes.getDef();
		System.out.println("--------------------------------------------------");
	}
	
	public int def; //防禦力
	public int speed; //行動力
	public int 	atk; // 攻擊力
	public int range; // 攻擊範圍
	
	public String toString() {
		return this.name+"[ 防禦力:"+def+", 攻擊力:"+atk+", 攻擊範圍:"+range+", 行動力"+speed+" ]";
	}
}
