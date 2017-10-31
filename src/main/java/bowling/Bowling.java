package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.board.Board;
import bowling.frame.Frame;
import bowling.frame.state.Finish;
import bowling.frame.state.State;
import bowling.view.BowlingFormView;

public class Bowling {
	public static void main(String[] args) {
		String name = BowlingFormView.name();
		Frame frame = Frame.create(0);
		List<Frame> frames = new ArrayList<>();
		Board board = new Board(name, frames);
		// State state = null;
		System.out.println(board.show());
		for (int i = 1; i <= 10;) {
			frame = Frame.create(i, frame);
			State state = frame.bowl(BowlingFormView.score(name));
			if (state instanceof Finish) {
				i++;
				frames.add(frame);
			}
			System.out.println(board.show());
		}
		// while (!(state instanceof LastEnd || state instanceof LastSecond)) {
		// state = frame.bowl(BowlingFormView.score(name));
		//
		// System.out.println(board.show());
		// }
	}
}
