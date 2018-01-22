package bowling;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class FrameTest {

	@Test
	public void 현재점수_기본_보여주기() {
		Frame frame = new Frame();
		frame.bowl(8, 1);
		assertThat(frame.scoreToString()).isEqualTo("8 | 1");
	}

	@Test
	public void 현재점수_스페어_보여주기() {
		Frame frame = new Frame();
		frame.bowl(8, 2);
		assertThat(frame.scoreToString()).isEqualTo("8 | /");
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
