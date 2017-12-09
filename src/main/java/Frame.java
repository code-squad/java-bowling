import java.util.ArrayList;
import java.util.List;

public class Frame {

	private List<Integer> pinsPerFrame = new ArrayList<>();
	
	List<Integer> getPinsPerFrame () {
		return this.pinsPerFrame;
	}
	
	Frame makePinsPerFrame(int pinsPerTry) {
		this.pinsPerFrame.add(pinsPerTry);
		return this;
	}
}
