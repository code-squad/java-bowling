package bowling.domain;

import org.junit.Before;
import org.junit.Test;

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
}
