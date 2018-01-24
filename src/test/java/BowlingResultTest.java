import model.BowlingGame;
import model.BowlingResult;
import model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingResultTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame(new Player("CJH"));
    }

    @Test
    public void getResult() {
        bowlingGame.progressGame(3);
//        List<String> result = BowlingResult.getResult(bowlingGame);
//        assertThat(result.get(0)).isEqualTo("3   ");
    }
}
