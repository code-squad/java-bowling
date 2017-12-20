package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static bowling.Status.SPARE;
import static bowling.Status.STRIKE;
import static bowling.Status.MISSORNORMAL;
import static bowling.Status.READY;

public class FinalFrameTest {
	private FinalFrame finalFrame;
	
	@Before
	public void setUp(){
		finalFrame = new FinalFrame();
	}


		@Test
		public void finalFrameStrike() {
			finalFrame.addScore(10);
			assertEquals(true, finalFrame.isNotEnd());
			assertEquals(STRIKE, finalFrame.getStatus());
			finalFrame.addScore(7);
			assertEquals(true, finalFrame.isNotEnd());
			finalFrame.addScore(10);
			assertEquals(false, finalFrame.isNotEnd());
			assertEquals(null, finalFrame.getStatus());
		}

		@Test
		public void finalFrameSpare() {
			finalFrame.addScore(6);
			finalFrame.addScore(4);
			assertEquals(true, finalFrame.isNotEnd());
			assertEquals(SPARE, finalFrame.getStatus());
			finalFrame.addScore(2);
			assertEquals(false, finalFrame.isNotEnd());
			assertEquals(null, finalFrame.getStatus());
			
		}
		
		@Test
		public void finalFrameMissOrNormal() {
			finalFrame.addScore(3);
			assertEquals(true, finalFrame.isNotEnd());
			finalFrame.addScore(0);
			assertEquals(false, finalFrame.isNotEnd());
			assertEquals(MISSORNORMAL, finalFrame.getStatus());
			
			
		}
	
	}


