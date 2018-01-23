package bowling.model;

import bowling.model.score.MissScore;
import bowling.model.score.Score;
import bowling.model.score.SpareScore;
import bowling.model.score.StrikeScore;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ScoreTest {

	@Test
	public void 미스_현재점수_계산() {
		Score score = new MissScore(8, 1);
		assertThat(score.currentScore()).isEqualTo(9);
	}

	@Test
	public void 미스_현재점수_보기() {
		assertThat(Score.convertString(Arrays.asList(8, 1))).isEqualTo("8|1");
	}

	@Test
	public void 스페어_현재점수_계산() {
		Score score = new SpareScore(8);
		assertThat(score.currentScore()).isEqualTo(10);
	}

	@Test
	public void 스페어_현재점수_보기() {
		assertThat(Score.convertString(Arrays.asList(8, 2))).isEqualTo("8|/");
	}

	@Test
	public void 스트라이크_현재점수_계산() {
		Score score = new StrikeScore();
		assertThat(score.currentScore()).isEqualTo(10);
	}

	@Test
	public void 스트라이크_현재점수_보기() {
		assertThat(Score.convertString(Arrays.asList(10))).isEqualTo("X");
	}

	@Test
	public void 미스_거터처리() {
		assertThat(Score.convertString(Arrays.asList(3, 0))).isEqualTo("3|-");
	}

	@Test
	public void 스페어_거터처리() {
		assertThat(Score.convertString(Arrays.asList(0, 10))).isEqualTo("-|/");
	}
}
