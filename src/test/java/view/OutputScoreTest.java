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
		
		for (int i = 0; i < 20; i++) {
			frame.roll(4);
		}
	}

	@Test
	public void test_method_printScoreboard() {
		OutputScore.printScoreboard(frame, name);
	}
}
