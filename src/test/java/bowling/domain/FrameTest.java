package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    private Frame frame;

    @Before
    public void setup() {
        frame = new Frame(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 스페어이상의값추가() {
        frame.add(DownPinCount.of(5));
        frame.add(DownPinCount.of(6));
    }

    @Test
    public void 프레임종료_오픈() {
        frame.add(DownPinCount.of(5));
        assertThat(frame.isEndFrame()).isEqualTo(false);
        frame.add(DownPinCount.of(4));
        assertThat(frame.getTotalDownPinCount()).isEqualTo(9);
        assertThat(frame.isEndFrame()).isEqualTo(true);
    }

    @Test
    public void 프레임종료_스페어() {
        frame.add(DownPinCount.of(5));
        assertThat(frame.isEndFrame()).isEqualTo(false);
        frame.add(DownPinCount.of(5));
        assertThat(frame.getTotalDownPinCount()).isEqualTo(10);
        assertThat(frame.isEndFrame()).isEqualTo(true);
    }

    @Test
    public void 프레임종료_스트라이크() {
        frame.add(DownPinCount.STRIKE);
        assertThat(frame.isEndFrame()).isEqualTo(true);
    }

    @Test
    public void 프레임정보_오픈() {
        frame.add(DownPinCount.of(5));
        assertThat(frame.getFrameInfo()).isEqualTo("5");
        frame.add(DownPinCount.of(4));
        assertThat(frame.getFrameInfo()).isEqualTo("5|4");
    }

    @Test
    public void 프레임정보_거터_미스() {
        frame.add(DownPinCount.of(0));
        assertThat(frame.getFrameInfo()).isEqualTo("-");
        frame.add(DownPinCount.of(0));
        assertThat(frame.getFrameInfo()).isEqualTo("-|-");
    }

    @Test
    public void 프레임정보_스페어() {
        frame.add(DownPinCount.of(5));
        frame.add(DownPinCount.of(5));
        assertThat(frame.getFrameInfo().endsWith("/")).isTrue();
    }

    @Test
    public void 프레임정보_스트라이크() {
        frame.add(DownPinCount.STRIKE);
        assertThat(frame.getFrameInfo()).isEqualTo("X");
    }
}