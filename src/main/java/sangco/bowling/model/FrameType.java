package sangco.bowling.model;

public enum FrameType {
	NOMALFRAME(), SPAREFRAME(), STRIKEFRAME(), LASTFRAME();
	
	private FrameType() {
	}
	
	public static FrameType getFrameType(Frame frame) {
		if(frame instanceof StrikeFrame) {
			return FrameType.STRIKEFRAME;
		}
		if(frame instanceof SpareFrame) {
			return FrameType.SPAREFRAME;
		}
		return FrameType.NOMALFRAME;
	}
}
