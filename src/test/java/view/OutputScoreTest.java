package view;

import org.junit.Before;
import org.junit.Test;

import bowling.FrameNo;
import bowling.Pins;
import frame.Frame;
import frame.NormalFrame;

public class OutputScoreTest {
	Frame frame;
	String name = "NSG";

	@Before
	public void setting() {
		frame = new NormalFrame(1);
		
		frame.roll(10);
		
		frame.roll(10);
		
		frame.roll(5);
		frame.roll(5);
		
		frame.roll(10);
		
		frame.roll(4);
		frame.roll(4);
		
		frame.roll(10);
		
		frame.roll(10);
		
		frame.roll(7);
		frame.roll(0);
				
		frame.roll(0);
		frame.roll(10);
		
		frame.roll(10);
		
		
//		
//		frame.roll(9);
//		frame.roll(9);
		
		
		
//		frame.roll(10);
//		frame.roll(9);
//		

		
		frame.roll(10);
		frame.roll(10);
		
		
	}

	@Test
	public void test_method_printScoreboard() {
		OutputScore.printScoreboard(frame, name);
	}
}
