package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	Bowling bowling;
	Pin pin;

	@Before
	public void setUp() {
		bowling = new Bowling();
		pin = new Pin(10);
	}

	@Test
	public void frames_에_제대로_add_가_되는지_확인() {
		for (int i = 0; i < 3; i++) {
			bowling.bowl(pin);
		}
		assertEquals(4, bowling.getFrames().size());
	}

}
