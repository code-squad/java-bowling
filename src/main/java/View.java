
public class View {
	
	private static final String name = "| name |";
	
	private static void showFullFrameNumber() {
		String fullFrame = name;
		for (int i = 1; i <= 10; i++) {
			if (i == 10) {
				fullFrame += "  " + Integer.toString(i) + "  |";
				break;
			}
			fullFrame += "  0" + Integer.toString(i) + "  |";
		}
		System.out.println(fullFrame);
	}
	
	static void showResult(Player player) {
		showFullFrameNumber();
		String scoreView = "|  " + player.getName() + " |";
		for (Frame frame : player.getFrames()) {
			if (frame != null) {
				scoreView += makeOneFrameView(frame); 	
			}
			if (frame == null) {
				scoreView += "      |";				
			}
		}
		System.out.println(scoreView + "\n");
	}
	
	private static String makeOneFrameView(Frame frame) {
		String oneFrame, firstValue, secondValue =  "";
		firstValue = Integer.toString(frame.getPinsPerFrame().get(0));
		if (frame.getPinsPerFrame().get(0) == 10) {
			firstValue = "X";
		}
		if (frame.getPinsPerFrame().get(0) == 0) {
			firstValue = "-"; 
		}
		oneFrame = "  " + firstValue + "   |";
		if (frame.getPinsPerFrame().size() == 2) {
			secondValue = Integer.toString(frame.getPinsPerFrame().get(1));
			if (frame.getPinsPerFrame().get(0) + frame.getPinsPerFrame().get(1) == 10) {
				secondValue = "/";
			}
			if (frame.getPinsPerFrame().get(1) == 0) {
				secondValue = "-";
			}
			oneFrame = "  " + firstValue + "|" + secondValue + " |";
		}
		return oneFrame;
	}
}


