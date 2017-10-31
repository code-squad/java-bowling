package bowling;

import bowling.frame.Frame;
import bowling.state.LastEnd;
import bowling.view.BowlingFormView;

public class Bowling {
	public static void main(String[] args) {
		String name = BowlingFormView.inputName();
		Board board = new Board(name);
		Frame frame = Frame.create(1);
		Frame next = frame;
		System.out.println(board.show(frame));
		while (!(next.getState() instanceof LastEnd)) {
			next = next.bowl(BowlingFormView.inputScore(name));
			System.out.println(next.getState());
			System.out.println(board.show(frame));
		}
	}
}
