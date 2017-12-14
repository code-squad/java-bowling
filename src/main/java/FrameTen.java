
public class FrameTen extends Frame{
	
	@Override
	String makeScoreMark(Player player) {
		if (pinsPerFrame.isEmpty() && player.getFrameNum() == 9) {
			return "      |";			
		}
		if (pinsPerFrame.isEmpty()) {
			return "";			
		}
		String scoreMark = makeScoreMarkWhenSizeOneOrTwo();
		if (pinsPerFrame.size() == 3) {
			scoreMark = makeThirdScoreMark();
		}
		return scoreMark;
		
	}
	
	String makeThirdScoreMark() {
		if (pinsPerFrame.get(0) + pinsPerFrame.get(1) == 10) {
			return " " + changeScoreToMark(pinsPerFrame.get(0)) +
					"|/|" + changeScoreToMark(pinsPerFrame.get(2)) + "|";
		}
		if (pinsPerFrame.get(1) + pinsPerFrame.get(2) == 10) {
			return " X|" + changeScoreToMark(pinsPerFrame.get(1)) + "|/|";
		}
		String oneFrame = " ";
		return makeOneFrame(oneFrame, 3);
	}
	
	@Override
	boolean isEnded(Player player) {
		if (player.getFrameNum() == 10) {
			return true;
		}
		if (pinsPerFrame.size() == 3) {
			return true;
		}
		return pinsPerFrame.size() == 2 && pinsPerFrame.get(0) + pinsPerFrame.get(1) < 10;
	}
}
