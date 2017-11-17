package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exception.InvalidPlayerNameException;

public class PlayerTest {

	@Test
	public void createPlayerTest() {
		Player player = new Player("SHC", 1);
		assertEquals("SHC", player.getName());
	}

	@Test(expected = InvalidPlayerNameException.class)
	public void createPlayerExceptionTest() {
		Player player = new Player("SDFG", 1);
	}

	@Test(expected = InvalidPlayerNameException.class)
	public void createPlayerExceptionTest_한글() {
		Player player = new Player("한글", 1);
	}
	
	@Test
	public void framesOfPlayerTest1() {
		Player framesOfPlayer = new Player("ABC", 1);
		framesOfPlayer.shot(3);
		framesOfPlayer.shot(7);
		framesOfPlayer.shot(4);
		assertTrue(framesOfPlayer.isEndCurrentFrame());
		assertEquals(14, framesOfPlayer.getTotalScore());
	}
}