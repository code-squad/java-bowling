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
	@Test
	public void status_담은_리스트가_맞게_반환되는지_확인() throws Exception {
		for (int i = 0; i < 3; i++) {
			bowling.bowl(pin);
		}
		assertEquals(3, bowling.makeStatus().size());
		assertEquals("X", bowling.makeStatus().get(0));
	}

}
