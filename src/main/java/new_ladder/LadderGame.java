package new_ladder;

import new_ladder.ladder.Ladder;
import new_ladder.result.Result;
import new_ladder.view.LadderFormView;
import new_ladder.view.LadderResultView;

public class LadderGame {
	public static void main(String[] args) {
		String[] names = LadderFormView.playersInput().split(",");
		int height = LadderFormView.ladderHeight();
		int userCount = names.length;
		Ladder ladder = new Ladder(userCount, height);
		Result result = ladder.result();
		LadderResultView.show(result);
		result.show();
		for (int i = 0; i < userCount; i++) {
			System.out.print(names[i] + "     ");
		}
	}
}
