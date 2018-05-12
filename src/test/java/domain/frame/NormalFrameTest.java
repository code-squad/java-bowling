package domain.frame;

import domain.status.Miss;
import domain.status.None;
import domain.status.Spare;
import domain.status.Strike;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

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
		assertThat(new NormalFrame(10).getStatus()).isInstanceOf(Strike.class);
		assertThat(new NormalFrame(9).bowl(1).getStatus()).isInstanceOf(Spare.class);
		assertThat(new NormalFrame(9).bowl(0).getStatus()).isInstanceOf(Miss.class);
		assertThat(new NormalFrame(9).getStatus()).isInstanceOf(None.class);
	}
	
	@Test
	public void score테스트() {
		NormalFrame frame = new NormalFrame(10);
		frame.bowl(2).bowl(3);
		assertThat(frame.getScore().getScore()).isEqualTo(15);
		frame.bowl(10).bowl(10).bowl(10);
		assertThat(frame.getScore().getScore()).isEqualTo(30);
		frame.bowl(10).bowl(1).bowl(9);
		assertThat(frame.getScore().getScore()).isEqualTo(21);

		frame = new NormalFrame(1);
		assertFalse(frame.getScore().getScoreFlag());
		frame.bowl(9).bowl(1).bowl(2);
		assertThat(frame.getScore().getScore()).isEqualTo(11);

		frame = new NormalFrame(1);
		frame.bowl(8).bowl(1).bowl(2);
		assertThat(frame.getScore().getScore()).isEqualTo(9);
	}
}
