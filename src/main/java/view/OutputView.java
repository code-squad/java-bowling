package view;

import domain.pitch.Pitch;
import domain.frame.Frame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
	public static void showStatusBoardView(String playerName, List<Frame> playedFrames) {
		StringBuilder headerBuilder = new StringBuilder("| NAME |");
		StringBuilder statusBuilder = new StringBuilder(String.format("| %4s |", playerName));
		
		playedFrames.stream()
				.forEach(frame -> {
					headerBuilder.append(String.format(frame.isFinalFrame() ? "  %02d    |" : "  %02d  |", frame.getFrameNumber()));
					statusBuilder.append(String.format(frame.isFinalFrame() ? "  %-5s |" : "  %-3s |", getFrameStatus(frame)));
				});

		IntStream.range(playedFrames.size(), Frame.MAX_FRAME_NUMBER)
				.forEach(frameNumber -> {
					headerBuilder.append(String.format(frameNumber == Frame.MAX_FRAME_NUMBER - 1 ? "  %02d    |" : "  %02d  |", frameNumber + 1));
					statusBuilder.append(String.format(frameNumber == Frame.MAX_FRAME_NUMBER - 1 ? " %6s |" : " %4s |", ""));
				});
		System.out.println(headerBuilder);
		System.out.println(statusBuilder);
	}

	private static String getFrameStatus(Frame frame) {
		return frame.getPitches().stream()
				.map(Pitch::getDisplayValue)
				.collect(Collectors.joining("|"));
	}
}
