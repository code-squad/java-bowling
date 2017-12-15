
public class View {
	
	private static final String name = "| name |";
	private static final int lastFrameNum = 10;
	
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
	
	static void showResult(Player player) {
		showFullFrameNumber();
		String scoreView = "|  " + player.getName() + " |";
		for (Frame frame : player.getFrames()) {
			scoreView += frame.makeScoreMark();
		}
		for (int i = 0; i < lastFrameNum - player.getFrames().size(); i++) {
			scoreView += "      |";
		}
		System.out.println(scoreView + "\n");
	}
}


