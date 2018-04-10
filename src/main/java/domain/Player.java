package domain;

import domain.frame.Frames;
import domain.frame.result.FrameMessages;

public class Player {
    private PlayerName name;
    private Frames frames;
    private FrameMessages messages;

    public Player(String name) throws IllegalArgumentException {
        this.name = new PlayerName(name);
        frames = new Frames();
        messages = new FrameMessages();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isFinish() {
        return frames.isFinish();
    }

    public FrameMessages recordPins(int pins) {
        messages.addFrameMessage(frames.getCurrentFrameIdx(), frames.recordPins(pins));
        return messages;
    }

    public int getCurrentFrameNum() {
        return frames.getCurrentFrameNum();
    }

    public FrameMessages getMessages() {
        return messages;
    }
}
