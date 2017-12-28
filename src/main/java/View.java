public class View {
	private static final String name = "| name |";
	private static final int lastFrameNum = 10;
	
	static void showAll(Players players) {
		showFullFrameNumber();
		for (Player player : players.getPlayers()) {
			showResult(player);
			showScore(player);			
		}
	}
	
	private static void showFullFrameNumber() {
		String fullFrame = name;
		for (int i = 1; i <= lastFrameNum; i++) {
			if (i == lastFrameNum) {
				fullFrame += "  " + i + "  |";
				break;
			}
			fullFrame += "  0" + i + "  |";
		}
		System.out.println(fullFrame);
	}

	private static void showResult(Player player) {
		String resultView = "|  " + player.getName() + " |";
		for (Frame frame : player.getFrames()) {
			resultView += frame.makeScoreMark();
		}
		for (int i = 0; i < lastFrameNum - player.getFrames().size(); i++) {
			resultView += "      |";
		}
		System.out.println(resultView);
	}
	
	private static void showScore(Player player) {
		String scoreView = "| score|";
		for (int totalScore : player.getTotalScores()) {
			if ((totalScore + "").length() == 1) {
				scoreView += "     " + totalScore + "|";
			}
			if ((totalScore + "").length() == 2) {
				scoreView += "    " + totalScore + "|";
			}
			if ((totalScore + "").length() == 3) {
				scoreView += "   " + totalScore + "|";
			}
		}
		for (int i = 0; i < lastFrameNum - player.getTotalScores().size(); i++) {
			scoreView += "      |";
		}
		System.out.println(scoreView);
	}
}


