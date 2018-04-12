package bowling.domain.frame;

import java.util.ArrayList;
import java.util.List;

import static bowling.domain.Utils.Formatter.formatFrame;

public class LabelFrames {
    private List<LabelFrame> labelFrames;

    public LabelFrames() {
        this.labelFrames = initializeLabels();
    }

    private List<LabelFrame> initializeLabels() {
        List<LabelFrame> labelFrames = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            labelFrames.add(new LabelFrame(i));
        }
        return labelFrames;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("| NAME |");
        for (LabelFrame frame : labelFrames) {
            builder.append(formatFrame(frame.toString()));
            builder.append("|");
        }
        return builder.toString();
    }
}