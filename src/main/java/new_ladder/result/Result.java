package new_ladder.result;

import java.util.List;

import new_ladder.ladder.Ladder;
import new_ladder.ladder.Route;
import new_ladder.ladder.Row;

public class Result {

	private Ladder ladder;

	public Result(Ladder ladder) {
		this.ladder = ladder;
	}

	public void show() {
		List<Row> temp = ladder.getLadder();
		for (Row row : temp) {
			for (Route route : row.getLow()) {
				System.out.print("|");
				if (route.getRoute()) {
					System.out.print(route);
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
	}

}
