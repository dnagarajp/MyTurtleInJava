package MyTurtlePackageUsingCommandDesignPattern;

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

	/**
	 * Performs a iteration loop from endNnumber to startNumber. in a reverse
	 * commands way. ending command value, to be remember in java index start from 0
	 * in array.starting command checks and ensures the last element of command
	 * cannot be possible to execute. which is current method yalper(). traverse
	 * from endNumber to greater or equal to startNumber and gets the array values
	 * in order to perform reverse of reply method.
	 */
	@Override
	public void execute() {

		if (endNumber >= startNumber && endNumber < turtle.getCommands().size() && startNumber >= 0
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
