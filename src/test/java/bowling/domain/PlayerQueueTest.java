package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerQueueTest {
    private PlayerQueue playerQueue;

    @Before
    public void init() {
        playerQueue = new PlayerQueue(Arrays.asList(
                new Player("KH1"),
                new Player("KH2"),
                new Player("KH3")
        ));
    }

    @Test
    public void getCurrentPlayerTest() {
        assertThat(playerQueue.getCurrentPlayer()).isEqualTo(new Player("KH1"));
    }

    @Test
    public void rotatePlayerTest() {
        playerQueue.rotate();
        assertThat(playerQueue.getCurrentPlayer()).isEqualTo(new Player("KH2"));
    }
}
