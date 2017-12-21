package sangco.bowling.model.state;

import java.util.HashMap;

import sangco.bowling.model.frame.Frame;

public abstract class State {
	public void findBeforeState(int frame, HashMap<Integer, Frame> scoreBoard) {
	// frame을 알고 scoreBoard를 알고 있으니 여기서 반환 받아서 토탈값  넣어주자	
	}
	
	abstract int setFrameDate(int scoreFirstRoll, int scoreSecondRoll);
}
