package new_ladder.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Low {
	private static int trueCount;

	private List<Route> lows;

	public Low(int low) {
		createLow(low);
	}

	private void createLow(int low) {
		lows = new ArrayList<>();
		for (int i = 0; i < low; i++) {
			Random random = new Random();
			lows.add(new Route(random.nextInt()));
		}
	}

	public int size() {
		return lows.size();
	}

	public List<Route> getLow() {
		return lows;
	}

	public static List<Route> checkLow(List<Route> temp) {
		Route route;
		final int FALSE = 1;
		for (int i = 0; i < temp.size(); i++) {
			route = temp.get(i);
			checkRoute(temp, route, FALSE, i);
		}
		return temp;
	}

	private static void checkRoute(List<Route> temp, Route route, final int FALSE, int i) {
		if (route.getRoute()) {
			++trueCount;
		} else {
			if (trueCount > 0) {
				--trueCount;
			}
		}
		if (trueCount == 2) {
			temp.set(i, new Route(FALSE));
			trueCount = 0;
		}
		if (i + 1 == temp.size()) {
			temp.set(i, new Route(FALSE));
		}
	}

	public int getTrueCount() {
		return trueCount;
	}

}
