import model.Frame;
import model.NormalFrame;
import model.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    private Frame frame;

    @Before
    public void setUp() {
        frame = new NormalFrame();
    }

    @Test
    public void obtainScore() {
        assertThat(frame.obtainScore(3)).isInstanceOf(Score.class);
    }

    @Test
    public void isItOverAndHasNextFrame() {
        frame.obtainScore(2);
        assertThat(frame.isItOverAndHasNextFrame()).isFalse();
    }

    @Test
    public void isDone() {
        assertThat(frame.isDone()).isFalse();
    }

    @Test
    public void addFirstAndSecond(){
        frame.obtainScore(2);
        frame.obtainScore(2);

        assertThat(frame.addFirstAndSecond()).isEqualTo(4);
    }

    @Test
    public void hasAllScore(){
        frame.obtainScore(2);
        frame.obtainScore(2);

        assertThat(frame.hasAllScore()).isEqualTo(true);
    }

    @Test
    public void addOnlyFirst(){
        frame.obtainScore(2);

        assertThat(frame.addOnlyFirst()).isEqualTo(2);
    }

    @Test
    public void hasStrikeOrSpare(){
        frame.obtainScore(10);

        assertThat(frame.hasStrikeOrSpare()).isEqualTo(true);
    }

    @Test
    public void calculateLast(){
        frame.obtainScore(2);
        frame.obtainScore(2);

        assertThat(frame.calculateLast()).isEqualTo(4);
    }

    @Test
    public void hasAnyScore(){
        assertThat(frame.hasAnyScore()).isEqualTo(false);
    }
}
