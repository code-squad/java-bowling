package view;

import bowling.Frame;
import bowling.NomalFrame;
import state.Finish;
import state.Nomal;
import state.Running;
import state.Spare;
import state.State;
import state.Strike;

public class OutputScore {

	public static void printScoreboard(Frame frame, String name) {
		System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		StringBuilder test = new StringBuilder("");
		test.append("|  " + name + " ");

		int frameSize = frame.getCurrentFrameNo();

		for (int i = 0; i < frameSize; i++) {
			State state = frame.getState();
			Frame nextFrame = frame.getNextFrame();

			if (state instanceof Finish & nextFrame != null) {
				print(frame, test, state);
			}

			if (state instanceof Finish & nextFrame == null) {
				print(frame, test, state);
			}

			if (state instanceof Running) {
				test.append("|  " + frame.getFirstRoll() + "   ");
			}
			frame = nextFrame;
		}

		for (int i = 0; i < 10 - frameSize; i++) {
			test.append("|      ");
		}

		test.append("|");

		System.out.println(test);
		System.out.println();
	}

	private static void print(Frame frame, StringBuilder test, State state) {
		if (state instanceof Strike) {
			test.append("|  X   ");
		}

		if (state instanceof Spare) {
			test.append("|  " + frame.getFirstRoll() + "|/ ");
		}

		if (state instanceof Nomal) {
			if (frame.getSecondRoll() == 0) {
				test.append("|  " + frame.getFirstRoll() + "|- ");
			}
			test.append("|  " + frame.getFirstRoll() + "|" + frame.getSecondRoll() + " ");
		}
	}
}
