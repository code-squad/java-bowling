package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidFinFalledException;

public class PinsTest {
	private Pins pins;
	
	@Before
	public void beforeTest() {
		pins = new Pins();
	}

	@Test
	public void fallPinTest() {
		pins.fallPins(5);
		assertEquals(false, pins.checkInvalidFalled());
		pins.fallPins(5);
		assertEquals(true, pins.checkInvalidFalled());

		Pins pins2 = new Pins();
		pins2.fallPins(10);
		assertEquals(true, pins2.checkInvalidFalled());
	}

	@Test(expected = InvalidFinFalledException.class)
	public void fallPinExceptionTest() {
		pins.fallPins(11);
	}

}
