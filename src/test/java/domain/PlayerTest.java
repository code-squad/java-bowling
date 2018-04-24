package domain;

import org.junit.Before;
import org.junit.Test;
import state.Strike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    Player player;
    Frames frames;

    @Before
    public void setUp() {
        player = new Player("htw");
    }


    @Test
    public void name() {
        assertEquals("htw", player.printName());
    }

    @Test
    public void bowl() {
        assertTrue(Strike.isStrike(player.bowl(10)));
    }

    @Test
    public void isEnd() {
        player.bowl(10);
        assertTrue(player.isEnd());
    }

    @Test
    public void getFinishedFrame() {
        player.bowl(10);
        if (player.isEnd()) {
            player.saveFrameData();
        }
        assertEquals(1, player.getFinishedFrame());
    }

    @Test
    public void saveFrameData() {
        while (!player.isEnd()) {
            player.bowl(10);
        }
        player.saveFrameData();
    }

    @Test
    public void printPlayingFrameState() {
        player.bowl(8);
        assertEquals("8", player.printPlayingFrameState());
    }
}
