import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class ManagerTest {
	Manager manager;
	NomalFrame nomalFrame;
	Queue<Integer> scores;
	int score;
	boolean strike;

	@Before
	public void setup() {
		manager = new Manager();
		nomalFrame = new NomalFrame(5);
		nomalFrame.secondScoreInsert(5);
		scores = new LinkedList<>();
	}

	@Test
	public void 프레임의점수_큐로_옮기기() throws Exception {
		assertEquals(2, framesToScores(nomalFrame));
	}

	private int framesToScores(NomalFrame nomalFrame) {
		// TODO Auto-generated method stub
		scores.add(nomalFrame.firstTryScore);
		scores.add(nomalFrame.secondTryScore);
		return scores.size();
	}

	@Test
	public void 저장된_점수_계산() throws Exception {
		framesToScores(nomalFrame);
		assertEquals(10, calculateScore(scores));
	}

	private int calculateScore(Queue<Integer> scores) {
		// TODO Auto-generated method stub
		while (!scores.isEmpty()) {
			score += scores.poll();
		}
		return score;
	}

	@Test
	public void 스트라이크_참_거짓_확인() throws Exception {
		assertFalse(isStrike(nomalFrame.firstTryScore));
	}

	private boolean isStrike(int firstTryScore) {
		// TODO Auto-generated method stub
		return firstTryScore == 10;
	}

	@Test
	public void 스트라이크_일_때_점수계산() throws Exception {
		nomalFrame = new NomalFrame(10);
		strike = isStrike(nomalFrame.firstTryScore);
	}

}
