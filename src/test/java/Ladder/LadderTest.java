package Ladder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LadderTest {

	final private String newLine = System.getProperty("line.separator");

	@Test
	public void 사다리생성() {
		Ladder ladder = new Ladder(0, "wsh");
		Ladders ladders = new Ladders();
		ladders.create(4);
		assertEquals(ladder, new Ladder(0, "wsh"));
		assertEquals("|-----" + newLine + "|" + newLine + "|-----" + newLine + "|" + newLine + "wsh", ladders.show());
	}

}
