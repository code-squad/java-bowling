
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrameTest {
	
	@Test
	public void makeScoreMarkTestWhenValueEmpty() {
		Player player = new Player("pjs");
		Frame Frame = new Frame(0);
		assertEquals("      |", Frame.makeScoreMark(player));
	}
		
	@Test
	public void makeFirstScoreMarkTestWhenValue10() {
		Frame Frame = new Frame(0);
		Frame.bowl(10);
		assertEquals("     X|", Frame.makeFirstScoreMark());
	}
	
	@Test
	public void makeFirstScoreMarkTestWhenValue0() {
		Frame Frame = new Frame(0);
		Frame.bowl(0);
		assertEquals("     -|", Frame.makeFirstScoreMark());
	}
	
	@Test
	public void makeFirstScoreMarkTestWhenValueNormal() {
		Frame Frame = new Frame(0);
		Frame.bowl(7);
		assertEquals("     7|", Frame.makeFirstScoreMark());
	}
	
	
	@Test
	public void makeSecondScroeMarkTestWhenSum10() {
		Frame Frame = new Frame(0);
		Frame.bowl(7);
		Frame.bowl(3);
		assertEquals("   7|/|", Frame.makeSecondScoreMark());
	}
	
	@Test
	public void makeSecondScroeMarkTestWhenValue0() {
		Frame Frame = new Frame(0);
		Frame.bowl(7);
		Frame.bowl(0);
		assertEquals("   7|-|", Frame.makeSecondScoreMark());
	}
	
	@Test
	public void isEndedTestWhenValueNormal() {
		Player player = new Player("pjs");
		Frame Frame = new Frame(0);
		Frame.bowl(3);
		assertEquals(false, Frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenNotEnded() {
		Player player = new Player("pjs");
		Frame Frame = new Frame(0);
		Frame.bowl(7);
		assertEquals(false, Frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenValue10() {
		Player player = new Player("pjs");
		Frame Frame = new Frame(0);
		Frame.bowl(10);
		assertEquals(true, Frame.isEnded(player));
	}
	
	@Test
	public void isEndedTestWhenValueSize2() {
		Player player = new Player("pjs");
		Frame Frame = new Frame(0);
		Frame.bowl(3);
		Frame.bowl(7);
		assertEquals(true, Frame.isEnded(player));
	}
}
