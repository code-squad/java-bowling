package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameScoreTest {

    @Test
    public void FinalScore_72() throws Exception {
        FinalFrameScore score = new FinalFrameScore(new Pin(7));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(2));
        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(9);
    }

    @Test
    public void FinalScore_735() throws Exception {
        FinalFrameScore score = new FinalFrameScore(new Pin(7));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(3));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(5));
        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(15);
    }

    @Test
    public void FinalScore_X82() throws Exception {
        FinalFrameScore score = new FinalFrameScore(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(8));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(2));
        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(20);
    }

    @Test
    public void FinalScore_XX2() throws Exception {
        FinalFrameScore score = new FinalFrameScore(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(2));
        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(22);
        assertThat(score.toString()).isEqualTo("X|X|2");
    }

    @Test
    public void FinalScore_XXX() throws Exception {
        FinalFrameScore score = new FinalFrameScore(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(10));
        assertThat(score.isFinish()).isFalse();

        score.addResult(new Pin(10));

        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(30);
        assertThat(score.toString()).isEqualTo("X|X|X");
    }

    @Test(expected = IllegalArgumentException.class)
    public void FinalScore_74() throws Exception {
        FinalFrameScore score = new FinalFrameScore(new Pin(7));
        score.addResult(new Pin(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void FinalScore_721() throws Exception {
        FinalFrameScore score = new FinalFrameScore(new Pin(7));
        score.addResult(new Pin(2));
        score.addResult(new Pin(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void FinalScore_X74() throws Exception {
        FinalFrameScore score = new FinalFrameScore(new Pin(10));
        score.addResult(new Pin(7));
        score.addResult(new Pin(4));
    }
}