package bowling.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidPinNumberException;

public class TenFrameTest {

	TenFrame frame;
	
	@Before
	public void setup() {
		frame = new TenFrame();
	}
	@Test
	public void 텐프레임_X() {
		frame.play(10);
		assertThat(frame.getStatus()).isEqualTo("X");
	}
	
	@Test
	public void 텐프레임_XX() {
		frame.play(10);
		frame.play(10);
		assertThat(frame.getStatus()).isEqualTo("X|X");
	}
	@Test
	public void 텐프레임_XXX() {
		frame.play(10);
		frame.play(10);
		frame.play(10);
		assertThat(frame.getStatus()).isEqualTo("X|X|X");
	}
	@Test
	public void 텐프레임_X_스페어() {
		frame.play(10);
		frame.play(5);
		frame.play(5);
		assertThat(frame.getStatus()).isEqualTo("X|5|/");
	}
	@Test
	public void 텐프레임_X_미스() {
		frame.play(10);
		frame.play(5);
		frame.play(4);
		assertThat(frame.getStatus()).isEqualTo("X|5|4");
	}
	@Test
	public void 텐프레임_스페어_X() {
		frame.play(2);
		frame.play(8);
		frame.play(10);
		assertThat(frame.getStatus()).isEqualTo("2|/|X");
	}
	@Test
	public void 텐프레임_스페어_미스() {
		frame.play(5);
		frame.play(5);
		frame.play(5);
		assertThat(frame.getStatus()).isEqualTo("5|/|5");
	}
	@Test
	public void 텐프레임_미스() {
		frame.play(2);
		frame.play(2);
		assertThat(frame.getStatus()).isEqualTo("2|2");
	}
	@Test
	public void 텐프레임_스페어() {
		frame.play(2);
		frame.play(8);
		assertThat(frame.getStatus()).isEqualTo("2|/");
	}

	@Test
	public void 미스_끝내기() {
		frame.play(2);
		frame.play(3);
		assertThat(frame.isEnd()).isEqualTo(true);
	}
	@Test
	public void 스페어_끝내기() {
		frame.play(2);
		frame.play(8);
		assertThat(frame.isEnd()).isEqualTo(false);
		frame.play(8);
		assertThat(frame.isEnd()).isEqualTo(true);
	}
	@Test
	public void 스트라이크_끝내기() {
		frame.play(10);
		assertThat(frame.isEnd()).isEqualTo(false);
		frame.play(2);
		assertThat(frame.isEnd()).isEqualTo(false);
		frame.play(8);
		assertThat(frame.isEnd()).isEqualTo(true);
	}
	
	@Test(expected = InvalidPinNumberException.class)
	public void 투구2_익셉션() {
		frame.play(6);
		frame.play(6);
	}
	
	@Test
	public void 투구2_익셉션_안남() {
		frame.play(10);
		frame.play(6);
		assertThat(frame.getStatus()).isEqualTo("X|6");
	}
	
	@Test(expected = InvalidPinNumberException.class)
	public void 투구3_익셉션() {
		frame.play(10);
		frame.play(6);
		frame.play(6);
	}
	@Test
	public void 투구3_익셉션_안남() {
		frame.play(10);
		frame.play(6);
		frame.play(4);
		assertThat(frame.getStatus()).isEqualTo("X|6|/");
	}
}
