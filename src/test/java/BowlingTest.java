import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Bowling;
import model.Frame;

public class BowlingTest {
	Bowling bowling;
	@Before
	public void setUp() {
		bowling = new Bowling();
	}
	@Test
	public void roll_strike() throws Exception { 
		List<Frame> result = bowling.roll(10);
		assertEquals("X", result);
	}
	@Test
	public void roll_spare() throws Exception {
		List<Frame> result = bowling.roll(9);
		assertTrue(result.size() == 1);
		
		List<Frame> result1 = bowling.roll(1);
		assertEquals(2, result1.size());

		
		List<Frame> result2 = bowling.roll(10);
		assertEquals(3, result2.size());
//		
//		List<String> results = bowling.getResults();
//		assertEquals("9", results.get(0));
//		assertEquals("9/", results.get(1));
//		assertTrue(results.size() == 3);
//		assertEquals("X", results.get(2));
	}
//	@Test
//	public void roll_miss() throws Exception {
//		String result = bowling.roll(8);
//		assertEquals("8", result);
//		
//		result = bowling.roll(0);
//		assertEquals("8-", result);
//		
//	}
	@Test
	public void rollTest() throws Exception {
		List<Frame> frames = bowling.roll(10);
		assertEquals(2, frames.size());
	}
	@Test
	public void 프레임_성_테스트() throws Exception {
		List<Frame> result = bowling.roll(10);
		assertEquals(1, result.size());
		
		List<Frame> result1 = bowling.roll(1);
		assertEquals(2, result1.size());
		assertEquals("X", bowling.getFrames().get(0).getScore().getResult());
		assertEquals("1", bowling.getFrames().get(1).getScore().getResult());

		List<Frame> result2 = bowling.roll(9);
		assertEquals(3, result2.size());
		assertEquals("X", bowling.getFrames().get(0).getScore().getResult());
		assertEquals("1", bowling.getFrames().get(1).getScore().getResult());
		assertEquals("1|/", bowling.getFrames().get(2).getScore().getResult());

	}
	@Test
	public void 프레임생성테스트() throws Exception {
		int[] falledPinsArray = {10};
		bowling.createFrames(falledPinsArray, Bowling.count);
		assertEquals("X", firstFrame.getScore().getResult());
	}
	
	
	
}
