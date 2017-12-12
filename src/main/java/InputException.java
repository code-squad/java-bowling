
public class InputException extends RuntimeException{
	public InputException (String message) {
		super(message);
	}
	
	public static boolean isString(String name) {
	    try {
	        Double.parseDouble(name);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }
}
