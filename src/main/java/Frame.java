
public class Frame {

	private static final String name = "| name |";
	String frame;
	
	Frame (String frame) {
		this.frame = frame;
	}
	
	static String makeWholeFrame() {
		String eachFrame = name;
		for (int i = 1; i <= 10; i++) {
			if (i == 10) {
				eachFrame += "  " + Integer.toString(i) + "  |";
				break;
			}
			eachFrame += "  0" + Integer.toString(i) + "  |";
		}
		return eachFrame;
	}
}
