package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void getScore() {
		Frame frame = Frame.create(1);
		frame.bowl(8);
		frame.bowl(1);
		assertEquals(9, frame.getState().getEachFinalFrameScore());
	}
	
	@Test
	public void getScore_Spare() throws Exception {
		
	}
	

}
