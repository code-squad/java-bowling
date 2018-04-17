package domain.player;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class PlayersTest {
    private Players players;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("pjh");
        player2 = new Player("col");
        players = new Players(new LinkedList<>(Arrays.asList(player1, player2)));
    }

    @Test
    public void 현재플레이어() {
        players.roll(10);
        assertEquals(player2, players.getCurrentPlayer());
    }

    @Test
    public void 현재플레이어2() {
        players.roll(10);
        players.roll(10);
        assertEquals(player1, players.getCurrentPlayer());
    }

    @Test
    public void 현재플레이어3() {
        players.roll(10);
        players.roll(5);
        assertEquals(player2, players.getCurrentPlayer());
    }
}