package domain.score;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StrikeTest {

    private State strike;

    @Before
    public void setUp() throws Exception {
        strike = new Strike();
    }

    @Test
    public void toString_STRIKE() throws Exception {
        assertThat(strike.toString()).isEqualTo("X");
    }

    @Test
    public void getTotalScore_XXX() {
        State next = strike.bowl(Pin.TEN);
        next.bowl(Pin.TEN);
        assertThat(strike.getTotalScore().isPresent()).isTrue();
        assertThat(strike.getTotalScore().get()).isEqualTo(30);
    }

    @Test
    public void getTotalScore_SPARE() {
        State next = strike.bowl(new Pin(3));
        next.bowl(new Pin(7));
        assertThat(strike.getTotalScore().isPresent()).isTrue();
        assertThat(strike.getTotalScore().get()).isEqualTo(20);
    }

    @Test
    public void getTotalScore_MISS() {
        State next = strike.bowl(new Pin(3));
        next.bowl(new Pin(2));
        assertThat(strike.getTotalScore().isPresent()).isTrue();
        assertThat(strike.getTotalScore().get()).isEqualTo(15);
    }

    @Test
    public void getTotalScore_XX() {
        State next = strike.bowl(Pin.TEN);
        assertThat(strike.getTotalScore().isPresent()).isFalse();
    }
}