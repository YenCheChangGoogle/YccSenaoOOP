package designpattern.abstractfactory.demo.抽象工廠;

public abstract class 抽象工廠 {
	public static 抽象工廠 取得工廠(String 類別名稱) {
		抽象工廠 工廠 = null;
		try {
			工廠 = (抽象工廠) Class.forName(類別名稱).newInstance();
		} catch (ClassNotFoundException e) {
			System.err.println("找不到類別" + 類別名稱);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 工廠;
	}
	
	public abstract 抽象連結 建立連結(String 標題, String 網址);

	public abstract 抽象容器 建立容器(String 標題);

	public abstract 抽象頁面 建立頁面(String 標題, String 作者);
}