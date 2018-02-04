package YccSenaoOOP.BridgePattern.Display;

public class PrintDoc { //列印文件
	private PrintDocImpl p;

	public PrintDoc(PrintDocImpl p) {
		this.p = p;
	}

	public void print() {
		p.print();
	}

	public void open() {
		p.open();
	}

	public void close() {
		p.close();
	}

	public final void show() {
		open();
		print();
		close();
	}
}