import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrameTest {
	
	@Test
	public void makeScoreMarkTestWhenValueEmpty() {
		NormalFrame Frame = new NormalFrame(0);
		assertEquals("      |", Frame.makeScoreMark());
	}
		
	@Test
	public void makeFirstScoreMarkTestWhenValue10() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(10);
		assertEquals("     X|", Frame.makeFirstScoreMark());
	}
	
	@Test
	public void makeFirstScoreMarkTestWhenValue0() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(0);
		assertEquals("     -|", Frame.makeFirstScoreMark());
	}
	
	@Test
	public void makeFirstScoreMarkTestWhenValueNormal() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(7);
		assertEquals("     7|", Frame.makeFirstScoreMark());
	}
	
	
	@Test
	public void makeSecondScroeMarkTestWhenSum10() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(7);
		Frame.bowl(3);
		assertEquals("   7|/|", Frame.makeSecondScoreMark());
	}
	
	@Test
	public void makeSecondScroeMarkTestWhenValue0() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(7);
		Frame.bowl(0);
		assertEquals("   7|-|", Frame.makeSecondScoreMark());
	}
	
	@Test
	public void isEndedTestWhenValueNormal() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(3);
		assertEquals(false, Frame.isEnded());
	}
	
	@Test
	public void isEndedTestWhenNotEnded() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(7);
		assertEquals(false, Frame.isEnded());
	}
	
	@Test
	public void isEndedTestWhenValue10() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(10);
		assertEquals(true, Frame.isEnded());
	}
	
	@Test
	public void isEndedTestWhenValueSize2() {
		NormalFrame Frame = new NormalFrame(0);
		Frame.bowl(3);
		Frame.bowl(7);
		assertEquals(true, Frame.isEnded());
	}
}
