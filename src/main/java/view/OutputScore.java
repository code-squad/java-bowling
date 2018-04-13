package view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.FrameInfo;
import frame.Frame;
import frame.LastFrame;

public class OutputScore {
	private static final Logger log = LoggerFactory.getLogger(OutputScore.class);

	public static void printFrameInfo(Frame frame, String name) {
		printScoreboard(frame, name);
		printTotalScoreBoard(frame);
	}
	
	static void printScoreboard(Frame frame, String name) {
		System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		StringBuilder bowlingScore = new StringBuilder("");
		bowlingScore.append("|  " + name + " ");

		for (int i = 0; i < frame.getFrameInfo().getFrameNo(); i++) {
			FrameInfo frameInfo = frame.getFrameInfo();
			bowlingScore.append(convertFirstRollToString(frameInfo));
			bowlingScore.append(convertSecondRollToString(frameInfo));

			if (frameInfo.getNextFrame() != null) {
				frame = frameInfo.getNextFrame();
			}
		}

		for (int i = 0; i < 10 - frame.getFrameInfo().getFrameNo(); i++) {
			bowlingScore.append("|      ");
		}
		bowlingScore.append("|");
		System.out.println(bowlingScore);
	}

	private static String convertFirstRollToString(FrameInfo frameInfo) {
		if (frameInfo.isFirstRollNull()) {
			return "|   ";
		}

		int firstRoll = frameInfo.getFirstRoll();

		if (firstRoll == 10) {
			return "|  X";
		}
		return "|  " + firstRoll + "";
	}

	private static String convertSecondRollToString(FrameInfo frameInfo) {
		if (frameInfo.isSecondRollNull()) {
			return "   ";
		}

		int secondRoll = frameInfo.getSecondRoll();

		if (secondRoll == 10) {
			return "|10";
		}

		if (frameInfo.getFrameScore() == 10) {
			return "|/ ";
		}

		if (secondRoll == 0) {
			return "|- ";
		}
		return "|" + secondRoll + " ";
	}

	static void printTotalScoreBoard(Frame frame) {
		StringBuilder bowlingTotalScore = new StringBuilder("");
		bowlingTotalScore.append("|      ");
		int totalScore = 0;

		for (int i = 0; i < frame.getFrameInfo().getFrameNo(); i++) {
			FrameInfo frameInfo = frame.getFrameInfo();
			if (!frameInfo.getState().isFrameEnd()) {
				bowlingTotalScore.append("|      ");
			}

			if (frameInfo.getState().isFrameEnd()) {
				if (frameInfo.getNextFrame() != null && frameInfo.getTotalScore() == null) {
					bowlingTotalScore.append("|      ");
				}

				if (frameInfo.getNextFrame() != null && frameInfo.getTotalScore() != null) {
					totalScore += frameInfo.getTotalScore().getScore();
					bowlingTotalScore.append(convertTotalToString(totalScore));
				}
			}

			if (frameInfo.getNextFrame() != null) {
				frame = frameInfo.getNextFrame();
			}
		}

		for (int i = 0; i < 10 - frame.getFrameInfo().getFrameNo(); i++) {
			bowlingTotalScore.append("|      ");
		}
		bowlingTotalScore.append("|");
		System.out.println(bowlingTotalScore);
	}

	private static String convertTotalToString(int totalScore) {
		if (totalScore >= 100) {
			return "|  " + totalScore + " ";
		}

		if (totalScore < 10) {
			return "|  " + totalScore + "   ";
		}
		return "|  " + totalScore + "  ";
	}

	// private static String convertBonusRollToString(LastFrame frame) {
	// return "|" + frame.getBonusBowl() + "";
	// }
	//
	// private static String convertContinuousStrikeToString(LastFrame frame) {
	// if (frame.getBonusBowl() == 10) {
	// return "" + frame.getBonusBowl() + "";
	// }
	// return "|" + frame.getBonusBowl() + "";
	// }
}
