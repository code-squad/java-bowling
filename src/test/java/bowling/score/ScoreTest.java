package bowling.score;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.Frame;

public class ScoreTest {
	@Test
	public void 노말_점수_계산() {
		Frame frame = new Frame(1);
		Frame next = frame;
		Score score = new Score();
		next.bowl(1);
		next.bowl(2);
		assertThat(score.calc(frame, 0), is(3));
	}

	@Test
	public void 스페어_점수_계산() throws Exception {
		Frame frame = new Frame(1);
		Frame next = frame;
		Score score = new Score();
		next = next.bowl(1);
		next = next.bowl(9);
		next = next.bowl(4);
		assertThat(score.calc(frame, 1), is(14));
	}

	@Test
	public void 스트라이크_점수_계산() throws Exception {
		Frame frame = new Frame(1);
		Frame next = frame;
		Score score = new Score();
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		assertThat(score.calc(frame, 2), is(30));
	}
}
