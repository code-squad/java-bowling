package bowling;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ScoreTest {

	@Test
	public void 미스_현재점수_계산() {
		Score score = new MissScore(8, 1);
		assertThat(score.currentScore()).isEqualTo(9);
	}

	@Test
	public void 미스_현재점수_보기() {
		Score score = new MissScore(8, 1);
		assertThat(score.toString()).isEqualTo("8 | 1");
	}

	@Test
	public void 스페어_현재점수_계산() {
		Score score = new SpareScore(8);
		assertThat(score.currentScore()).isEqualTo(10);
	}

	@Test
	public void 스페어_현재점수_보기() {
		Score score = new SpareScore(8);
		assertThat(score.toString()).isEqualTo("8 | /");
	}

	@Test
	public void 스트라이크_현재점수_계산() {
		Score score = new StrikeScore();
		assertThat(score.currentScore()).isEqualTo(10);
	}

	@Test
	public void 스트라이크_현재점수_보기() {
		Score score = new StrikeScore();
		assertThat(score.toString()).isEqualTo("X");
	}

}
