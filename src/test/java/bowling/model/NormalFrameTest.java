package bowling.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NormalFrameTest {

	NormalFrame frame;
	
	@Before
	public void setup() {
		frame = new NormalFrame();
		frame.play(2);
	}
	
	@Test
	public void 투구1() {
		assertThat(frame.getStatus()).isEqualTo("2");
	}

	@Test
	public void 미스() {
		frame.play(2);
		assertThat(frame.getStatus()).isEqualTo("2|2");
	}
	@Test
	public void 스페어() {
		frame.play(8);
		assertThat(frame.getStatus()).isEqualTo("2|/");
	}
	@Test
	public void 스트라이크() {
		frame = new NormalFrame();
		frame.play(10);
		assertThat(frame.getStatus()).isEqualTo("X");
	}
	@Test
	public void 제로() {
		frame.play(0);
		assertThat(frame.getStatus()).isEqualTo("2|-");
	}
}
