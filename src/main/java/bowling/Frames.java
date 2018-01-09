package bowling;

import java.util.ArrayList;
import java.util.HashMap;

public class Frames {
	HashMap<Integer, Frame> frames = new HashMap<Integer, Frame>();

	Frames(HashMap<Integer, Frame> frames) {
		this.frames = frames;
	}

	public boolean addFrame(Frame frame) {
		if(frame.isOver())
			return false;
		if(frame.isAddPossible(frames))
			frame.addFrames(frames);
		return true;
	}


	public int countFrame() {
		return frames.size();
	}

	public ArrayList<Integer> getFrameScore() {
		ArrayList<Integer> total = new ArrayList<>();
		for (Frame frame : frames.values()) {
			frame.getFrameScore(total);
		}
		return total;
	}

	public String getStatusResult() {
		String result = "";
		for (Frame frame : frames.values()) {
			result += frame.getStatusResult();
		}
		return result;
	}





}
