package bowling.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.frame.Frame;
import bowling.frame.state.State;

public class Result {
	private static final Logger log = LoggerFactory.getLogger(Result.class);

	private final String newLine = System.getProperty("line.separator");

	private Frame frame;

	public Result(Frame frame) {
		this.frame = frame;
	}

	public String show(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(frontLine());
		stringBuilder.append(frameLine(name));
		stringBuilder.append(scoreLine());
		return stringBuilder.toString();
	}

	private StringBuilder scoreLine() {
		StringBuilder stringBuilder = new StringBuilder();
		Frame frame = this.frame;
		stringBuilder.append("|      |");
		while (frame != null) {
			stringBuilder.append("  ");
			stringBuilder.append(frame.getFrameEndScore());
			stringBuilder.append("  |");
			frame = frame.getNext();
		}
		return stringBuilder;
	}

	private StringBuilder frameLine(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(nameSection(name));
		stringBuilder.append(frameSection());
		return stringBuilder;
	}

	private StringBuilder frameSection() {
		StringBuilder stringBuilder = new StringBuilder();
		Frame frame = this.frame;
		while (frame != null) {
			stringBuilder.append("  ");
			State state = frame.getState();
			log.debug("{}", frame.getNo());
			stringBuilder.append(state.getPresentScore());
			stringBuilder.append("  |");
			frame = frame.getNext();
		}
		stringBuilder.append(newLine);
		return stringBuilder;
	}

	private StringBuilder nameSection(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("| ");
		stringBuilder.append(name);
		stringBuilder.append("  |");
		return stringBuilder;
	}

	private StringBuilder frontLine() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		stringBuilder.append(newLine);
		return stringBuilder;
	}

}
