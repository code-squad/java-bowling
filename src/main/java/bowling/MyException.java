package bowling;

public class MyException extends Exception {
	private String errorMessage;
	MyException(String errorMessage) { // 생성자
		super(errorMessage);
		this.errorMessage = errorMessage;

	}
	
	public String getErrorMessage(){
		return errorMessage;
	}
}
