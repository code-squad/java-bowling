package bowling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author sangsik.kim
 */
public class GameResultTest {

    private Frame STRIKE_FRAME;

    @Before
    public void setUp() {
        this.STRIKE_FRAME = new NormalFrame(1);
        this.STRIKE_FRAME.bowl(10);
    }

    @Test
    public void add_one_element() {
        GameResult gameResult = new GameResult("kss");

        gameResult.addScore(STRIKE_FRAME.getScore());

        assertThat(gameResult.getScore(1), is("X"));
    }
}
