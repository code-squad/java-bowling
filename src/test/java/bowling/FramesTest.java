package bowling;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class FramesTest {

	@Test
	public void countFrame() {
		Frames frames = new Frames(new HashMap<>());
		assertEquals(1, frames.countFrame());
	}

}
