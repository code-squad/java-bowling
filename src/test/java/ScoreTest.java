import model.Score;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    public void value() {
        assertThat(Score.valueOf(3, 10)).isEqualTo(Score.THREE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void value2() {
        Score.valueOf(11, 10);
    }

    @Test
    public void value3() {
        assertThat(Score.valueOf(10, 10)).isEqualTo(Score.STRIKE);
    }

    @Test
    public void value4() {
        assertThat(Score.valueOf(4, 4)).isEqualTo(Score.SPARE);
    }

    @Test
    public void value5() {
        assertThat(Score.valueOf(0, 10)).isEqualTo(Score.GUTTER);
    }
}
