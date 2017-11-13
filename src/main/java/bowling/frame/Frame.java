package bowling.frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Frame {
	private static final Logger log = LoggerFactory.getLogger(Frame.class);

	protected int no;

	public static Frame createFrame(int no) {
		if (no == 10) {
			return LastFrame.create(no);
		}
		return NomalFrame.create(no);
	}

	public Frame bowl(int score) {
		if (no == 10) {
			return ((LastFrame) this).bowl(score);
		}
		return ((NomalFrame) this).bowl(score);
	}

	public int getNo() {
		return this.no;
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
