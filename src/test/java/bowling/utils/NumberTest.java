package bowling.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import bowling.exception.BowlingGameException;

public class NumberTest {

	@Test
	public void 원시값_포장() throws BowlingGameException {
		UtilsNumber number = Utils.inputPlayerCount(8);
		assertThat(number.getPlayerCount(), is(8));
	}

}
