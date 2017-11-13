package bowling.frame.state;

import org.junit.Test;

public class EndTest {

	@Test(expected = IllegalArgumentException.class)
	public void 종료상태인_프레임_일때_입력받으면_예외발생() {
		Strike strike = new Strike();
		strike.bowl(1);
	}
}
