package designpattern.builder.documentbuilder;

public class Director {
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public Object construct() {
		builder.makeTitle("產品名稱");
		builder.makeString("iPhone X 銀 256GB【新機上市】");
		builder.makeItems(new String[] {
				"★5.8 吋 Super Retina HD 顯示器", 
				"★全玻璃與不鏽鋼機身設計，IP67 等級防潑抗水與防塵"
		});
		
		builder.makeString("規格");
		builder.makeItems(new String[] {
				"A11 Bionic 64 位元核心處理器 + M11 動作感應協同處理器", 
				"作業系統：iOS 11"
		});
		
		return builder.getResult();
	}

}
