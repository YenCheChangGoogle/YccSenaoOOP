package YccSenaoOOP.AbstractFactoryPattern;

public abstract class Hat extends Helmet{
	protected int def; // 防禦力

	// 展示這帽子的防禦力
	public void display() {
		System.out.println(this.getClass().getSimpleName() + " 額外的防禦力 = " + def);
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

}
