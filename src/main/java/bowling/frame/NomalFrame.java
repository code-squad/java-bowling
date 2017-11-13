package bowling.frame;

public class NomalFrame extends Frame {

	private NomalFrame(int no) {
		this.no = no;
	}

	public static Frame create(int no) {
		return new NomalFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		if (score == 10) {
			return new NomalFrame(no + 1);
		}
		return this;
	}
}
