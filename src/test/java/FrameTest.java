
<<<<<<< HEAD


=======
>>>>>>> jongsoopark1
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import hoho2.Frame;

public class FrameTest {
	
	@Test
	public void makeScoreMarkTestWhenValueEmpty() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		assertEquals("      |", Frame.makeScoreMark());
	}
		
	@Test
	public void makeFirstScoreMarkTestWhenValue10() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(10);
		assertEquals("     X|", Frame.makeFirstScoreMark());
	}
	
	@Test
	public void makeFirstScoreMarkTestWhenValue0() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(0);
		assertEquals("     -|", Frame.makeFirstScoreMark());
	}
	
	@Test
	public void makeFirstScoreMarkTestWhenValueNormal() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(7);
		assertEquals("     7|", Frame.makeFirstScoreMark());
	}
	
	
	@Test
	public void makeSecondScroeMarkTestWhenSum10() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(7);
		Frame.bowl(3);
		assertEquals("   7|/|", Frame.makeSecondScoreMark());
	}
	
	@Test
	public void makeSecondScroeMarkTestWhenValue0() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(7);
		Frame.bowl(0);
		assertEquals("   7|-|", Frame.makeSecondScoreMark());
	}
	
	@Test
	public void isEndedTestWhenValueNormal() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(3);
		assertEquals(false, Frame.isEnded());
	}
	
	@Test
	public void isEndedTestWhenNotEnded() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(7);
		assertEquals(false, Frame.isEnded());
	}
	
	@Test
	public void isEndedTestWhenValue10() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(10);
		assertEquals(true, Frame.isEnded());
	}
	
	@Test
	public void isEndedTestWhenValueSize2() {
<<<<<<< HEAD
		NormalFrame Frame = new NormalFrame(0);
=======
		Frame Frame = new Frame(0);
>>>>>>> jongsoopark1
		Frame.bowl(3);
		Frame.bowl(7);
		assertEquals(true, Frame.isEnded());
	}
}
