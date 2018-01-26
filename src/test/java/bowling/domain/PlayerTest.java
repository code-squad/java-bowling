package bowling.domain;

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
    public void inRoundEndTest() {
        assertThat(player.isCurrentFrameEnd()).isFalse();
        player.rollBowlingBall(10);
        assertThat(player.isCurrentFrameEnd()).isTrue();
    }

    @Test
    public void frameNoUpdateTest() {
        player.rollBowlingBall(10);
        player.frameNoUpdate();
        assertThat(player.isCurrentFrameEnd()).isFalse();
    }

    @Test
    public void rollBowlingBallTest() {
        player.rollBowlingBall(5);
        assertThat(player.isCurrentFrameEnd()).isFalse();
        player.rollBowlingBall(5);
        assertThat(player.isCurrentFrameEnd()).isTrue();
    }
}
