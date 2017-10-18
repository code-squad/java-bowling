import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class NomalFrameTest {
	NomalFrame nomalFrame;

	@Before
	public void setup() {
		nomalFrame = new NomalFrame(6);
	}

	@Test
	public void 첫_점수_입력() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("WSH's turn : ");
		int score = scanner.nextInt();
		nomalFrame = new NomalFrame(score);
		assertEquals(getFirstTryScore(), score);
		scanner.close();
	}

	private int getFirstTryScore() {
		// TODO Auto-generated method stub
		return nomalFrame.firstTryScore;
	}

	@Test
	public void 스트라이크_참_거짓_확인() throws Exception {
		assertFalse(isStrike(nomalFrame.firstTryScore));
	}

	private boolean isStrike(int firstTryScore) {
		// TODO Auto-generated method stub
		if (firstTryScore == 10) {
			nomalFrame.strike = true;
		}
		return nomalFrame.strike;
	}

	@Test
	public void 두_번쨰_점수_입력() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("WSH's turn : ");
		int score = scanner.nextInt();
		secondScoreInsert(score);
		assertEquals(getSecondTryScore(), score);
		scanner.close();
	}

	@Test
	public void 스페어_확인() throws Exception {
		secondScoreInsert(4);
		assertTrue(isSpare(getFirstTryScore(), getSecondTryScore()));
	}

	private boolean isSpare(int firstTryScore, int secondTryScore) {
		// TODO Auto-generated method stub
		return (firstTryScore + secondTryScore) == 10;
	}

	private void secondScoreInsert(int score) {
		// TODO Auto-generated method stub
		nomalFrame.secondTryScore = score;

	}

	private int getSecondTryScore() {
		// TODO Auto-generated method stub
		return nomalFrame.secondTryScore;
	}
}
