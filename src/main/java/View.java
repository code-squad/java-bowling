
public class View {
	
	private static final String name = "| name |";
	
	private static void showFullFrameNumber() {
		String fullFrame = name;
		for (int i = 1; i <= 10; i++) {
			if (i == 10) {
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
			if (frame != null) {
				scoreView += frame.makeScoreMarkOnFrame(); 	
			}
			if (frame == null) {
				scoreView += "      |";				
			}
		}
		System.out.println(scoreView + "\n");
	}
}


