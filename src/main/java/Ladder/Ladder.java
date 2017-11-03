package Ladder;

public class Ladder {

	private int no;
	private String radder;
	private Width left;
	private Width right;

	public Ladder(int no, String name) {
		this.no = no;
		this.radder = "|";
	}

	@Override
	public String toString() {
		return radder;
	}

	public Width getLeft() {
		return left;
	}

	public Width getRight() {
		return right;
	}

}
