package bowling.result;

import java.util.List;

import bowling.frame.Frame;
import bowling.frame.state.State;
import bowling.score.Score;

public class Result {

	private final String newLine = System.getProperty("line.separator");

	private Frame frame;

	private Score frameScore;

	public Result(Frame frame, Score score) {
		this.frame = frame;
		this.frameScore = score;
	}

	public String show(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(frontLine());
		stringBuilder.append(frameLine(name));
		stringBuilder.append(scoreLine());
		return stringBuilder.toString();
	}

	private StringBuilder scoreLine() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|      |");
		if (frameScore == null) {
			return stringBuilder;
		}
		List<Integer> scores = frameScore.get();
		for (Integer index : scores) {
			stringBuilder.append("  ");
			stringBuilder.append(index);
			stringBuilder.append("  |");
		}
		return stringBuilder;
	}

	private StringBuilder frameLine(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(nameSection(name));
		stringBuilder.append(frameSection());
		return stringBuilder;
	}

	private StringBuilder frameSection() {
		StringBuilder stringBuilder = new StringBuilder();
		Frame frame = this.frame;
		while (frame != null) {
			stringBuilder.append("  ");
			State state = frame.getState();
			stringBuilder.append(state.getPresentScore());
			stringBuilder.append("  |");
			frame = frame.getNext();
		}
		stringBuilder.append(newLine);
		return stringBuilder;
	}

	private StringBuilder nameSection(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("| ");
		stringBuilder.append(name);
		stringBuilder.append("  |");
		return stringBuilder;
	}

	private StringBuilder frontLine() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		stringBuilder.append(newLine);
		return stringBuilder;
	}

}
