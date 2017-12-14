package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player p1;
	Pin pin1, pin2, pin3, pin4;
	@Before
	public void setUp() {
		p1 = new Player("Jiwon");
		pin1 = new Pin(10);
		pin2 = new Pin(9);
		pin3 = new Pin(1);
		pin4 = new Pin(0);

	}
	@Test
	public void playerIsEndTest() {
		Boolean end = p1.isEnd();
	}

}
