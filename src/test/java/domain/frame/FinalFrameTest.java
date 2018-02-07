package domain.frame;

import domain.score.Pin;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameTest {

    @Test
    public void FinalScore_72() throws Exception {
        FinalFrame score = new FinalFrame(new Pin(7));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(2));
        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(9);
        assertThat(score.toString()).isEqualTo("7|2");
    }

    @Test
    public void FinalScore_735() throws Exception {
        FinalFrame score = new FinalFrame(new Pin(7));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(3));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(5));
        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(15);
        assertThat(score.toString()).isEqualTo("7|/|5");
    }

    @Test
    public void FinalScore_X82() throws Exception {
        FinalFrame score = new FinalFrame(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(8));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(2));
        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(20);
        assertThat(score.toString()).isEqualTo("X|8|2");
    }

    @Test
    public void FinalScore_XX2() throws Exception {
        FinalFrame score = new FinalFrame(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(2));
        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(22);
        assertThat(score.toString()).isEqualTo("X|X|2");
    }

    @Test
    public void FinalScore_XXX() throws Exception {
        FinalFrame score = new FinalFrame(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.bowl(new Pin(10));

        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(30);
        assertThat(score.toString()).isEqualTo("X|X|10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void FinalScore_74() throws Exception {
        FinalFrame score = new FinalFrame(new Pin(7));
        score.bowl(new Pin(4));
    }

    @Test(expected = IllegalStateException.class)
    public void FinalScore_721() throws Exception {
        FinalFrame score = new FinalFrame(new Pin(7));
        score.bowl(new Pin(2));
        score.bowl(new Pin(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void FinalScore_X74() throws Exception {
        FinalFrame score = new FinalFrame(new Pin(10));
        score.bowl(new Pin(7));
        score.bowl(new Pin(4));
    }
}