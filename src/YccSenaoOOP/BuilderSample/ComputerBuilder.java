package YccSenaoOOP.BuilderSample;

public class ComputerBuilder {
	
	//必要規格
	private String CPU=""; //Intel(R) Core(TM)i7-4500U CPU @ 1.8GHz 2.40GHz
	private int RAM; //單位為GB 12GB
	private String[] HardDisks;
	
	//選擇性規格
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	
	public ComputerBuilder(String CPU, int RAM, String[] HardDisks) {
		this.CPU=CPU;
		this.RAM=RAM;
		this.HardDisks=HardDisks;
	}
	
	public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
		this.isGraphicsCardEnabled = isGraphicsCardEnabled;
		return this;
	}

	public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
		this.isBluetoothEnabled = isBluetoothEnabled;
		return this;
	}
	
	public Computer build(){		
		return new Computer(this);
	}

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
}
