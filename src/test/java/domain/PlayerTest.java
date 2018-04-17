package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void name() {
        Player player = new Player("htw");
        assertEquals("htw", player.getName());
    }
}
