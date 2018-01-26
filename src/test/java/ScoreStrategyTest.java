import model.Frame;
import model.NormalFrame;
import model.Score;
import model.ScoreStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreStrategyTest {

    private ScoreStrategy scoreStrategy;

    @Before
    public void setUp(){
        scoreStrategy = new ScoreStrategy();
    }

    @Test
    public void calculateNextTrial(){
        assertThat(scoreStrategy.calculateNextTrial(Score.STRIKE)).isEqualTo(2);
    }

    @Test
    public void hasMoreNextTrial(){
        assertThat(scoreStrategy.hasMoreNextTrial()).isTrue();
    }

    @Test
    public void calculateUtilNow(){
        Frame frame = new NormalFrame();
        frame.obtainScore(10);

        assertThat(scoreStrategy.calculateUtilNow(frame));
    }

    @Test
    public void stillCanCalculate(){
        assertThat(scoreStrategy.stillCanCalculate()).isFalse();
    }

    @Test
    public void hasNotEmptyQueue(){
        assertThat(scoreStrategy.hasNotEmptyQueue()).isFalse();
    }
}
