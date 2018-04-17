package view;

import domain.frame.Frame;

import java.util.LinkedList;
import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	
	public static String showGetPlayerNameView() {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		return scanner.nextLine();
	}

	public static int showGetPinCountView(LinkedList<Frame> frames) {
		System.out.print(getNextFrameNumber(frames) + "프레임 투구 : ");
		return Integer.parseInt(scanner.nextLine());
	}

	private static int getNextFrameNumber(LinkedList<Frame> frames) {
		if(frames.isEmpty()) {
			return Frame.MIN_FRAME_NUMBER;
		}

		if(frames.getLast().isComplete()) {
			return frames.size() + 1;
		}

		return frames.size();
	}
}
