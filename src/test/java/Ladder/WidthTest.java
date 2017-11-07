package Ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class WidthTest {

	@Test
	public void 옆칸_생성() {
		Width width = new Width(0);
		assertEquals(width, new Width(0));
	}

}
