package bowling.frame.state;

class Strike extends Finished {
	@Override
	Score getScore() {
		return new Score(10, 2);
	}
}
