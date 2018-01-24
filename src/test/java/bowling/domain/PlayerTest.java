package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static bowling.enums.FrameStatus.*;
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
        assertThat(player.getState()).isEqualTo(NOT_END);
    }

    @Test
    public void inRoundEndTest() {
        assertThat(player.isCurrentFrameEnd()).isFalse();
        player.rollBowlingBall(new Pin(10));
        assertThat(player.isCurrentFrameEnd()).isTrue();
    }

    @Test
    public void frameNoUpdateTest() {
        player.rollBowlingBall(new Pin(10));
        player.frameNoUpdate();
        assertThat(player.getState()).isEqualTo(NOT_END);
    }

    @Test
    public void getPreviousTest() {
        player.rollBowlingBall(new Pin(10));
        player.frameNoUpdate();
        assertThat(player.getPreviousState()).isEqualTo(STRIKE);
        assertThat(player.getState()).isEqualTo(NOT_END);
    }

    @Test
    public void rollBowlingBallTest() {
        player.rollBowlingBall(new Pin(5));
        assertThat(player.getState()).isEqualTo(NOT_END);
        player.rollBowlingBall(new Pin(5));
        assertThat(player.getState()).isEqualTo(SPARE);
    }
}
