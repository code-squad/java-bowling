package bowling.model;

public class Frame {
	Frame next;
	State state;
	int no;
	
	public Frame(int no){
		this.state = new Ready();
		this.no = no;
	}
	
	public Frame bowl(int knockedPins) {
		return null;
	}
}
