package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidFinFalledException;

public class FrameScoreBoardTest {
	private FrameScoreBoard frameScoreBoard;
	private Pins pins;
	
	@Before
	public void beforeTest() {
		frameScoreBoard = new FrameScoreBoard();
		pins = new Pins();
	}
	
	@Test
	public void testAddScore() {
		frameScoreBoard.addScore(pins.fallPins(5));
		frameScoreBoard.addScore(pins.fallPins(3));
		assertEquals("5|3", frameScoreBoard.currentScoreValue());
		assertEquals(8, frameScoreBoard.getSumScore());

		
	}
	
	@Test
	public void testAddScore2() {
		frameScoreBoard.addScore(pins.fallPins(5));
		frameScoreBoard.addScore(pins.fallPins(5));
		assertEquals("5|/", frameScoreBoard.currentScoreValue());
		assertEquals(10, frameScoreBoard.getSumScore());
	}
	
	@Test
	public void testAddScore3() {
		frameScoreBoard.addScore(pins.fallPins(10));
		assertEquals("X", frameScoreBoard.currentScoreValue());
		assertEquals(10, frameScoreBoard.getSumScore());
	}
	
	@Test(expected = InvalidFinFalledException.class)
	public void testAddScoreException() {
		frameScoreBoard.addScore(pins.fallPins(10));
		frameScoreBoard.addScore(pins.fallPins(3));
	}
}
