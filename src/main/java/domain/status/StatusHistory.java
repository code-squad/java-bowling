package domain.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatusHistory {
	private List<Status> statuses;
	
	public StatusHistory(int firstPin) {
		statuses = new ArrayList<>(Arrays.asList(new Ready().next(firstPin)));
	}
	
	public Status getLatest() {
		return statuses.get(statuses.size() - 1);
	}
	
	public StatusHistory add(int pin) {
		statuses.add(getLatest().next(pin));
		return this;
	}
	
	public String display() {
		return statuses.stream()
				.map(Status::display)
				.collect(Collectors.joining("|"));
	}
}
