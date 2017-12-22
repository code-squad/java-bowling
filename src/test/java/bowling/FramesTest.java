package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class FramesTest {

	@Test
	public void countFrame() {
		Frames frames = new Frames();
		assertEquals(1, frames.countFrame());
	}

}
