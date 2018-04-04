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
	public void test_method_printScoreboard_allFrame() {
		for (int i = 0; i < 20; i++) {
			frame = frame.roll(4);
		}
		OutputScore.printScoreboard(frame, name);
	}
	
	@Test
	public void test_method_printScoreboard() {
		for (int i = 0; i < 10; i++) {
			frame = frame.roll(4);
		}
		OutputScore.printScoreboard(frame, name);
	}
	
	@Test
	public void test_method_printTotalScoreBoard() {
		frame.roll(5);
		frame.roll(5);
		frame.roll(4);
		frame.roll(6);
		frame.roll(7);
		
		OutputScore.printTotalScoreBoard(frame);
	}
}
