package view;

import org.junit.Before;
import org.junit.Test;

import bowling.Frame;

public class OutputScoreTest {
	Frame frame;
	String name = "NSG";

	@Before
	public void setting() {
		frame = new Frame();

	}

	@Test
	public void test_method_printScoreboard() {
		for (int i = 0; i < 20; i++) {
			OutputScore.printScoreboard(frame.roll(4), name);
		}
	}
}
