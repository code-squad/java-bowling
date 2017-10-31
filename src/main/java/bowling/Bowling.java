package bowling;

import java.util.List;

import bowling.frame.Frame;
import bowling.frame.FrameResult;
import bowling.state.LastEnd;
import bowling.view.BowlingFormView;

public class Bowling {
	public static void main(String[] args) {
		String name = BowlingFormView.inputName();
		Board board = new Board(name);
		Frame frame = Frame.create(1);
		Frame next = frame;
		List<FrameResult> result = frame.getResult();
		System.out.println(board.show(frame, result));
		while (!(next.getState() instanceof LastEnd)) {
			next = next.bowl(BowlingFormView.inputScore(name));
			System.out.println(board.show(frame, result));
		}
	}
}
