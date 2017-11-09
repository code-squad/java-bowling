package new_ladder.view;

import new_ladder.ladder.Ladder;
import new_ladder.result.Result;

public class LadderResultView {

	public static Result create(Ladder ladder) {
		return new Result(ladder);
	}

}
