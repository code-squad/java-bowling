import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Manager {
	List<Frame> frames = new ArrayList<>();
	List<Integer> scores = new ArrayList<>();
	Queue<Integer> tempScores = new LinkedList<>();
	String name;
	Board board;
	int count;
	int totalScore;

	public void run() {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		board = new Board(Utils.insertName());
		System.out.println(board.create());
		while (frames.size() != 10) {
			System.out.println(name + "'s turn : ");
			Frame frame = frameSizeCheck(frames.size(), Utils.insertScore());
			frames.add(frame);
			board.framesReceiveToManager(frames);
			System.out.println(board.create());
			isStrike(frame);
			// System.out.println(name + "'s turn : ");
			// score = scanner.nextInt();
			// frame.secondScoreInsert(score);
			// x To y
			scoresToFrames(frame);
			scores.add(calculateScore(tempScores));
			board.scoresReceiveToManager(scores);
			System.out.println(board.create());
		}
	}

	private Frame frameSizeCheck(int size, int score) {
		if (size == 9) {
			// 마지막 프레임으로 바꾸기
			return new LastFrame(score);
		}
		return new NomalFrame(score);
	}

	private int isStrike(Frame frame) {
		if (frame.strike) {
			return 1;
		}
		System.out.println(name + "'s turn : ");
		frame.secondScoreInsert(Utils.insertScore());
		isSpare(frame);
		return 0;
	}

	private void isSpare(Frame frame) {

	}

	private void scoresToFrames(Frame frame) {
		tempScores.add(frame.firstTryScore);
		tempScores.add(frame.secondTryScore);
	}

	private int calculateScore(Queue<Integer> tempScores) {
		while (!tempScores.isEmpty()) {
			totalScore += tempScores.poll();
		}
		return totalScore;
	}

}
