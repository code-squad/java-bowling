package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class PlayersTest {
    private Players players;

    @Before
    public void init() {
        players = new Players(Arrays.asList(
                new Player("KH1"),
                new Player("KH2"),
                new Player("KH3")
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        players = new Players(null);
    }
}
