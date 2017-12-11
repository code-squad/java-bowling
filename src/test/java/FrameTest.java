
import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {
	
	@Test
	public void changeToStringMethodTestWhenGeneralCase() {
		Frame frame = new Frame();
		frame.makePinsPerFrame(3);
		assertEquals("  3   |", frame.makeScoreMarkOnFrame());
	}
	
	@Test
	public void changeToStringMethodTestWhenPins10() {
		Frame frame = new Frame();
		frame.makePinsPerFrame(10);
		assertEquals("  X   |", frame.makeScoreMarkOnFrame());
	}
	
	@Test
	public void changeSecondValueTestWhenGeneralCase() {
		Frame frame = new Frame();
		frame.makePinsPerFrame(3);
		frame.makePinsPerFrame(4);
		assertEquals("  3|4 |", frame.chageSecondValue("3"));
	}
	
	@Test
	public void changeSecondValueTestWhenSumOfPins10() {
		Frame frame = new Frame();
		frame.makePinsPerFrame(1);
		frame.makePinsPerFrame(9);
		assertEquals("  1|/ |", frame.chageSecondValue("1"));
	}
	
	@Test
	public void changeSecondValueTestWhenPins0() {
		Frame frame = new Frame();
		frame.makePinsPerFrame(0);
		frame.makePinsPerFrame(9);
		assertEquals("  -|9 |", frame.chageSecondValue("0"));
	}
}
