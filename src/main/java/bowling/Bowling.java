package bowling;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
    private List<Integer> falledPins = new ArrayList<>();

    public List<String> roll(int falledPin) {
        falledPins.add(falledPin);
        processStrike(falledPin);
        
        return createResult(falledPins);
    }

    private void processStrike(int falledPin) {
        if (isStrike(falledPin)) {
            falledPins.add(0);
        }
    }

    List<String> createResult(List<Integer> falledPins) {
        List<String> result = new ArrayList<>();
        int offsetOfFrame = 0;
        while(offsetOfFrame < falledPins.size()) {
            result.add(status(falledPins, offsetOfFrame));
            offsetOfFrame += 2;
        }
        return result;
    }
    
    String createResultOf10(List<Integer> falledPinsOf10) {
        return status(falledPinsOf10, 0);
    }
    
    private String status(List<Integer> falledPins, int offsetOfFrame) {
        int first = falledPins.get(offsetOfFrame);
        if (isStrike(first)) {
            return "X";
        }
        
        int nextOffset = offsetOfFrame + 1;
        if (nextOffset < falledPins.size()) {
            int second = falledPins.get(nextOffset);
            if (isSpare(first, second)) {
                return first + "/";
            }
            return first + "" + second;
        }
        
        return first + "";
    }

    private boolean isStrike(int first) {
        return first == 10;
    }

    private boolean isSpare(int first, int second) {
        return first + second == 10;
    }
}
