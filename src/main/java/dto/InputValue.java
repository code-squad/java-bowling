package dto;

import java.util.List;

public class InputValue {
	private String usrId;
	private int falledPin;
	
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	public void setFalledPin(int falledPin) {
		this.falledPin = falledPin;
	}
	
	public int getFalledPin() {
		return falledPin;
	}
}
