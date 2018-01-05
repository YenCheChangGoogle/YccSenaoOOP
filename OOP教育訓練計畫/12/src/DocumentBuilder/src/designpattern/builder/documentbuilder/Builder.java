package designpattern.builder.documentbuilder;

public interface Builder {
	public abstract void makeTitle(String title);

	public abstract void makeString(String str);

	public abstract void makeItems(String[] items);

	public abstract Object getResult();
}
