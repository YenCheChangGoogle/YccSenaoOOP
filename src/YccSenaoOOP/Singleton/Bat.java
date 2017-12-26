package YccSenaoOOP.Singleton;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Bat {
	final float PI = 3.14f; // 在定義時便給址值
	final int i; // 因為要在構造函數中進行初始化，所以此處便不可再給值
	final List list; // 此變量也與上面的壹樣

	Bat() {
		i = 100;
		list = new LinkedList();
	}

	Bat(int ii, List l) {
		i = ii;
		list = l;
	}

	public static void main(String[] args) {
		Bat b = new Bat();
		b.list.add(new Bat());
		// b.i=25;
		// b.list=new ArrayList();
		System.out.println("I=" + b.i + " List Type:" + b.list.getClass());
		b = new Bat(23, new ArrayList());
		b.list.add(new Bat());
		System.out.println("I=" + b.i + " List Type:" + b.list.getClass());
	}
}