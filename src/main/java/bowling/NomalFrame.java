package bowling;

import state.Finish;
import state.Running;

public class NomalFrame extends Frame {
	public NomalFrame(int frameNo) {
		super(frameNo);
	}

	@Override
	public void InputBowl(Pins pins) {
		if (state instanceof Finish & nextFrame == null) {
			// 삼항 연산자로 라스트 프레임 구현?
			nextFrame = new NomalFrame(frameNo + 1);
			nextFrame.InputBowl(pins);
		}
		
		if (state instanceof Finish & nextFrame != null) {
			nextFrame.InputBowl(pins);
		}
		
		if (state instanceof Running) {
			state = state.saveBowl(pins);
		}
	}
}
