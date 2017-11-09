package new_ladder.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Row {

	private List<Route> row;
	private int userCount;

	public Row(int row) {
		this.userCount = row;
		this.row = new ArrayList<>();
		createRow(row);
	}

	public Row() {
		row = new ArrayList<>();
	}

	private void createRow(int row) {
		for (int index = 0; index < row; index++) {
			Random random = new Random();
			addRoute(Route.of(random.nextInt()), index);
		}
	}

	public int getSize() {
		return row.size();
	}

	public List<Route> getLow() {
		return row;
	}

	public void addRoute(Route route) {
		if (isBeforeRoute()) {
			row.add(Route.FALSE_ROUTE);
			return;
		}
		row.add(route);
	}

	private void addRoute(Route route, int index) {
		if (isBeforeRoute() || isLastUser(index)) {
			row.add(Route.FALSE_ROUTE);
			return;
		}
		row.add(route);
	}

	private boolean isLastUser(int index) {
		if (index + 1 == userCount) {
			return true;
		}
		return false;
	}

	private boolean isBeforeRoute() {
		int size = row.size();
		if (row.isEmpty()) {
			return false;
		}
		Route route = row.get(size - 1);
		return route.getRoute();
	}

}
