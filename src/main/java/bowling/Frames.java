package bowling;

import java.util.ArrayList;
import java.util.HashMap;

public class Frames {
	HashMap<Integer, Frame> frames = new HashMap<Integer, Frame>();

	Frames() {
		
	}

	public boolean addFrame(Frame frame) {
		if(frame.isOver())
			return false;
		if(frame.isAddPossible(frames))
			frame.addFrames(frames);
		return true;
	}
//	public boolean isAddPossible(Frame frame) {
//		if (frames.get(countFrame()) != null)
//			return frames.get(countFrame()) == frame;
//		return true;
//	}
//
//	public void addFrames(Frame frame) {
//		frames.put(countFrame(), frame);
//	}


	public int countFrame() {
		return frames.size();
	}

	public void getFrameScore() {
		ArrayList<Integer> total = new ArrayList<>();
		for (Frame frame : frames.values()) {
			frame.getFrameScore(total);
		}
		
		System.out.println("TotalScore : " + total);
	}


	public String getStatusResult() {
		String result = "";
		for (Frame frame : frames.values()) {
			result += frame.getStatusResult();
		}
		return result;
	}




}
