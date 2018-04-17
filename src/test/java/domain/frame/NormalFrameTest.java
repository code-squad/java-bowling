package domain.frame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {
	@Test
	public void bowl테스트() {
		Frame frame = new NormalFrame(1, 1);
		assertThat(frame.bowl(9).isComplete()).isEqualTo(true);
		assertThat(frame.bowl(2).getFrameNumber()).isEqualTo(2);
		
		Frame nineFrame = new NormalFrame(9, 10);
		assertThat(nineFrame.bowl(1)).isInstanceOf(FinalFrame.class);
	}
	
	@Test
	public void isComplete테스트() {
		assertThat(new NormalFrame(1, 10).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(1, 1).bowl(9).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(1, 1).bowl(2).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(1, 10).bowl(2).isComplete()).isEqualTo(false);
	}
}
