package MyTurtlePackage;

import java.util.LinkedList;

public class YalplerCommand implements Command {

	private Turtle turtle;
	int startNumber, endNumber;
	LinkedList<Command> command;

	public YalplerCommand(Turtle turtle2, int endNumber, int startNumber) {
		this.turtle = turtle2;
		this.startNumber = startNumber;
		this.endNumber = endNumber;

	}

	@Override
	public void execute() {

		if (endNumber >= startNumber && endNumber < turtle.getCommands().size() - 1 && startNumber >= 0
				&& turtle.getCommands().size() != 1) {

			for (int i = endNumber; i >= startNumber; i--) {
				Command c = turtle.getCommands().get(i);
				turtle.doReplayCommand(c);
			}
		}

	}

	@Override
	public String toString() {

		return "yalper " + endNumber + " " + startNumber;

	}

}
