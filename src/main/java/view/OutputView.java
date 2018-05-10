package view;

import domain.BowlingGame;
import domain.frame.Frame;
import domain.status.Status;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
	public static void showStatusBoardView(BowlingGame bowlingGame) {
		StringBuilder headerBuilder = new StringBuilder("| NAME |");
		StringBuilder statusBuilder = new StringBuilder(String.format("| %4s |", bowlingGame.getPlayerName()));
		StringBuilder scoreBuilder = new StringBuilder("|      |");

		bowlingGame.getFrames().forEach(frame -> {
			headerBuilder.append(String.format(frame.isFinalFrame() ? "  %02d    |" : "  %02d  |", frame.getFrameNumber()));
			statusBuilder.append(String.format(frame.isFinalFrame() ? "  %-5s |" : "  %-3s |", getFrameStatus(frame)));
			scoreBuilder.append(String.format(frame.isFinalFrame() ? "  %-5s |" : "  %-3s |", frame.getScoreFlag() ? frame.getScore() : ""));
		});

		IntStream.range(bowlingGame.getFrames().size(), Frame.MAX_FRAME_NUMBER)
				.forEach(frameNumber -> {
					headerBuilder.append(String.format(frameNumber == Frame.MAX_FRAME_NUMBER - 1 ? "  %02d    |" : "  %02d  |", frameNumber + 1));
					statusBuilder.append(String.format(frameNumber == Frame.MAX_FRAME_NUMBER - 1 ? " %6s |" : " %4s |", ""));
					scoreBuilder.append(String.format(frameNumber == Frame.MAX_FRAME_NUMBER - 1 ? " %6s |" : " %4s |", ""));
				});
		System.out.println(headerBuilder);
		System.out.println(statusBuilder);
		System.out.println(scoreBuilder);
	}

	private static String getFrameStatus(Frame frame) {
		return frame.getStatusHistory().stream()
				.map(Status::display)
				.collect(Collectors.joining("|"));
	}
}
