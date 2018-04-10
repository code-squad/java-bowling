package domain.frame.result.message;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class FrameMessage {
    private List<String> messages = new ArrayList<>();

    public void add(String resultMessage) {
        messages.add(resultMessage);
    }

    @Override
    public String toString() {
        return messages.stream().collect(joining("|"));
    }
}
