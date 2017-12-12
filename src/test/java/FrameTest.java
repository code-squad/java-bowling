
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrameTest {
		
	@Test
	public void makeScoreFristMarkTestWhenValue10() {
		Frame frame = new Frame();
		frame.getPinsPerFrame().add(10);
		assertEquals("  X   |", frame.makeFristScoreMark());
	}
	
	@Test
	public void makeScoreFristMarkTestWhenValue0() {
		Frame frame = new Frame();
		frame.getPinsPerFrame().add(0);
		assertEquals("  -   |", frame.makeFristScoreMark());
	}
	
	@Test
	public void makeScoreFristMarkTestWhenValueNormal() {
		Frame frame = new Frame();
		frame.getPinsPerFrame().add(7);
		assertEquals("  7   |", frame.makeFristScoreMark());
	}
	
	
	@Test
	public void makeSecondScroeMarkTestWhenSum10() {
		Frame frame = new Frame();
		frame.getPinsPerFrame().add(7);
		frame.getPinsPerFrame().add(3);
		assertEquals("  7|/ |", frame.makeFristScoreMark());
	}
	
	@Test
	public void makeSecondScroeMarkTestWhenValue0() {
		Frame frame = new Frame();
		frame.getPinsPerFrame().add(7);
		frame.getPinsPerFrame().add(0);
		assertEquals("  7|- |", frame.makeFristScoreMark());
	}
}
