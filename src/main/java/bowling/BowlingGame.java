package bowling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.frame.Frame;
import bowling.frame.NormalFrame;
import bowling.frame.state.BowlingEnd;
import bowling.result.Result;
import bowling.user.User;
import bowling.view.BowlingFormView;

public class BowlingGame {
	private static final Logger log = LoggerFactory.getLogger(BowlingGame.class);

	public static void main(String[] args) {
		User user = User.create(BowlingFormView.inputName());
		int start = 1, initialFrameScoe = 0;
		Frame frame = NormalFrame.create(start, initialFrameScoe);
		Frame next = frame.bowl(BowlingFormView.bowling(user.printName()));
		do {
			next = next.bowl(BowlingFormView.bowling(user.printName()));
			Result result = frame.result();
			log.debug(result.show(user.printName()));
		} while (!(next.getState() instanceof BowlingEnd));
	}
}
