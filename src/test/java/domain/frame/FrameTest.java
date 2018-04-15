package domain.frame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {
	@Test
	public void bowlTest() {
		Frame frame = new NormalFrame(1, 1);
		assertThat(frame.bowl(9).isComplete()).isEqualTo(true);
		assertThat(frame.bowl(2).getFrameNumber()).isEqualTo(2);
		
		Frame nineFrame = new NormalFrame(9, 10);
		assertThat(nineFrame.bowl(1)).isInstanceOf(FinalFrame.class);
	}
	
	@Test
	public void get() {
	}
}
