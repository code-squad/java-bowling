package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FramesTest {
    private Frames frames;

    @Before
    public void setUp() throws Exception {
        frames = new Frames();
    }

    @Test
    public void marking() {
        frames.marking(10);
        assertThat(frames.size()).isEqualTo(2);

        frames.marking(1);
        assertThat(frames.size()).isEqualTo(2);

        frames.marking(9);
        assertThat(frames.size()).isEqualTo(3);

        frames.marking(2);
        assertThat(frames.size()).isEqualTo(3);

        frames.marking(0);
        assertThat(frames.size()).isEqualTo(4);
    }

    @Test
    public void isLast() {
        frames.marking(2);
        frames.marking(7);
        assertThat(frames.isLast()).isFalse();
    }

    @Test
    public void isLast_10회_스트라이크() {
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);

        frames.marking(10);

        frames.marking(10);
        assertThat(frames.isLast()).isFalse();
        frames.marking(10);
        assertThat(frames.isLast()).isTrue();

    }

    @Test
    public void isLast_10회_스페어() {
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);
        frames.marking(10);

        frames.marking(8);
        assertThat(frames.isLast()).isFalse();
        frames.marking(2);
        assertThat(frames.isLast()).isFalse();
        frames.marking(5);
        assertThat(frames.isLast()).isTrue();
    }
}