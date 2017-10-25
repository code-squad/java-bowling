package bowling.frame;

public class FrameResult {
	private String desc;
	private String score;

	public FrameResult(String desc, String score) {
		this.desc = desc;
		this.score = score;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		FrameResult other = (FrameResult) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FrameResult [desc=" + desc + ", score=" + score + "]";
	}
}
