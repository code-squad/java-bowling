package bowling.frame.state;

import org.junit.Test;

import bowling.frame.state.nomalFrame.NomalFrameStrike;

public class EndTest {

	@Test(expected = IllegalArgumentException.class)
	public void 종료상태인_프레임_일때_입력받으면_예외발생() {
		NomalFrameStrike strike = new NomalFrameStrike();
		strike.bowl(1);
	}
}
