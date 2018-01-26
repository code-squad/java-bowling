package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FrameScoreTest {

    private Frame frame1;
    private Frame frame2;
    private Frame lastFrame;

    private FrameScore frameScore;
    private FrameScore lastFrameScore;

    @Before
    public void setup() {
        lastFrame = new LastFrame();
        frame2 = new Frame(lastFrame);
        frame1 = new Frame(frame2);

        frameScore = new FrameScore(frame1);
        lastFrameScore = new FrameScore(lastFrame);
    }

    @Test
    public void 스트라이크_점수계산() {
        frameScore.setPreviousFrameScore(0);
        frame1.add(DownPinCount.STRIKE);
        assertThat(frameScore.getScore().isPresent()).isFalse();
        frame2.add(DownPinCount.of(9));
        assertThat(frameScore.getScore().isPresent()).isFalse();
        frame2.add(DownPinCount.of(1));
        assertThat(frameScore.getScore().get()).isEqualTo(20);
    }

    @Test
    public void 터키_점수계산() {
        frameScore.setPreviousFrameScore(0);
        frame1.add(DownPinCount.STRIKE);
        assertThat(frameScore.getScore().isPresent()).isFalse();
        frame2.add(DownPinCount.STRIKE);
        assertThat(frameScore.getScore().isPresent()).isFalse();
        lastFrame.add(DownPinCount.STRIKE);
        assertThat(frameScore.getScore().isPresent()).isTrue();
        assertThat(frameScore.getScore().get()).isEqualTo(30);
    }

    @Test
    public void 스페어_점수계산() {
        frameScore.setPreviousFrameScore(0);
        frame1.add(DownPinCount.of(1));
        assertThat(frameScore.getScore().isPresent()).isFalse();
        frame1.add(DownPinCount.of(9));
        assertThat(frameScore.getScore().isPresent()).isFalse();
        frame2.add(DownPinCount.of(5));
        assertThat(frameScore.getScore().isPresent()).isTrue();
        assertThat(frameScore.getScore().get()).isEqualTo(15);
    }

    @Test
    public void 미스_점수계산() {
        frameScore.setPreviousFrameScore(0);
        frame1.add(DownPinCount.of(1));
        assertThat(frameScore.getScore().isPresent()).isFalse();
        frame1.add(DownPinCount.of(4));
        assertThat(frameScore.getScore().isPresent()).isTrue();
        assertThat(frameScore.getScore().get()).isEqualTo(5);
    }

    @Test
    public void 마지막프레임_터키() {
        lastFrameScore.setPreviousFrameScore(100);
        lastFrame.add(DownPinCount.STRIKE);
        assertThat(lastFrameScore.getScore().isPresent()).isFalse();
        lastFrame.add(DownPinCount.STRIKE);
        assertThat(lastFrameScore.getScore().isPresent()).isFalse();
        lastFrame.add(DownPinCount.STRIKE);
        assertThat(lastFrameScore.getScore().isPresent()).isTrue();
        assertThat(lastFrameScore.getScore().get()).isEqualTo(130);
    }

    @Test
    public void 마지막프레임_스페어() {
        lastFrameScore.setPreviousFrameScore(100);
        lastFrame.add(DownPinCount.of(8));
        assertThat(lastFrameScore.getScore().isPresent()).isFalse();
        lastFrame.add(DownPinCount.of(2));
        assertThat(lastFrameScore.getScore().isPresent()).isFalse();
        lastFrame.add(DownPinCount.of(5));
        assertThat(lastFrameScore.getScore().isPresent()).isTrue();
        assertThat(lastFrameScore.getScore().get()).isEqualTo(115);
    }

    @Test
    public void 마지막프레임_오픈() {
        lastFrameScore.setPreviousFrameScore(100);
        lastFrame.add(DownPinCount.of(0));
        assertThat(lastFrameScore.getScore().isPresent()).isFalse();
        lastFrame.add(DownPinCount.of(0));
        assertThat(lastFrameScore.getScore().isPresent()).isTrue();
        assertThat(lastFrameScore.getScore().get()).isEqualTo(100);
    }
}