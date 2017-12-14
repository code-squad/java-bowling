package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class InutViewTest {

	@Test
	public void inputNameTest() {
		String test = "KOO";
		assertEquals(test, InputView.getName());
	}

}
