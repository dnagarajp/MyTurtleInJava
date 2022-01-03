package MyTurtlePackage;

import java.util.LinkedList;

public class ReplayCommand implements Command {

	private Turtle turtle;
	int startNumber, endNumber;
	LinkedList<Command> command;

	public ReplayCommand(Turtle turtle2, int startNumber, int endNumber) {
		this.turtle = turtle2;
		this.startNumber = startNumber;
		this.endNumber = endNumber;

	}

	@Override
	public void execute() {
		if (startNumber <= endNumber && startNumber >= 0 && startNumber <= turtle.getCommands().size()
				&& endNumber < turtle.getCommands().size() - 1 && turtle.getCommands().size() != 1) {
			for (int i = startNumber; i <= endNumber; i++) {
				Command c = turtle.getCommands().get(i);
				turtle.doReplayCommand(c);
			}
		}
	}
}
