package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatusTest {

	@Test
	public void status_생성테스트() {
		int[] pins1 = { 10, 10 };
		String s1 = Status.createStatusFor10thFrame(pins1);
		assertEquals("XX", s1);

		int[] pins2 = { 10, 1, 9 };
		String s2 = Status.createStatusFor10thFrame(pins2);
		assertEquals("X1|/", s2);

		int[] pins3 = { 9, 1, 10 };
		String s3 = Status.createStatusFor10thFrame(pins3);
		assertEquals("9|/X", s3);

		int[] pins4 = { 9, 1 };
		String s4 = Status.createStatusFor10thFrame(pins4);
		assertEquals("9|/", s4);

		int[] pins5 = { 10 };
		String s5 = Status.createStatusFor10thFrame(pins5);
		assertEquals("X", s5);
	}

}
