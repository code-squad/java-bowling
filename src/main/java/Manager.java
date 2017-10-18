import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Manager {
	Scanner scanner = new Scanner(System.in);
	List<Frame> frames = new ArrayList<>();
	List<Integer> scores = new ArrayList<>();
	Queue<Integer> tempScores = new LinkedList<>();
	String name;
	Board board;
	int score;
	int count;
	int totalScore;

	public void run() {
		System.out.print(startMessage());
		name = scanner.nextLine();
		board = new Board(name);
		System.out.println(board.create());
		while (frames.size() != 10) {
			System.out.println(name + "'s turn : ");
			score = scanner.nextInt();
			Frame frame = new NomalFrame(score);
			frames.add(frame);
			board.framesReceiveToManager(frames);
			System.out.println(board.create());
			System.out.println(name + "'s turn : ");
			score = scanner.nextInt();
			frame.secondScoreInsert(score);
			framesToScores(frame);
			scores.add(calculateScore(tempScores));
			board.scoresReceiveToManager(scores);
			System.out.println(board.create());
		}

	}

	private void framesToScores(Frame frame) {
		// TODO Auto-generated method stub
		tempScores.add(frame.firstTryScore);
		tempScores.add(frame.secondTryScore);
	}

	private int calculateScore(Queue<Integer> tempScores) {
		// TODO Auto-generated method stub
		while (!tempScores.isEmpty()) {
			totalScore += tempScores.poll();
		}
		return totalScore;
	}

	private int isStrike(boolean strike, Frame frame, List<Frame> frames) {
		// TODO Auto-generated method stub
		if (strike) {
			return 1;
		}
		System.out.println(name + "'s turn : ");
		score = scanner.nextInt();
		frame.secondScoreInsert(score);
		isSpare(frame.spare);
		return 0;
	}

	private int isSpare(boolean spare) {
		// TODO Auto-generated method stub
		return 0;
	}

	private String startMessage() {
		// TODO Auto-generated method stub
		return "플레이어 이름은(3 english letters)?: ";
	}
}
