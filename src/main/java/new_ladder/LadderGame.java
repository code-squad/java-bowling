package new_ladder;

import java.util.List;

import new_ladder.ladder.Ladder;
import new_ladder.ladder.Route;
import new_ladder.ladder.Row;
import new_ladder.view.LadderFormView;

public class LadderGame {
	public static void main(String[] args) {
		String[] names = LadderFormView.playersInput().split(",");
		int height = LadderFormView.ladderHeight();
		int userCount = names.length;
		Ladder ladder = new Ladder(userCount, height);
		List<Row> temp = ladder.getLadder();
		for (Row low : temp) {
			for (Route route : low.getLow()) {
				System.out.print("|");
				if (route.getRoute()) {
					System.out.print(route);
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < userCount; i++) {
			System.out.print(names[i] + "     ");
		}
	}
}
