package bowling.frame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LastFrameTest {
	@Test
	public void 마지막프레임() {
		Frame frame = NormalFrame.create(1);
		Frame next = frame.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		assertEquals(next, LastFrame.create(10));
	}

}
