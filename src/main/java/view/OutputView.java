package view;

import domain.frame.Frame;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class OutputView {
	public static void showStatusBoardView(String playerName, LinkedList<Frame> playedFrames) {
		StringBuilder headerBuilder = new StringBuilder("| NAME |");
		StringBuilder statusBuilder = new StringBuilder(String.format("| %4s |", playerName));
		
		IntStream.range(0, 10)
				.forEach(frameNumber -> {
					headerBuilder.append(String.format("  %02d  |", frameNumber + 1));
					statusBuilder.append(String.format(" %4s |", ""));
				});
		System.out.println(headerBuilder);
		System.out.println(statusBuilder);
	}
}
