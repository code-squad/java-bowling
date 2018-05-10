package domain.status;

public interface Status {
	String display();
	boolean isClear();
	Status next(int pin);
	int getLeftPin();
}
