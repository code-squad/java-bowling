package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest {

    private User testUser;

    @Before
    public void setUp() {
        testUser = User.of("testUser");
    }

    @Test
    public void user_should_have_RoundFrames_when_initialize() {
        RoundFrames testRoundFrames = new RoundFrames();
        assertThat(testUser.getRoundFrames(), is(testRoundFrames));
    }

    @Test
    public void user_can_enter_score_on_roundFrames() {
        testUser.shot(6);
        testUser.shot(4);
        RoundFrames testRoundFrames = new RoundFrames();
        testRoundFrames.lastFrameTry(6);
        testRoundFrames.lastFrameTry(4);
        assertThat(testUser.getRoundFrames(), is(testRoundFrames));
    }


}
