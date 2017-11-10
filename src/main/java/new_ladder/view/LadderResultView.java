package new_ladder.view;

import new_ladder.result.Result;

public class LadderResultView {

	public static void show(Result result) {

	}

	public static void showName(String[] names) {
		for (String name : names) {
			System.out.println(name + "     ");
		}
	}

}
