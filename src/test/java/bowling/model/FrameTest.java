package bowling.model;

import bowling.model.Frame;
import bowling.model.MissScore;
import bowling.model.SpareScore;
import bowling.model.StrikeScore;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class FrameTest {
	Frame frame;

	@Before
	public void setup() {
		frame = new Frame();
	}

	@Test
	public void 공_굴리기_스트라이크() {
		frame.bowl(10);
		assertThat(frame.score instanceof StrikeScore).isTrue();
	}

	@Test
	public void 공_굴리기_스페어() {
		frame.bowl(0);
		assertThat(frame.score == null).isTrue();
		frame.bowl(10);
		assertThat(frame.score instanceof SpareScore).isTrue();
	}

	@Test
	public void 공_굴리기_미스() {
		frame.bowl(3);
		assertThat(frame.score == null).isTrue();
		frame.bowl(6);
		assertThat(frame.score instanceof MissScore).isTrue();
	}

	//	@Test
//	public void 현재점수_스트라이크_보여주기() {
//		Frame frame = new Frame();
//		frame.bowl(10);
//		assertThat(frame.scoreToString()).isEqualTo("X");
//	}
//
//	@Test
//	public void 현재점수_앞거터_보여주기() {
//		Frame frame = new Frame();
//		frame.bowl(0, 2);
//		assertThat(frame.scoreToString()).isEqualTo("- | 2");
//	}

}
