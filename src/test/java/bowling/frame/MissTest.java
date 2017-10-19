package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

public class MissTest {

	@Test(expected = UnsupportedOperationException.class)
	public void bowl() {
		throw new UnsupportedOperationException();
	}

}
