package bowling.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void 첫_투구에서_최고_득점() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.shot(10);

        assertThat(normalFrame.toString())
                .isEqualTo("X");
    }

    @Test
    public void 스페어_득점() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.shot(0)
                .shot(10);

        assertThat(normalFrame.toString())
                .isEqualTo("-|/");
    }

    @Test
    public void 미스_점수() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.shot(0)
                .shot(9);

        assertThat(normalFrame.toString())
                .isEqualTo("-|9");
    }

    @Test
    public void 거터() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.shot(0)
                .shot(0);

        assertThat(normalFrame.toString())
                .isEqualTo("-|-");
    }

    @Test
    public void 이터레이터_패턴_적용() {
        NormalFrame normalFrame = new NormalFrame();

        Iterator frame = normalFrame.iterator();
        while (frame.hasNext()) {
            ((NormalFrame)frame.next()).shot(1);
        }

        assertThat(normalFrame.toString())
                .isEqualTo("1|1");
    }

    @Test
    public void 스트라이크_스코어() {
        NormalFrame normalFrame = new NormalFrame();
    }
}