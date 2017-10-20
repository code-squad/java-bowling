package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class MissTest {

	@Test(expected = UnsupportedOperationException.class)
	public void bowl() {
		throw new UnsupportedOperationException();
	}

}
