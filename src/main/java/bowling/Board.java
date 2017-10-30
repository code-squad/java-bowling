package bowling;

import bowling.frame.Frame;

public class Board {

	private String name;
	private String newLine = System.getProperty("line.separator");

	public Board(String name) {
		this.name = name;
	}

	public String show(Frame frame) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(frontLine());
		stringBuilder.append(name());
		stringBuilder.append(frame(frame));
		stringBuilder.append(frameScore(frame));
		return stringBuilder.toString();
	}

	private String frame(Frame frame) {
		Frame next = frame;
		StringBuilder stringBuilder = new StringBuilder();
		while (next.getNext() != null) {
			stringBuilder.append(next.getChar());
			next = next.getNext();
		}
		stringBuilder.append(newLine);
		return stringBuilder.toString();
	}

	private String frameScore(Frame frame) {
		Frame next = frame;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|      |");
		while (next.getNext() != null) {
			stringBuilder.append("  ");
			stringBuilder.append(next.calc());
			stringBuilder.append("   |");
			next = next.getNext();
		}
		return stringBuilder.toString();
	}

	private String name() {
		return "|  " + name + " |";
	}

	private String frontLine() {
		return "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |" + newLine;
	}

}
