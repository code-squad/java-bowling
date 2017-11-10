package model;

import java.util.ArrayList;
import java.util.List;

public class SetOfFrame {
	private List<Frame> fullFrame = new ArrayList<Frame>();

	public SetOfFrame(int numFrame) {
		for (int i = 0; i < numFrame - 1; i++) {
			fullFrame.add(new Frame());
		}
		fullFrame.add(new LastFrame());
	}

	public void setFrameScore() {
		fullFrame.get(0).getSumScore();
	}
}
