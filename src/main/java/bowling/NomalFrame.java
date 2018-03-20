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
		}
		
		if (state instanceof Finish & nextFrame != null) {
			nextFrame.InputBowl(pins);
		}
		
		if (state instanceof Running) {
			state = ((Running) state).saveBowl(pins);
		}
		//여기에 추상화된 점수 구하는 메소드를 실행 시키자
	}
}
