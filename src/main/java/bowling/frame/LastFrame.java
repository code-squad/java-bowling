package bowling.frame;

public class LastFrame extends Frame {

	private LastFrame(int no) {
		this.no = no;
	}

	public static Frame create(int no) {
		return new LastFrame(no);
	}

}
