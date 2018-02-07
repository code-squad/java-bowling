package domain.score;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MissTest {

    private State miss;

    @Before
    public void setUp() throws Exception {
        miss = new Miss(new Pin(5), new Pin(4));
    }

    @Test
    public void getTotalScore() throws Exception {
        assertThat(miss.getTotalScore().isPresent()).isTrue();
        assertThat(miss.getTotalScore().get()).isEqualTo(9);
    }

    @Test
    public void getTotalScore_다음상태가존재하는경우() throws Exception {
        miss.bowl(new Pin(7));
        assertThat(miss.getTotalScore().isPresent()).isTrue();
        assertThat(miss.getTotalScore().get()).isEqualTo(9);
    }
}