package YccSenaoOOP.BridgePattern.Display;

public class PrintStringImpl extends PrintDocImpl { //列印字串實作
	private String s;
	private int length;

	public PrintStringImpl(String s) {
		this.s = s;
		this.length = s.getBytes().length;
	}

	@Override
	public void print() {
		System.out.println("|" + this.s + "|");
	}

	private void 列印分隔線() {
		System.out.print("+");
		for (int i = 0; i < this.length; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}

	@Override
	public void open() {
		列印分隔線();
	}

	@Override
	public void close() {
		列印分隔線();
	}
}