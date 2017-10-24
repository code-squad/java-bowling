package bowling.result;

import java.util.List;

import bowling.frame.Frame;

public class Result {

	private List<Frame> frames;
	private String newLine = System.getProperty("line.separator");
	private List<Integer> scores;

	public Result(List<Frame> frames, List<Integer> scores) {
		this.frames = frames;
		this.scores = scores;
	}

	public String show(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstLine());
		stringBuilder.append(nameSection(name));
		stringBuilder.append(frameScoreSections());
		stringBuilder.append(totalScoreSections());
		return stringBuilder.toString();
	}

	private String totalScoreSections() {
		StringBuilder stringBuilder = new StringBuilder();
		if (frames.size() == 0) {
			return "|      |      |      |      |      |      |      |      |      |      |      |";
		}
		stringBuilder.append("|      |");
		stringBuilder.append(existedTotalSection(scores));
		stringBuilder.append(unExistedTotalSection(scores.size()));
		return stringBuilder.toString();
	}

	private Object unExistedTotalSection(int size) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = size; i < 10; i++) {
			stringBuilder.append("      |");
		}
		return stringBuilder.toString();
	}

	private String existedTotalSection(List<Integer> scores) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer index : scores) {
			stringBuilder.append("  ");
			stringBuilder.append(index);
			stringBuilder.append("  |");
		}
		return stringBuilder.toString();
	}

	private String frameScoreSections() {
		StringBuilder stringBuilder = new StringBuilder();
		if (frames.size() == 0) {
			return "      |      |      |      |      |      |      |      |      |      |" + newLine;
		}
		stringBuilder.append(existedSection(frames));
		stringBuilder.append(unExistedSection(frames.size()));
		stringBuilder.append(newLine);
		return stringBuilder.toString();
	}

	private String unExistedSection(int size) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = size; i < 10; i++) {
			stringBuilder.append("      |");
		}
		return stringBuilder.toString();
	}

	private String existedSection(List<Frame> frames) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Frame index : frames) {
			stringBuilder.append(index.getState().getChar());
		}
		return stringBuilder.toString();
	}

	private String nameSection(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|  ");
		stringBuilder.append(name);
		stringBuilder.append(" |");
		return stringBuilder.toString();
	}

	private String firstLine() {
		return "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |" + newLine;
	}

}
