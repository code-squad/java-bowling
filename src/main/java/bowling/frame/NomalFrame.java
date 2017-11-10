package bowling.frame;

public class NomalFrame extends Frame {

	private NomalFrame(int no) {
		this.no = no;
	}

	public static Frame create(int no) {
		return new NomalFrame(no);
	}
}
