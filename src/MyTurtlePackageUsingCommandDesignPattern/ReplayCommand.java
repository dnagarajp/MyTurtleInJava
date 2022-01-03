package MyTurtlePackageUsingCommandDesignPattern;

public class ReplayCommand implements Command {

	private Turtle turtle;
	int startNumber, endNumber;

	public ReplayCommand(Turtle turtle2, int startNumber, int endNumber) {
		this.turtle = turtle2;
		this.startNumber = startNumber;
		this.endNumber = endNumber;

	}

	/**
	 * Performs a iteration loop from startNumber to endNumber. starting command
	 * value, to be remember in java index start from 0 in array ending command
	 * value checks and ensures the last element of command cannot be possible to
	 * execute. which is current method replay()
	 */
	@Override
	public void execute() {
		if (startNumber <= endNumber && startNumber >= 0 && startNumber <= turtle.getCommands().size()
				&& endNumber < turtle.getCommands().size() && turtle.getCommands().size() != 1) {
			for (int i = startNumber; i <= endNumber; i++) {
				Command c = turtle.getCommands().get(i);
				turtle.doReplayCommand(c);

			}
		}
	}
	
	@Override
	public String toString() {

		return "replay " + startNumber + " " + endNumber;

	}
}
