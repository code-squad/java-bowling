package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatusTest {
	List<Pin> pins;
	Pin pin1, pin2, pin3;

	@Before
	public void setUp() {
		pins = new ArrayList<>();
		pin1 = new Pin(10);
	}

	@Test
	public void whenFirstPinIsStrike_3StrikeTest() {
		pin1 = new Pin(10);
		pin2 = new Pin(10);
		pin3 = new Pin(10);
		pins.add(pin1);
		pins.add(pin2);
		pins.add(pin3);

		assertEquals("XXX", Status.whenFirstPinIsStrike(pins.stream().map(s -> s).toArray(Pin[]::new)));
	}

	@Test
	public void whenFirstPinIsStrike_2StrikeTest() {
		pin1 = new Pin(10);
		pin2 = new Pin(10);
		pins.add(pin1);
		pins.add(pin2);

		assertEquals("XX", Status.whenFirstPinIsStrike(pins.stream().map(s -> s).toArray(Pin[]::new)));
	}

	@Test
	public void whenFirstPinIsStrike_2Strike1PinTest() {
		pin1 = new Pin(10);
		pin2 = new Pin(10);
		pin3 = new Pin(1);
		pins.add(pin1);
		pins.add(pin2);
		pins.add(pin3);
		assertEquals("XX1", Status.whenFirstPinIsStrike(pins.stream().map(s -> s).toArray(Pin[]::new)));
	}

	@Test
	public void whenFirstPinIsStrike_1Strike2PinsTest() {
		pin1 = new Pin(10);
		pin2 = new Pin(9);
		pin3 = new Pin(0);
		pins.add(pin1);
		pins.add(pin2);
		pins.add(pin3);
		assertEquals("X9|-", Status.whenFirstPinIsStrike(pins.stream().map(s -> s).toArray(Pin[]::new)));
	}

	@Test
	public void whenFirstPinIsNoStrike_1Pin() {
		pin1 = new Pin(9);
		pins.add(pin1);
		assertEquals("9", Status.createStatus(pins.stream().map(s -> s).toArray(Pin[]::new)));
	}

	@Test
	public void whenFirstPinIsNoStrike_2Pin() {
		pin1 = new Pin(9);
		pin2 = new Pin(1);
		pins.add(pin1);
		pins.add(pin2);
		assertEquals("9|/", Status.createStatus(pins.stream().map(s -> s).toArray(Pin[]::new)));
	}

	@Test
	public void whenFirstPinIsNoStrike_3Pin() {
		pin1 = new Pin(9);
		pin2 = new Pin(1);
		pin3 = new Pin(10);
		pins.add(pin1);
		pins.add(pin2);
		pins.add(pin3);
		assertEquals("9|/X", Status.createStatus(pins.stream().map(s -> s).toArray(Pin[]::new)));
	}

}
