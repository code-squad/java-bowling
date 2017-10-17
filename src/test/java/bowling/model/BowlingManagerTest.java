package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingManagerTest {
	
	@Test
	public void 라운드가_종료_조건이_잘_바뀌나_보자() {
		BowlingManager bm = new BowlingManager();
		bm.initPlayer("lhs");
		for(int i =0; i < 12; i++) {
			bm.inputKnockedPins("2");
		}
		assertFalse(bm.isEndGame());
		
		for(int i =0; i < 8; i++) {
			bm.inputKnockedPins("3");
		}
		assertTrue(bm.isEndGame());
	}

}
