package bowling;

import bowling.frame.Frame;
import bowling.frame.LastFrame;
import bowling.state.End;
import bowling.view.BowlingFormView;

public class Bowling {
	public static void main(String[] args) {
		String name = BowlingFormView.inputName();
		Board board = new Board(name);
		Frame frame = new Frame(1);
		Frame next = frame;
		System.out.println(board.show(frame));
		while (!((next instanceof LastFrame) && (next.getState() instanceof End))) {
			next = next.bowl(BowlingFormView.inputScore(name));
			System.out.println(board.show(frame));
		}
	}
}
