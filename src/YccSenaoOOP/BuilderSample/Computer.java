package YccSenaoOOP.BuilderSample;

public class Computer {
	
	//必要規格
	private String CPU=""; //Intel(R) Core(TM)i7-4500U CPU @ 1.8GHz 2.40GHz
	private int RAM; //單位為GB 例如: 12GB
	private String[] HardDisks; //硬碟
	
	//選擇性規格
	private boolean isGraphicsCardEnabled; //顯示卡
	private boolean isBluetoothEnabled; //藍芽
	
	public String getCPU() {
		return CPU;
	}
	public int getRAM() {
		return RAM;
	}
	public String[] getHardDisks() {
		return HardDisks;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	public Computer(ComputerBuilder cBuilder) {
		this.CPU=cBuilder.getCPU();
		this.RAM=cBuilder.getRAM();
		this.HardDisks=cBuilder.getHardDisks();
		
		this.isBluetoothEnabled=cBuilder.isBluetoothEnabled();
		this.isGraphicsCardEnabled=cBuilder.isGraphicsCardEnabled();
	}

}
