package new_ladder.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Row {
	private List<Route> row;

	public Row(int row) {
		this.row = new ArrayList<>();
		createRow(row);
	}

	public Row() {
		row = new ArrayList<>();
	}

	private void createRow(int row) {
		for (int index = 0; index < row - 1; index++) {
			Random random = new Random();
			addRoute(Route.of(random.nextInt()));
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

	private boolean isBeforeRoute() {
		if (row.isEmpty()) {
			return false;
		}
		int size = row.size();
		Route route = row.get(size - 1);
		return route.getRoute();
	}

}
