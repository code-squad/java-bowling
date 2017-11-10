package bowling.user;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void 유저생성() {
		User user = User.of("wsh");
		assertEquals(user, User.of("wsh"));
	}

	@Test
	public void 유저이름확인() throws Exception {
		User user = User.of("wsh");
		assertEquals("wsh", user.printName());
	}

}
