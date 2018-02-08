package designpattern.adaptor.objectadaptor;

public class Main {

	public static void main(String[] args) {
		Print print = new PrintBanner("Hello");
		print.printString();
		print.printWeak();
	}
}