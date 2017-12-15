
import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Frame> frames = new ArrayList<>();
	private Frame currentFrame = new Frame(0);

	Player(String name) {
		this.name = name;
		frames.add(currentFrame);
	}
	
	String getName() {
		return this.name;
	}
	
	List<Frame> getFrames() {
		return this.frames;
	}
	
	void play(int pinsPerTry) {
		currentFrame.bowl(pinsPerTry);
		frames.set(currentFrame.getFrameNum(), currentFrame);
		if (currentFrame.isEnded()) {
			currentFrame = currentFrame.makeNewFrame();
			frames.add(currentFrame);
		}
	}
	
	boolean isFinished() {
		return currentFrame.isEnded();
	}
}
