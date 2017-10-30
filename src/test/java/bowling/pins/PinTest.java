package bowling.pins;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import bowling.exception.BowlingGameException;

public class PinTest {

	@Test
	public void 프레임의핀_생성() throws BowlingGameException {
		Pin pin = new Pin();
		assertThat(pin.getPins(), is(10));
		assertThat(pin.hitPins(5), is(5));
	}

}
