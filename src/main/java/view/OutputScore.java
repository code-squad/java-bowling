package view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.Frame;
import bowling.FrameScore;

public class OutputScore {
	private static final Logger log = LoggerFactory.getLogger(OutputScore.class);

	public static void printScoreboard(Frame frame, String name) {
		System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		StringBuilder bowlingScore = new StringBuilder("");
		bowlingScore.append("|  " + name + " ");
		for (int i = 0; i < frame.getFrameNo(); i++) {
			bowlingScore.append(convertFirstRollToString(frame.getFrameScore()));
			bowlingScore.append(convertSecondRollToString(frame.getFrameScore()));

			if (frame.getNextFrame() != null) {
				frame = frame.getNextFrame();
			}
		}

		for (int i = 0; i < 10 - frame.getFrameNo(); i++) {
			bowlingScore.append("|      ");
		}
		bowlingScore.append("|");
		System.out.println(bowlingScore);
	}

	private static String convertFirstRollToString(FrameScore frameScore) {
		if (frameScore.isFirstRollNull()) {
			return "|   ";
		}

		int firstRoll = frameScore.getFirstRoll();

		if (firstRoll == 10) {
			return "|  X";
		}
		return "|  " + firstRoll + "";
	}

	private static String convertSecondRollToString(FrameScore frameScore) {
		if (frameScore.isSecondRollNull()) {
			return "   ";
		}

		int secondRoll = frameScore.getSecondRoll();

		if (secondRoll == 10) {
			return "|10";
		}

		if (frameScore.getFrameScore() == 10) {
			return "|/ ";
		}

		if (secondRoll == 0) {
			return "|- ";
		}
		return "|" + secondRoll + " ";
	}

//	public static void printTotalScoreBoard(Frame frame) {
//		StringBuilder bowlingTotalScore = new StringBuilder("");
//		bowlingTotalScore.append("|      ");
//		int totalScore = 0;
//
//		for (int i = 0; i < frame.getFrameNo(); i++) {
//			if (frame.readyToCalculateTotal()) {
//				totalScore += frame.getFrameTotal();
//				bowlingTotalScore.append(convertTotalToString(totalScore));
//			}
//
//			if (!frame.readyToCalculateTotal()) {
//				bowlingTotalScore.append("|      ");
//			}
//
//			if (frame.getNextFrame() != null) {
//				frame = frame.getNextFrame();
//			}
//		}
//
//		for (int i = 0; i < 10 - frame.getFrameNo(); i++) {
//			bowlingTotalScore.append("|      ");
//		}
//		bowlingTotalScore.append("|");
//		System.out.println(bowlingTotalScore);
//	}
//
//	private static String convertTotalToString(int totalScore) {
//		if (totalScore >= 100) {
//			return "|  " + totalScore + " ";
//		}
//		return "|  " + totalScore + "  ";
//	}

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
