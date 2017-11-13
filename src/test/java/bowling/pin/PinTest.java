package bowling.pin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bowling.user.User;

public class PinTest {

	@Test
	public void 사람이_공을_굴리면_핀이남는다() throws Exception {
		User user = User.create("wsh");
		Pin pin = user.bowl(9);
		assertEquals(pin, new Pin(9));
	}

}
