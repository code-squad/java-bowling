package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    private User testUser;

    @Before
    public void setUp() {
        testUser = User.of("testUser");
    }

    @Test
    public void user_should_have_RoundFrames_when_initialize() {
        Round testRound = Round.of();
        assertThat(testUser.getRound(), is(testRound));
    }

    @Test
    public void user_can_enter_score_on_roundFrames() {
        testUser.shot(6);
        testUser.shot(4);
        Round testRound = Round.of();
        testRound.trying(6);
        testRound.trying(4);
        assertThat(testUser.getRound(), is(testRound));
    }

}
