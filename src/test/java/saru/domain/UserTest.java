package saru.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void 유저테스트() {
        User user = User.of("ABC");
        assertEquals("ABC", user.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유저테스트에러() {
        User.of("ABCD");
    }
}
