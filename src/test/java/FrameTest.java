
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrameTest {
	
	@Test
	public void makeScoreFristMarkTestWhenValueEmpty() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		assertEquals("      |", Frame.makeFristScoreMark(player));
	}
		
	@Test
	public void makeScoreFristMarkTestWhenValue10() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(10);
		assertEquals("  X   |", Frame.makeFristScoreMark(player));
	}
	
	@Test
	public void makeScoreFristMarkTestWhenValue0() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(0);
		assertEquals("  -   |", Frame.makeFristScoreMark(player));
	}
	
	@Test
	public void makeScoreFristMarkTestWhenValueNormal() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(7);
		assertEquals("  7   |", Frame.makeFristScoreMark(player));
	}
	
	
	@Test
	public void makeSecondScroeMarkTestWhenSum10() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(7);
		Frame.bowl(3);
		assertEquals("  7|/ |", Frame.makeFristScoreMark(player));
	}
	
	@Test
	public void makeSecondScroeMarkTestWhenValue0() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(7);
		Frame.bowl(0);
		assertEquals("  7|- |", Frame.makeFristScoreMark(player));
	}
	
	@Test
	public void isEndedTestWhenValueNormal() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(3);
		assertEquals(false, Frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenNotEnded() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(7);
		assertEquals(false, Frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenValue10() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(10);
		assertEquals(true, Frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenValueSize2() {
		Player player = new Player("pjs");
		Frame Frame = new Frame();
		Frame.bowl(3);
		Frame.bowl(7);
		assertEquals(true, Frame.isEnded(player));
	}
}
