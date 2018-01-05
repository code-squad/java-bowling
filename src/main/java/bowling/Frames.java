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

	public int countFrame() {
		return frames.size();
	}

	public void getFrameScore() {
		ArrayList<Integer> total = new ArrayList<>();
		for (int i = 0; i < frames.size(); i++) {
			total.add(frames.get(i).getScore());
		}
		System.out.println("TotalScore : " + total);
	}


	public String getStatusResult() {
		String result = "";
		for (int i = 0; i < frames.size(); i++) {
			result += frames.get(i).getStatusResult();
		}
		return result;
	}




}
