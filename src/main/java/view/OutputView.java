package view;

import domain.Pitch;
import domain.PlayStatus;
import domain.frame.FinalFrame;
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
					headerBuilder.append(String.format("  %02d  |", frame.getFrameNumber()));
					statusBuilder.append(String.format(" %-4s |", getFrameStatus(frame)));
				});

		IntStream.range(playedFrames.size(), Frame.MAX_FRAME_NUMBER)
				.forEach(frameNumber -> {
					headerBuilder.append(String.format("  %02d  |", frameNumber + 1));
					statusBuilder.append(String.format(" %4s |", ""));
				});
		System.out.println(headerBuilder);
		System.out.println(statusBuilder);
	}

	private static String getFrameStatus(Frame frame) {
		List<Pitch> pitches = frame.getPitches();
		String displayValue = pitches.stream()
				.map(Pitch::getDisplayValue)
				.collect(Collectors.joining("|"));
		return displayValue;
	}
}
