package bowling.board;

import java.util.List;

import bowling.frame.Frame;
import bowling.score.Score;

public class Board {

	private String name;
	private List<Frame> frames;

	public Board(String name, List<Frame> frames) {
		this.name = name;
		this.frames = frames;
	}

	public String show(Score scores) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(frontLine());
		stringBuilder.append(nameSection());
		stringBuilder.append(frame());
		stringBuilder.append(frameScore(scores.getScores()));
		return stringBuilder.toString();
	}

	private StringBuilder frameScore(List<Integer> list) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|      |");
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.append("  ");
			stringBuilder.append(list.get(i));
			stringBuilder.append("  |");
		}
		for (int i = list.size(); i < 10; i++) {
			stringBuilder.append("      |");
		}
		return stringBuilder;
	}

	private StringBuilder frame() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < frames.size(); i++) {
			stringBuilder.append(frames.get(i).getState().getChar());
		}
		for (int i = frames.size(); i < 10; i++) {
			stringBuilder.append("      |");
		}
		stringBuilder.append("\n");
		return stringBuilder;
	}

	private StringBuilder nameSection() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|  ");
		stringBuilder.append(name);
		stringBuilder.append(" |");
		return stringBuilder;
	}

	private StringBuilder frontLine() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n");
		return stringBuilder;
	}

}
