package domain;

import org.junit.Before;
import org.junit.Test;
import state.Strike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    private Player player;
    private Frames frames;

    @Before
    public void setUp() {
        player = new Player("htw");
    }

    @Test
    public void name() {
        assertEquals("htw", player.getName());
    }

    @Test
    public void bowl() {
        assertTrue(Strike.isStrike(player.bowl(new Pins(10))));
    }

    @Test
    public void isEnd() {
        player.bowl(new Pins(10));
        assertTrue(player.isEnd());
    }

    @Test
    public void getFinishedFrame() {
        player.bowl(new Pins(10));
        assertEquals(1, player.getFinishedFrame());
    }

    @Test
    public void saveFrameData() {
        while (!player.isEnd()) {
            player.bowl(new Pins(10));
        }
        player.saveFrameData();
    }

    @Test
    public void printPlayingFrameState() {
        player.bowl(new Pins(8));
        assertEquals("8", player.printPlayingFrameState());
    }
}
