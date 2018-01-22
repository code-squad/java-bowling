package bowling.domain;

import bowling.enums.FrameStatus;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    private Player player;

    @Before
    public void init() {
        player = new Player("KKH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        new Player(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest2() {
        new Player("KK");
    }

    @Test
    public void getStateTest() {
        assertThat(player.getState()).isEqualTo(FrameStatus.NOT_START);
    }

    @Test
    public void inRoundEndTest() {
        assertThat(player.isCurrentFrameEnd()).isFalse();
        player.rollBowlingBall(new Pin(10));
        assertThat(player.isCurrentFrameEnd()).isTrue();
    }

    @Test
    public void rollBowlingBallTest() {
        //player.rollBowlingBall(new Pin(5));
    }
}
