package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LastFrameTest {

    private LastFrame lastFrame;

    @Before
    public void setup() {
        lastFrame = new LastFrame();
    }

    @Test
    public void 오픈된상태_두번_투구() {
        lastFrame.add(DownPinCount.of(8));
        assertThat(lastFrame.isEnd()).isEqualTo(false);
        lastFrame.add(DownPinCount.of(1));
        assertThat(lastFrame.isEnd()).isEqualTo(true);
    }

    @Test
    public void 스페어_이후_세번째_투구() {
        lastFrame.add(DownPinCount.of(8));
        assertThat(lastFrame.isEnd()).isEqualTo(false);
        lastFrame.add(DownPinCount.of(2));
        assertThat(lastFrame.isEnd()).isEqualTo(false);
        lastFrame.add(DownPinCount.STRIKE);
        assertThat(lastFrame.isEnd()).isEqualTo(true);
    }

    @Test
    public void 스트라이크_이후_세번째_투구() {
        lastFrame.add(DownPinCount.STRIKE);
        assertThat(lastFrame.isEnd()).isEqualTo(false);
        lastFrame.add(DownPinCount.of(8));
        assertThat(lastFrame.isEnd()).isEqualTo(false);
        lastFrame.add(DownPinCount.of(2));
        assertThat(lastFrame.isEnd()).isEqualTo(true);
    }

    @Test
    public void 스트라이크아웃() {
        lastFrame.add(DownPinCount.STRIKE);
        lastFrame.add(DownPinCount.STRIKE);
        lastFrame.add(DownPinCount.STRIKE);
        assertThat(lastFrame.getFrameInfo()).isEqualTo("X|X|X");
    }

    @Test
    public void 두번째_투구_스페어() {
        lastFrame.add(DownPinCount.STRIKE);
        lastFrame.add(DownPinCount.of(0));
        assertThat(lastFrame.getFrameInfo().endsWith("/")).isFalse();

        lastFrame = new LastFrame();
        lastFrame.add(DownPinCount.of(8));
        lastFrame.add(DownPinCount.of(2));
        assertThat(lastFrame.getFrameInfo().endsWith("/")).isTrue();
    }

    @Test
    public void 세번째_투구_스페어() {
        lastFrame.add(DownPinCount.STRIKE);
        lastFrame.add(DownPinCount.STRIKE);
        lastFrame.add(DownPinCount.of(0));
        assertThat(lastFrame.getFrameInfo().endsWith("/")).isFalse();

        lastFrame = new LastFrame();
        lastFrame.add(DownPinCount.STRIKE);
        lastFrame.add(DownPinCount.of(8));
        lastFrame.add(DownPinCount.of(2));
        assertThat(lastFrame.getFrameInfo().endsWith("/")).isTrue();
    }
}