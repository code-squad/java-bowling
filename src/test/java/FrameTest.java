
import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {
	
	@Test
	public void changeToStringMethodTest() {
		Frame frame = new Frame();
		frame.makePinsPerFrame(3);
		assertEquals("  3   |", frame.changeToString());
		
		Frame frame2 = new Frame();
		frame2.makePinsPerFrame(10);
		assertEquals("  X   |", frame2.changeToString());
	}
	
	@Test
	public void changeSecondValueTest() {
		Frame frame = new Frame();
		frame.makePinsPerFrame(3);
		frame.makePinsPerFrame(4);
		assertEquals("  3|4 |", frame.chageSecondValue("3"));
		
		Frame frame2 = new Frame();
		frame2.makePinsPerFrame(1);
		frame2.makePinsPerFrame(9);
		assertEquals("  1|/ |", frame2.chageSecondValue("1"));
		
		Frame frame3 = new Frame();
		frame3.makePinsPerFrame(0);
		frame3.makePinsPerFrame(9);
		assertEquals("  -|9 |", frame3.chageSecondValue("0"));
	}
}
