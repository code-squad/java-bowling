package bowling;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	Frame frame;
	
	@Before
	public void setting() {
		frame = new NomalFrame();
	}
	
	
	@Test
	public void firstRollTest() {
		frame.saveBowl(new Pins(4));
	}
	
	@Test
	public void secondRollTest() {
		frame.saveBowl(new Pins(4));
		frame.saveBowl(new Pins(4));
	}
	
	@Test
	public void createNextFrameTest() {
		frame.saveBowl(new Pins(4));
		frame.saveBowl(new Pins(4));
		frame.saveBowl(new Pins(4));
	}
}



