
import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Frame> frames = new ArrayList<>();
	private Frame currentFrame = new Frame(0);

	Player(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
	List<Frame> getFrames() {
		return this.frames;
	}
	
	void play(int pinsPerTry) {
		currentFrame.bowl(pinsPerTry);
		System.out.println(frames);
		System.out.println(currentFrame.getPinsPerFrame());
		if (currentFrame.isEnded()) {
			frames.add(currentFrame);
			currentFrame = currentFrame.makeNewFrame();
		}
	}
	
	boolean isFinished() {
		return currentFrame.isEnded();
	}
}
