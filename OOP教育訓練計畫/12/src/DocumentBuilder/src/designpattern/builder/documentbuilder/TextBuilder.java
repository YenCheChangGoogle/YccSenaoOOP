package designpattern.builder.documentbuilder;

public class TextBuilder implements Builder {

	private StringBuffer buffer = new StringBuffer();
	private static String newLine = "\n";

	@Override
	public void makeTitle(String title) {
		buffer.append("==============================" + newLine);
		buffer.append("『" + title + "』");
		buffer.append(newLine);
	}

	@Override
	public void makeString(String str) {
		buffer.append("■" + str);
		buffer.append(newLine);
	}

	@Override
	public void makeItems(String[] items) {
		for (String item : items) {
			buffer.append("●" + item + newLine);
		}
	}

	@Override
	public Object getResult() {
		buffer.append("==============================");
		return buffer.toString();
	}

}
