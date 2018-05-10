package domain.status;

public abstract class Status {
	public abstract String display();
	public abstract boolean isClear();
	public abstract Status next(int pin);
	abstract int getLeftPin();
	public boolean ofInstance(Object status) {
		return ((Class) status).getName().equals(this.getClass().getName());
	}
}
