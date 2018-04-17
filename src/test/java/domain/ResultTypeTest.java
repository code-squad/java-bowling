package domain;

import domain.frame.NormalFrame;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTypeTest {
	@Test
	public void resultOf테스트() {
		assertThat(ResultType.resultOf(new NormalFrame(1, 10))).isEqualTo(ResultType.STRIKE);
		assertThat(ResultType.resultOf(new NormalFrame(1, 9).bowl(1))).isEqualTo(ResultType.SPARE);
		assertThat(ResultType.resultOf(new NormalFrame(1, 9).bowl(0))).isEqualTo(ResultType.MISS);
	}
}
