package bowling;

import java.util.List;

import bowling.frame.Frame;
import bowling.frame.FrameResult;

public class Board {

	private String name;
	private String newLine = System.getProperty("line.separator");

	public Board(String name) {
		this.name = name;
	}

	public String show(Frame frame, List<FrameResult> result) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(frontLine());
		stringBuilder.append(name());
		stringBuilder.append(frame(frame));
		stringBuilder.append(frameScore(result));
		return stringBuilder.toString();
	}

	private Object frameScore(List<FrameResult> result) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|      |");
		int no = result.size();
		for (int i = 0; i < result.size(); i++) {
			stringBuilder.append("  ");
			stringBuilder.append(result.get(i).getScore());
			stringBuilder.append("  |");

		}
		for (int i = no; i < 10; i++) {
			stringBuilder.append("      |");
		}
		return stringBuilder.toString();
	}

	private String frame(Frame frame) {
		Frame next = frame;
		int no = 0;
		StringBuilder stringBuilder = new StringBuilder();
		while (next.getNext() != null) {
			stringBuilder.append(next.getChar());
			next = next.getNext();
			no = next.getNo() - 1;
		}
		for (int i = no; i < 10; i++) {
			stringBuilder.append("      |");
		}
		stringBuilder.append(newLine);
		return stringBuilder.toString();
	}

	private String frameScore(Frame frame) {
		Frame next = frame;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|      |");
		int no = 0;
		while (next.getNext() != null) {
			stringBuilder.append("  ");
			stringBuilder.append(next.calc());
			stringBuilder.append("  |");
			next = next.getNext();
			no = next.getNo() - 1;
		}
		for (int i = no; i < 10; i++) {
			stringBuilder.append("      |");
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
