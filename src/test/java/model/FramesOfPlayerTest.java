package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FramesOfPlayerTest {

	@Test
	public void FramesOfPlayerTest1() {
		FramesOfPlayer framesOfPlayer = new FramesOfPlayer("ABC", 1);
		framesOfPlayer.shot(3);
		framesOfPlayer.shot(7);
		framesOfPlayer.shot(4);
		assertTrue(framesOfPlayer.isEndCurrentFrame());
		assertEquals(14, framesOfPlayer.getTotalScore());
	}

}
