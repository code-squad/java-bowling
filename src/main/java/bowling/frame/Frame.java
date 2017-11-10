package bowling.frame;

public abstract class Frame {

	protected int no;

	public static Frame createFrame(int no) {
		if (no == 10) {
			return LastFrame.create(no);
		}
		return NomalFrame.create(no);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		return no == other.no;
	}
}
