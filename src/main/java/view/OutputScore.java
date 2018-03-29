package view;

import bowling.Frame;
import bowling.LastFrame;

public class OutputScore {
	public static void printScoreboard(Frame frame, String name) {
		System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		StringBuilder bowlingScore = new StringBuilder("");
		bowlingScore.append("|  " + name + " ");

		for (int i = 0; i < 10; i++) {
			bowlingScore.append(convertFirstRollToString(frame));
			bowlingScore.append(convertSecondRollToString(frame));
			if (frame.getFrameNo() == 10 && !((LastFrame) frame).isBonusBowlNull()) {
				if (frame.getSecondRoll() == 10) {
					bowlingScore.delete(71, 73);
					bowlingScore.replace(75, 77, convertContinuousStrikeToString((LastFrame) frame));
					break;
				}

				bowlingScore.delete(71, 72);
				bowlingScore.replace(75, 77, convertBonusRollToString((LastFrame) frame));
				break;
			}
			frame = frame.getNextFrame();
		}
		bowlingScore.append("|");
		System.out.println(bowlingScore);
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

	private static String convertBonusRollToString(LastFrame frame) {
		return "|" + frame.getBonusBowl() + "";
	}

	private static String convertContinuousStrikeToString(LastFrame frame) {
		if (frame.getBonusBowl() == 10) {
			return "" + frame.getBonusBowl() + "";
		}
		return "|" + frame.getBonusBowl() + "";
	}
}
