package new_ladder.ladder;

public class Route {
	private boolean route;

	public Route(int value) {
		route = InitializeRoute(value);
	}

	public boolean getRoute() {
		return route;
	}

	private boolean InitializeRoute(int value) {
		return value % 2 == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (route ? 1231 : 1237);
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
		Route other = (Route) obj;
		if (route != other.route)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "-----";
	}
}
