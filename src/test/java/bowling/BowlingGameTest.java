package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void 이름_구분() {
		BowlingGame bowlingGame = new BowlingGame();
		String s = "dfksjdgl sdf,gbsdk dfgsdfgs,dfgsd";
		String[] test = s.split(" |\\,");
		assertEquals(5, test.length);
	}

}
