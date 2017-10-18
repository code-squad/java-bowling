import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	private String newLine = System.getProperty("line.separator");
	private final static String separateCharacter = "|";

	private String name = "WSH";
	Frame nomalFrame;
	List<Frame> frames;
	List<Integer> scores;
	Queue<Integer> tempScores;
	int score;

	@Before
	public void setup() {
		tempScores = new LinkedList<>();
		board = new Board("WSH");
		nomalFrame = new NomalFrame(8);
		nomalFrame.secondScoreInsert(1);
		frames = new ArrayList<>();
		frames.add(nomalFrame);
		tempScores.add(nomalFrame.firstTryScore);
		tempScores.add(nomalFrame.secondTryScore);
		scores = new ArrayList<>();
		scores.add(calculateScore(tempScores));
		nomalFrame = new NomalFrame(4);
		nomalFrame.secondScoreInsert(5);
		tempScores.add(nomalFrame.firstTryScore);
		tempScores.add(nomalFrame.secondTryScore);
		scores.add(calculateScore(tempScores));
	}

	private int calculateScore(Queue<Integer> tempScores) {
		// TODO Auto-generated method stub
		while (!tempScores.isEmpty()) {
			score += tempScores.poll();
		}
		return score;
	}

	@Test
	public void 초기_보드_생성() throws Exception {
		assertEquals("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n"
				+ "|  WSH |  8|1 |  4|5 |      |      |      |      |      |      |      |      |\n"
				+ "|      |  9   |  18  |      |      |      |      |      |      |      |      |", create());
	}

	private String create() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstLine());
		stringBuilder.append(nameSection(name));
		stringBuilder.append(secondLine(frames));
		stringBuilder.append("|      |");
		stringBuilder.append(thirdLine(scores));
		return stringBuilder.toString();
	}

	private String thirdLine(List<Integer> scores) {
		// TODO Auto-generated method stub
		if (scores == null) {
			return "      |      |      |      |      |      |      |      |      |      |";
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(existedScoreValues(scores));
		stringBuilder.append(unExistedScoreValues(scores.size()));
		return stringBuilder.toString();
	}

	private String unExistedScoreValues(int size) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = size; i < 10; i++) {
			stringBuilder.append("      |");
		}
		return stringBuilder.toString();
	}

	private String existedScoreValues(List<Integer> scores) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer index : scores) {
			stringBuilder.append("  ");
			stringBuilder.append(index);
			stringBuilder.append("  |");
		}
		return stringBuilder.toString();
	}

	private String secondLine(List<Frame> frames) {
		// TODO Auto-generated method stub
		if (frames == null) {
			return "      |      |      |      |      |      |      |      |      |      |" + newLine;
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(usefullValue(frames));
		stringBuilder.append(unUsefullValue(frames.size()));
		return stringBuilder.toString();
	}

	private String unUsefullValue(int size) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = size; i < 10; i++) {
			stringBuilder.append("      |");
		}
		stringBuilder.append(newLine);
		return stringBuilder.toString();
	}

	private String usefullValue(List<Frame> frames) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();

		for (Frame frame : frames) {
			stringBuilder.append(firstScorePrint(frame));
			stringBuilder.append(secondScorePrint(frame));
		}

		return stringBuilder.toString();
	}

	private String secondScorePrint(Frame frame) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(secondScoreCheck(frame));
		return stringBuilder.toString();
	}

	private String secondScoreCheck(Frame frame) {
		// TODO Auto-generated method stub
		if (frame.count == 1) {
			return "   |";
		}
		if (frame.firstTryScore + frame.secondTryScore == 10) {
			return "|/ |";
		}
		if (frame.secondTryScore == 0) {
			return "|- |";
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(separateCharacter);
		stringBuilder.append(frame.secondTryScore);
		stringBuilder.append(" |");
		return stringBuilder.toString();
	}

	private String firstScorePrint(Frame frame) {
		// TODO Auto-generated method stub

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("  ");
		if (frame.firstTryScore == 10) {
			return stringBuilder.append("X").toString();
		}
		stringBuilder.append(frame.firstTryScore);
		return stringBuilder.toString();
	}

	private String nameSection(String name) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|  ");
		stringBuilder.append(name);
		stringBuilder.append(" |");
		return stringBuilder.toString();
	}

	private String firstLine() {
		// TODO Auto-generated method stub
		return "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |" + newLine;
	}

}
