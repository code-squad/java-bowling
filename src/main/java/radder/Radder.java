package radder;

public class Radder {
	final private int WIDTH_SIZE = 5;

	private int no;
	private String radder;

	public Radder(int no, String name) {
		this.no = no;
		this.radder = "|";
	}

	@Override
	public String toString() {
		return radder;
	}

}
