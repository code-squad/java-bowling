
public class Frame {

	private static final String name = "| name |";
	private String frame;
	
	Frame (String frame) {
		this.frame = frame;
	}
	
	String getFrame() {
		return this.frame;
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
