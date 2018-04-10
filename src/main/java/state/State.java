package state;

import bowling.FrameScore;

public interface State {

	State update(int pinsDown);

	FrameScore getFrameScore();

	boolean isFrameEnd();

}
