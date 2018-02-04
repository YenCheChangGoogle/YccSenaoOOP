package YccSenaoOOP.BridgePattern.Display;

public class RePrint extends PrintDoc { //列印指定次數
	public RePrint(PrintDocImpl p) {
		super(p);
	}

	public void printAgain(int times) {
		open();
		for (int i = 0; i < times; i++) {
			print();
		}
		close();
	}
}
