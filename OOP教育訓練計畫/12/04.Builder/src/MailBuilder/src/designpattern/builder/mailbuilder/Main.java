package designpattern.builder.mailbuilder;

public class Main {

	public static void main(String[] args) {
		Builder builder = new WelcomeBuilder();
		Director director = new Director(builder);
		director.construct("leoshiang@hotmail.com", "leoshiang@gmail.com");
	}

}
