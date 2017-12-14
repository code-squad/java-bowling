package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {
	//생성자 테스트.
	@Test
	public void startFrameTest() {
		Frame frame = new Frame();
		
		assertEquals(1, frame.getFrameNum());
		assertEquals(10, frame.getPinNum());
	}

}
