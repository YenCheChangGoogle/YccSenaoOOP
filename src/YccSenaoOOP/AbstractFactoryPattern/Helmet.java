package YccSenaoOOP.AbstractFactoryPattern;

public abstract class Helmet {
	protected int def; // 防禦力

	// 展示這件衣服
	public void display() {
		System.out.println(this.getClass().getSimpleName() + " 防禦力 = " + def);
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
}
