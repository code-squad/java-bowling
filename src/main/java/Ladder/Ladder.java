package Ladder;

public class Ladder {

	private int no;
	private String radder;
	private String name;
	private Width right;
	private Width left;

	public Ladder(int no, String name) {
		this.no = no;
		this.name = name;
		this.radder = "|";
	}

	public Ladder(int no, String name, int flag) {
		this.no = no;
		this.name = name;
		this.radder = "|";
		dicideDirection(flag);
	}

	private int dicideDirection(int flag) {
		if (flag == 0) {
			this.left = new Width(0);
			this.left = new Width(0);
			return 1;
		}
		if (flag == 1) {
			this.left = new Width(1);
			this.right = new Width(0);
			return 1;
		}
		this.left = new Width(0);
		this.right = new Width(1);
		return 1;	

	}

	public Ladder create(int height) {
		for (int i = 0; i < height; i++) {

		}
		return this;
	}

	@Override
	public String toString() {
		return radder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Ladder other = (Ladder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		return true;
	}

}