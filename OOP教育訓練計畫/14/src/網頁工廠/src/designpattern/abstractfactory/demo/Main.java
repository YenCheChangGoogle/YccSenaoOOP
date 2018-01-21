package designpattern.abstractfactory.demo;

import designpattern.abstractfactory.demo.抽象工廠.抽象容器;
import designpattern.abstractfactory.demo.抽象工廠.抽象工廠;
import designpattern.abstractfactory.demo.抽象工廠.抽象連結;
import designpattern.abstractfactory.demo.抽象工廠.抽象頁面;

public class Main {

	public static void main(String[] args) {
		檢查參數(args);
		String 工廠類別名稱 = args[0];
		抽象工廠 具體工廠 = 抽象工廠.取得工廠(工廠類別名稱);
		建立頁面(具體工廠);
	}

	public static void 建立頁面(抽象工廠 工廠) {
		抽象連結 精選好康連結 = 工廠.建立連結("精選好康", "https://online.senao.com.tw/Category/1/GP1601-010");
		抽象容器 精選好康容器 = 工廠.建立容器("精選好康");
		精選好康容器.加入(精選好康連結);

		抽象連結 生活美食連結 = 工廠.建立連結("生活美食", "https://online.senao.com.tw/Category/1/GP1601-009");
		抽象容器 生活美食容器 = 工廠.建立容器("精選好康");
		生活美食容器.加入(生活美食連結);

		抽象頁面 頁面 = 工廠.建立頁面("神腦線上", "SENAO");
		頁面.加入(精選好康容器);
		頁面.加入(生活美食容器);
		頁面.輸出();
	}

	public static void 檢查參數(String[] args) {
		if (args.length != 1) {
			System.out.println("使用方法 java 主程式 工廠類別名稱");
			System.out.println("範例一: java 主程式 列表工廠");
			System.out.println("範例二: java 主程式 表格工廠");
			System.exit(0);
		}
	}

}