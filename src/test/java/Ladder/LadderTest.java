package Ladder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LadderTest {

	@Test
	public void 사다리생성() {
		Ladder ladder = new Ladder(0, "wsh");
		assertEquals(ladder.getLeft(), new Width());

		System.out.println(ladder.getLeft());
	}

}
