package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ReadyTest {
    @Test
    public void bowl_스트라이크() throws Exception {
        State state = Ready.getInstance().bowl(Pin.TEN);
        assertThat(state.getType() == PinType.STRIKE).isTrue();
    }

    @Test
    public void bowl_스트라이크가아닌경우() throws Exception {
        State state = Ready.getInstance().bowl(new Pin(7));
        assertThat(state.getType() == PinType.NOT_FINISH).isTrue();
    }
}