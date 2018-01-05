package designpattern.builder.documentbuilder;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			printUsage();
			System.exit(0);
		}
		
		if (args[0].equals("plain")) {
			buildPlain();
		} else if (args[0].equals("html")) {
			buildHTML();
		} else {
			printUsage();
			System.exit(0);
		}
	}
	
	private static void buildHTML() {
		Director director = new Director(new HTMLBuilder());
		String filename = (String) director.construct();
		System.out.println("已產生 " + filename);		
	}	
	
	private static void buildPlain() {
		Director director = new Director(new TextBuilder());
		String result = (String) director.construct();
		System.out.println(result);		
	}
	
	private static void printUsage() {
		System.out.println("Usage:");
		System.out.println("java Main plan 產生一般格式的文件");
		System.out.println("java Main html 產生 HTML 格式的文件");		
	}

}
