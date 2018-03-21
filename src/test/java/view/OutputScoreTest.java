package view;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import bowling.Frame;
import bowling.NomalFrame;
import bowling.Pins;

public class OutputScoreTest {
	Frame frame;
	String name = "NSG";
	
	@Before
	public void setting() {
		frame = new NomalFrame(1);
		frame.InputBowl(new Pins(10));
		frame.InputBowl(new Pins(10));
		frame.InputBowl(new Pins(5));
		frame.InputBowl(new Pins(5));
		frame.InputBowl(new Pins(10));
		frame.InputBowl(new Pins(4));
		frame.InputBowl(new Pins(4));
	}
	
	@Test
	public void test_method_printScoreboard() {
		OutputScore.printScoreboard(frame, name);
	}
}
