package bowling.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {

	@Test
	public void 유저생성() {
		User user = User.create("wsh");
		assertEquals(user, User.create("wsh"));
	}

	@Test
	public void 유저이름확인() throws Exception {
		User user = User.create("wsh");
		assertEquals("wsh", user.printName());
	}
}
