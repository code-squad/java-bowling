package bowling.view;

import bowling.result.Result;

public class BowlingResultView {

	public static void show(String name, Result result) {
		System.out.println(result.show(name));
	}

}
