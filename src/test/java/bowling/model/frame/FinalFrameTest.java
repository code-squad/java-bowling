package bowling.model.frame;

import bowling.model.score.FinalScore;
import bowling.model.score.MissScore;
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

		assertThat(finalFrame.score instanceof FinalScore).isTrue();
		assertThat(finalFrame.temp.size()).isEqualTo(3);
	}

	@Test
	public void 스트라잌_스트라잌_안스트라잌() {
		finalFrame.bowl(10);
		finalFrame.bowl(10);
		finalFrame.bowl(2);

		assertThat(finalFrame.temp.size()).isEqualTo(3);
	}

	@Test
	public void 스트라잌_스페어() {
		finalFrame.bowl(10);
		finalFrame.bowl(8);
		finalFrame.bowl(2);

		assertThat(finalFrame.temp.size()).isEqualTo(3);
	}

	@Test
	public void 스페어_스트라잌() {
		finalFrame.bowl(8);
		finalFrame.bowl(2);
		finalFrame.bowl(10);

		assertThat(finalFrame.temp.size()).isEqualTo(3);
	}
//
	@Test
	public void 미스() {
		finalFrame.bowl(2);
		finalFrame.bowl(4);

		assertThat(finalFrame.score instanceof MissScore).isTrue();
		assertThat(finalFrame.temp.size()).isEqualTo(2);
	}

}
