package Ladder.player;

import Ladder.Ladder;

public class Player {

	private int no;
	private String name;
	private Ladder radder;

	public Player(int no, String name) {
		this.no = no;
		this.name = name;
		this.radder = new Ladder(no, name);

	}

	public Player(String name) {
		this.name = name;
	}

	public Ladder getRadder() {
		return radder;
	}

	public String getName() {
		return name;
	}

	public int getNo() {
		return no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + radder + "";
	}
}
