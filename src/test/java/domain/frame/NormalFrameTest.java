package domain.frame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {
	@Test(expected = IllegalArgumentException.class)
	public void 생성테스트() {
		new NormalFrame(10, 11);
	}

	@Test
	public void bowl테스트() {
		Frame frame = new NormalFrame(1, 1);
		assertThat(frame.bowl(9).isComplete()).isEqualTo(true);
		assertThat(frame.bowl(2).getFrameNumber()).isEqualTo(2);
		
		Frame nineFrame = new NormalFrame(Frame.MAX_FRAME_NUMBER - 1, 10);
		assertThat(nineFrame.bowl(1)).isInstanceOf(FinalFrame.class);
	}
	
	@Test
	public void isComplete테스트() {
		assertThat(new NormalFrame(1, 10).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(1, 1).bowl(9).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(1, 1).bowl(2).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(1, 10).bowl(2).isComplete()).isEqualTo(false);
	}

	@Test
	public void isRemained테스트() {
		assertThat(new NormalFrame(10, 9).isPinRemained()).isEqualTo(true);
		assertThat(new NormalFrame(10, 10).isPinRemained()).isEqualTo(false);

		assertThat(new NormalFrame(10, 1).bowl(2).isPinRemained()).isEqualTo(true);
		assertThat(new NormalFrame(10, 1).bowl(9).isPinRemained()).isEqualTo(false);
	}
	
	@Test
	public void isFinalFrame테스트() {
		assertThat(new NormalFrame(2, 8).isFinalFrame()).isEqualTo(false);
		assertThat(new NormalFrame(3, 10).isFinalFrame()).isEqualTo(false);
		assertThat(new NormalFrame(5, 9).bowl(1).isFinalFrame()).isEqualTo(false);
		assertThat(new NormalFrame(6, 1).bowl(9).bowl(10).isFinalFrame()).isEqualTo(false);
		assertThat(new NormalFrame(9, 1).bowl(9).bowl(10).isFinalFrame()).isEqualTo(true);
	}

	@Test
	public void hasSecondPitch테스트() {
		assertThat(new NormalFrame(10, 10).hasSecondPitch()).isEqualTo(false);
		assertThat(new NormalFrame(10, 1).bowl(2).hasSecondPitch()).isEqualTo(true);
	}
}
