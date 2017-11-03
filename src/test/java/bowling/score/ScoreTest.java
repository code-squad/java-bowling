package bowling.score;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bowling.frame.Frame;

public class ScoreTest {

	@Test
	public void 일반() {
		Frame frame = Frame.create(0);
		frame.bowl(5);
		frame.bowl(1);
		int[] result = frame.getScore();
		assertEquals(2, result.length);
	}

	@Test
	public void 스페어() {
		List<Frame> frames = new ArrayList<>();
		Frame frame = Frame.create(0);
		frame.bowl(2);
		frame.bowl(8);
		frames.add(frame);
		frame = frame.create(1);
		frame.bowl(3);
		frame.bowl(3);
		frames.add(frame);
		int[] result = frame.getScore();
		assertEquals(2, result.length);
	}

	@Test
	public void 스트라이크() {
		Frame frame = Frame.create(0);
		frame.bowl(5);
		frame.bowl(1);
		int[] result = frame.getScore();
		assertEquals(2, result.length);
	}

}
