package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {
    private Frame frame;

    @Before
    public void setUp() throws Exception {
        frame = new Frame();
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate() {
        frame.marking(2);
        frame.marking(9);
    }

    @Test
    public void hasNext_스트라이크() {
        frame.marking(10);
        assertThat(frame.hasNext()).isFalse();
    }

    @Test
    public void hasNext_스코어_0개() {
        assertThat(frame.hasNext()).isTrue();
    }

    @Test
    public void hasNext_스코어_1개() {
        frame.marking(0);
        assertThat(frame.hasNext()).isTrue();

    }

    @Test
    public void hasNext_스코어_2개() {
        frame.marking(0);
        assertThat(frame.hasNext()).isTrue();

        frame.marking(8);
        assertThat(frame.hasNext()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void marking_스코어_3개() {
        frame.marking(1);
        frame.marking(2);
        frame.marking(3);
    }

    @Test
    public void result_스트라이크() {
        frame.marking(10);
        assertThat(frame.result()).isEqualTo("X");

    }

    @Test
    public void result_거터() {
        frame.marking(0);
        assertThat(frame.result()).isEqualTo("-");
    }

    @Test
    public void result_스페어() {
        frame.marking(2);
        frame.marking(8);
        assertThat(frame.result()).isEqualTo("2|/");
    }
}