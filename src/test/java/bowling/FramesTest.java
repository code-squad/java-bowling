package bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FramesTest {
	
	Frames frames = new Frames();
	Frame frame = new Frame();
	
	@Before
	public void setUp(){
		frames = new Frames();
		frame = new Frame();
	}
	
	@Test
	public void addFrameTest() {
		frames.addFrame(frame);
		
		assertEquals(1, frames.countFrame());
	}
	
	@Test
	public void isGameEndTest() {
		assertEquals(true, frames.isGameEnd());
		
		for (int i = 0; i < 10; i++) {
			frames.addFrame(frame);
		}
		
		assertEquals(false, frames.isGameEnd());
	}
	
	@Test
	public void countFramesTest() {
		frames.addFrame(frame);
	}
}