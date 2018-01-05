package YccSenaoOOP.BuilderSample;

public class ComputerBuilderMain {

	public static void main(String[] args) {
		Computer  comp1=new ComputerBuilder(
				"Intel(R) Core(TM)i7-4500U CPU @ 1.8GHz 2.40GHz", 
				16, 
				new String[] {"WD Black PCIe SSD 512G", "WD Purple Surveillance Hard Drive 2T"}).setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
		
		Computer  comp2=new ComputerBuilder(
				"Intel(R) Core(TM)i5-8600K CPU @ 3.6GHz 4.30GHz", 
				32, 
				new String[] {"WD Black PCIe SSD 512G", "WD Purple Surveillance Hard Drive 6T", "WD Purple Surveillance Hard Drive 6T"}).setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
	}

}
