package YccSenaoOOP.BridgePattern.Display;

public class Main {

	public static void main(String[] args) {
		PrintDoc p1 = new PrintDoc(new PrintStringImpl(" Hello World!"));
		p1.show();

		PrintDoc p2 = new RePrint(new PrintStringImpl(" Hello Taiwan!"));
		p2.show();

		RePrint p3 = new RePrint(new PrintStringImpl(" Hello Taiwan!"));
		p3.printAgain(10);
	}

}