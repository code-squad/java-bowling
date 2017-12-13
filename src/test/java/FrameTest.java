

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrameTest {
	
	@Test
	public void makeScoreFristMarkTestWhenValueEmpty() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		assertEquals("      |", frame.makeFristScoreMark(player));
	}
		
	@Test
	public void makeScoreFristMarkTestWhenValue10() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(10);
		assertEquals("  X   |", frame.makeFristScoreMark(player));
	}
	
	@Test
	public void makeScoreFristMarkTestWhenValue0() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(0);
		assertEquals("  -   |", frame.makeFristScoreMark(player));
	}
	
	@Test
	public void makeScoreFristMarkTestWhenValueNormal() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(7);
		assertEquals("  7   |", frame.makeFristScoreMark(player));
	}
	
	
	@Test
	public void makeSecondScroeMarkTestWhenSum10() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(7);
		frame.bowl(3);
		assertEquals("  7|/ |", frame.makeFristScoreMark(player));
	}
	
	@Test
	public void makeSecondScroeMarkTestWhenValue0() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(7);
		frame.bowl(0);
		assertEquals("  7|- |", frame.makeFristScoreMark(player));
	}
	
	@Test
	public void makeThirdScroeMarkTestWhenValueNormal() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(1);
		frame.bowl(9);
		frame.bowl(4);
		assertEquals(" 1|/|4|", frame.makeFristScoreMark(player));
	}
	
	@Test
	public void makeThirdScroeMarkTestWhenValue() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(10);
		frame.bowl(10);
		frame.bowl(10);
		assertEquals(" X|X|X|", frame.makeFristScoreMark(player));
	}
	
	@Test
	public void isEndedTestWhenValueNormal() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(3);
		assertEquals(false, frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenNotEnded() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(7);
		assertEquals(false, frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenValue10() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(10);
		assertEquals(true, frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenValueSize2() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(3);
		frame.bowl(7);
		assertEquals(true, frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenValueSize3() {
		Player player = new Player("pjs");
		Frame frame = new Frame();
		frame.bowl(10);
		frame.bowl(7);
		frame.bowl(3);
		assertEquals(true, frame.isEnded(player));
	}
}
