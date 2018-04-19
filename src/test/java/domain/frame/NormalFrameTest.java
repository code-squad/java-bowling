package domain.frame;

import domain.PlayStatus;
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
		assertThat(new NormalFrame(10).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(1).bowl(9).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(1).bowl(2).isComplete()).isEqualTo(true);
		assertThat(new NormalFrame(10).bowl(2).isComplete()).isEqualTo(false);
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
	public void getStatus테스트() {
		assertThat(new NormalFrame(10).getStatus()).isEqualTo(PlayStatus.STRIKE);
		assertThat(new NormalFrame(9).bowl(1).getStatus()).isEqualTo(PlayStatus.SPARE);
		assertThat(new NormalFrame(9).bowl(0).getStatus()).isEqualTo(PlayStatus.MISS);
		assertThat(new NormalFrame(9).getStatus()).isEqualTo(PlayStatus.NONE);
	}
	
	@Test
	public void canScore테스트() {
		assertThat(new NormalFrame(10).canScore()).isEqualTo(false);
		assertThat(new NormalFrame(1).bowl(9).canScore()).isEqualTo(false);
		assertThat(new NormalFrame(1).canScore()).isEqualTo(false);
		assertThat(new NormalFrame(2).bowl(5).canScore()).isEqualTo(true);
		assertThat(new NormalFrame(0).canScore()).isEqualTo(false);
		assertThat(new NormalFrame(0).bowl(0).canScore()).isEqualTo(true);
		
		Frame frame = new NormalFrame(10);
		frame.bowl(2);
		assertThat(frame.canScore()).isEqualTo(false);
		
		frame.bowl(2).bowl(8);
		assertThat(frame.canScore()).isEqualTo(true);
		
		frame = new NormalFrame(8).bowl(2);
		frame.bowl(10);
		assertThat(frame.canScore()).isEqualTo(true);
	}
	
	@Test
	public void score테스트() {
		NormalFrame frame = new NormalFrame(10);
		frame.bowl(2).bowl(3);
		//assertThat(frame.score()).isEqualTo(15);

		frame = new NormalFrame(10);
		frame.bowl(10).bowl(10).bowl(10);

	}
}
