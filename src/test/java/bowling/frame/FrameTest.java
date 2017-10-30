package bowling.frame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void 점수입력() {
		Frame frame = new Frame(1);
		frame.bowl(8);
		assertThat(frame.getFirstScore(), is(8));
	}

	@Test
	public void 프레임_생성_체크() throws Exception {
		Frame frame = new Frame(1);
		assertThat(frame.getNo(), is(1));
		frame = frame.bowl(10);
		assertThat(frame.getNo(), is(2));
		frame = frame.bowl(10);
		assertThat(frame.getNo(), is(3));
	}
}
