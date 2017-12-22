package sangco.bowling.view;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {
	public static ArrayList<String> getUserList() {
		String userName = "ASD,FGH,JKL";
		return new ArrayList<>(Arrays.asList(userName.split(",")));
	}
	
	public static int getScore() {
		return 3;
		// Scanner로 입력 받아야 한다. 이건 임시
		//setTotalScoreList 에 add()
	}

	public static int getScore(int scoreFirstRoll) {
		// scoreFirstRoll을 이용해서 유효성 체크
		return 3;
		//setTotalScoreList 에 add()
		// Scanner로 입력 받아야 한다. 이건 임시
	}
}
