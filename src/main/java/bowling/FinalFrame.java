package bowling;

import static bowling.Status.STRIKE;
import static bowling.Status.SPARE;
import static bowling.Status.MISS;

import java.util.ArrayList;

public class FinalFrame extends Frame {
	
	ArrayList<Integer> finalFrame = new ArrayList<>();

	public FinalFrame() {
		super();
	}

	@Override
	public boolean isNotEnd() {
		if (getStatus() == Status.MISS) {
			return false;
		}
		return true;
	}

	@Override
	public String changeFormat() {
		String strScore = "\t";
		for (int i = 0; i < frame.size(); i++) {
			strScore += frame.get(i);
//			if (getStatus() == STRIKE)
//				strScore += "X";
//			if (getStatus() == SPARE)
//				strScore = " | /" + "\t|";
//			if (getStatus() == MISS && frame.get(1) == 0)
//				strScore = " | -" + "\t|";
//			if (getStatus() == MISS && frame.get(1) != 0)
//				strScore = " | " + frame.get(1) + "\t|";
		}
		return strScore;
	}
}