package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Exception.PlayerNameException;

public class TestPlayer {

	@Test
	public void createPlayerTest() {
		Player player = new Player("SHC");
		assertEquals("SHC", player.getName());
	}

	@Test(expected = PlayerNameException.class)
	public void createPlayerExceptionTest() {
		Player player = new Player("SDFG");
	}

	@Test(expected = PlayerNameException.class)
	public void createPlayerExceptionTest_한글() {
		Player player = new Player("한글");
	}
}