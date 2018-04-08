package domain.frame.result;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class FrameResult {
    private List<String> results = new ArrayList<>();

    public void addResultEachThrow(String resultMessage) {
        results.add(resultMessage);
    }

    @Override
    public String toString() {
        return results.stream().collect(joining("|"));
    }
}
