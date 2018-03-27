package view;

import org.junit.Before;
import org.junit.Test;

import bowling.Frame;
import bowling.FrameNo;
import bowling.NomalFrame;
import bowling.Pins;

public class OutputScoreTest {
	Frame frame;
	String name = "NSG";

	@Before
	public void setting() {
		frame = new NomalFrame(new FrameNo(1));
		frame.roll(new Pins(10));
		frame.roll(new Pins(10));
		frame.roll(new Pins(5));
		frame.roll(new Pins(5));
		frame.roll(new Pins(10));
		frame.roll(new Pins(4));
		frame.roll(new Pins(4));
		frame.roll(new Pins(10));
		frame.roll(new Pins(10));
		frame.roll(new Pins(5));
		frame.roll(new Pins(5));
		frame.roll(new Pins(10));
		frame.roll(new Pins(10));
		frame.roll(new Pins(4));
		frame.roll(new Pins(4));
	}

	@Test
	public void test_method_printScoreboard() {
		OutputScore.printScoreboard(frame, name);
	}
}
