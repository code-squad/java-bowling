import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTenTest {
	
	@Test
	public void makeThirdScroeMarkTestWhenValueNormal() {
		Player player = new Player("pjs");
		FrameTen FrameTen = new FrameTen();
		FrameTen.bowl(1);
		FrameTen.bowl(9);
		FrameTen.bowl(4);
		assertEquals(" 1|/|4|", FrameTen.makeFristScoreMark(player));
	}
	
	@Test
	public void makeThirdScroeMarkTestWhenValue10() {
		Player player = new Player("pjs");
		FrameTen FrameTen = new FrameTen();
		FrameTen.bowl(10);
		FrameTen.bowl(10);
		FrameTen.bowl(10);
		assertEquals(" X|X|X|", FrameTen.makeFristScoreMark(player));
	}

	@Test
	public void isEndedTestWhenValueSize3() {
		Player player = new Player("pjs");
		FrameTen FrameTen = new FrameTen();
		FrameTen.bowl(10);
		FrameTen.bowl(7);
		FrameTen.bowl(3);
		assertEquals(true, FrameTen.isEnded(player));
	}
}
