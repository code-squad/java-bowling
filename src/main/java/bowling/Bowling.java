package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.board.Board;
import bowling.frame.Frame;
import bowling.frame.state.State;
import bowling.score.Score;
import bowling.view.BowlingFormView;

public class Bowling {
	public static void main(String[] args) {
		String name = BowlingFormView.name();
		Frame frame = Frame.create(0);
		List<Frame> frames = new ArrayList<>();
		Score scores = Score.calculate(frames);
		Board board = new Board(name, frames);
		System.out.println(board.show(scores));
		for (int i = 1; i <= 10;) {
			frame = Frame.create(i, frame);
			State state = frame.bowl(BowlingFormView.score(name));
			if (state.isEnd()) {
				i++;
				frames.add(frame);
				// 매번 score 객체를 생성
				scores = Score.calculate(frames);
			}
			System.out.println(board.show(scores));
		}
	}
}