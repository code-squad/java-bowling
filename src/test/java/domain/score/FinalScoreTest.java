package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalScoreTest {

    @Test
    public void FinalScore_72() throws Exception {
        FinalScore score = new FinalScore(new Pin(7));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isFalse();
        assertThat(score.getFirstScore()).isEqualTo(7);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(2));

        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(9);
        assertThat(score.isStrike()).isFalse();
        assertThat(score.getFirstScore()).isEqualTo(7);
        assertThat(score.getSumOfScore().isPresent()).isTrue();
        assertThat(score.getSumOfScore().get()).isEqualTo(9);

        assertThat(score.toString()).isEqualTo("7|2| ");
    }

    @Test
    public void FinalScore_735() throws Exception {
        FinalScore score = new FinalScore(new Pin(7));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isFalse();
        assertThat(score.getFirstScore()).isEqualTo(7);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(3));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isFalse();
        assertThat(score.getFirstScore()).isEqualTo(7);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(5));

        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(15);
        assertThat(score.isStrike()).isFalse();
        assertThat(score.getFirstScore()).isEqualTo(7);
        assertThat(score.getSumOfScore().isPresent()).isTrue();
        assertThat(score.getSumOfScore().get()).isEqualTo(15);
        assertThat(score.toString()).isEqualTo("7|3|5");
    }

    @Test
    public void FinalScore_X82() throws Exception {
        FinalScore score = new FinalScore(new Pin(10));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(8));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(2));

        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(20);
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isTrue();
        assertThat(score.getSumOfScore().get()).isEqualTo(20);
        assertThat(score.toString()).isEqualTo("X|8|2");
    }

    @Test
    public void FinalScore_XX2() throws Exception {
        FinalScore score = new FinalScore(new Pin(10));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(10));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(2));

        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(22);
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isTrue();
        assertThat(score.getSumOfScore().get()).isEqualTo(22);
        assertThat(score.toString()).isEqualTo("X|X|2");
    }

    @Test
    public void FinalScore_XXX() throws Exception {
        FinalScore score = new FinalScore(new Pin(10));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(10));

        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isFalse();

        score.addResult(new Pin(10));

        assertThat(score.isFinish()).isTrue();
        assertThat(score.getFrameScore().isPresent()).isTrue();
        assertThat(score.getFrameScore().get()).isEqualTo(30);
        assertThat(score.isStrike()).isTrue();
        assertThat(score.getFirstScore()).isEqualTo(10);
        assertThat(score.getSumOfScore().isPresent()).isTrue();
        assertThat(score.getSumOfScore().get()).isEqualTo(30);
        assertThat(score.toString()).isEqualTo("X|X|X");
    }
}