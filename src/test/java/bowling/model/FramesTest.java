package bowling.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FramesTest {

	Frames frames;
	
	@Before
	public void setup() {
		frames = new Frames();
		frames.play(2);
	}
	
	@Test
	public void 프레임1() {
		assertThat(frames.getFrameNo()).isEqualTo(1);
	}

	@Test
	public void 스트라이크_다음프레임() {
		frames = new Frames();
		frames.play(10);
		frames.play(1);
		assertThat(frames.getFrameNo()).isEqualTo(2);
	}
	
	@Test
	public void 프레임2() {
		frames.play(2);
		frames.play(3);
		assertThat(frames.getFrameNo()).isEqualTo(2);
	}
}
