import model.BowlingGame;
import model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {
    private Player player;
    private BowlingGame bowlingGame;

    @Before
    public void setUp(){
        player = new Player("CJH");
        bowlingGame = new BowlingGame(player);
    }

    @Test
    public void bowlingGameInit(){
    }
}
