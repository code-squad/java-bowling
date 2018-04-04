package view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.Frame;

public class OutputScore {
	private static StringBuilder scoreBefore = new StringBuilder("");

	public static void printScoreboard(Frame frame, String name) {
		System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		StringBuilder runningScore = new StringBuilder("");
		StringBuilder outputBuilder = new StringBuilder("");
		outputBuilder.append("|  " + name + " ");
		outputBuilder.append(scoreBefore);

		if (frame.isFrameEnd()) {
			scoreBefore.append(convertFirstRollToString(frame));
			scoreBefore.append(convertSecondRollToString(frame));
		}

		runningScore.append(convertFirstRollToString(frame));
		runningScore.append(convertSecondRollToString(frame));
		outputBuilder.append(runningScore);

		for (int i = 0; i < 10 - frame.getFrameNo(); i++) {
			outputBuilder.append("|      ");
		}
		outputBuilder.append("|");
		System.out.println(outputBuilder);
		System.out.println();
	}

	private static String convertFirstRollToString(Frame frame) {
		if (frame.isFirstRollNull()) {
			return "|   ";
		}

		int firstRoll = frame.getFirstRoll();

		if (firstRoll == 10) {
			return "|  X";
		}
		return "|  " + firstRoll + "";
	}

	private static String convertSecondRollToString(Frame frame) {
		if (frame.isSecondRollNull()) {
			return "   ";
		}

		int secondRoll = frame.getSecondRoll();

		if (secondRoll == 10) {
			return "|10";
		}

		if (frame.getFrameScore() == 10) {
			return "|/ ";
		}

		if (secondRoll == 0) {
			return "|- ";
		}
		return "|" + secondRoll + " ";
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
