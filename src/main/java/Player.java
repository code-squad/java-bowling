
import java.util.Arrays;
import java.util.List;

public class Player {
	
	private String name;
	private List<Frame> frames = Arrays.asList(new Frame[10]);

	Player(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
	List<Frame> getFrames() {
		return this.frames;
	}
	
	void play(int i, Frame frame) {
		this.frames.set(i, frame);
	}
}
