import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NomalFrameTest {
	NomalFrame nomalFrame;

	@Before
	public void setup() {
		nomalFrame = new NomalFrame(6);
	}

	private int getFirstTryScore() {
		return nomalFrame.firstTryScore;
	}

	@Test
	public void 스트라이크_참_거짓_확인() throws Exception {
		assertFalse(isStrike(nomalFrame.firstTryScore));
	}

	private boolean isStrike(int firstTryScore) {
		if (firstTryScore == 10) {
			nomalFrame.strike = true;
		}
		return nomalFrame.strike;
	}

	@Test
	public void 스페어_확인() throws Exception {
		secondScoreInsert(4);
		assertTrue(isSpare(getFirstTryScore(), getSecondTryScore()));
	}

	private boolean isSpare(int firstTryScore, int secondTryScore) {
		return (firstTryScore + secondTryScore) == 10;
	}

	private void secondScoreInsert(int score) {
		nomalFrame.secondTryScore = score;

	}

	private int getSecondTryScore() {
		return nomalFrame.secondTryScore;
	}
}
