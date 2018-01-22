package bowling.model;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class FinalFrameTest {
	FinalFrame finalFrame;
	@Before
	public void setup() {
		finalFrame = new FinalFrame();
	}

	@Test
	public void 스트라잌_스트라잌_스트라잌() {
		finalFrame.bowl(10);
		finalFrame.bowl(10);
		finalFrame.bowl(10);

		assertThat(finalFrame.score instanceof StrikeScore).isTrue();
		assertThat(finalFrame.bonusScores.size()).isEqualTo(2);

		for(Score bonusScore: finalFrame.bonusScores) {
			assertThat(bonusScore instanceof StrikeScore).isTrue();
		}
	}

	@Test
	public void 스트라잌_스트라잌_안스트라잌() {
		finalFrame.bowl(10);
		finalFrame.bowl(10);
		finalFrame.bowl(2);

		assertThat(finalFrame.score instanceof StrikeScore).isTrue();
		assertThat(finalFrame.bonusScores.size()).isEqualTo(2);
		assertThat(finalFrame.bonusScores.get(0) instanceof StrikeScore).isTrue();
		assertThat(finalFrame.bonusScores.get(1) instanceof MissScore).isTrue();
	}

	@Test
	public void 스트라잌_스페어() {
		finalFrame.bowl(10);
		finalFrame.bowl(8);
		finalFrame.bowl(2);

		assertThat(finalFrame.score instanceof StrikeScore).isTrue();
		assertThat(finalFrame.bonusScores.size()).isEqualTo(1);
		assertThat(finalFrame.bonusScores.get(0) instanceof SpareScore).isTrue();
	}

	@Test
	public void 스페어_스트라잌() {
		finalFrame.bowl(8);
		finalFrame.bowl(2);
		finalFrame.bowl(10);

		assertThat(finalFrame.score instanceof SpareScore).isTrue();
		assertThat(finalFrame.bonusScores.size()).isEqualTo(1);
		assertThat(finalFrame.bonusScores.get(0) instanceof StrikeScore).isTrue();
	}

	@Test
	public void 스페어_안스트라잌() {
		finalFrame.bowl(8);
		finalFrame.bowl(2);
		finalFrame.bowl(3);

		assertThat(finalFrame.score instanceof SpareScore).isTrue();
		assertThat(finalFrame.bonusScores.size()).isEqualTo(1);
		assertThat(finalFrame.bonusScores.get(0) instanceof MissScore).isTrue();
	}

}
