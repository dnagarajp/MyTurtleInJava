package MyTurtlePackageUsingCommandDesignPattern;

public class TurnLeftCommand implements Command {

	private Turtle turtle;
	int angle;

	public TurnLeftCommand(Turtle turtle2, int angle) {
		this.turtle = turtle2;
		this.angle = angle;

	}

	/**
	 * Makes a turtle move Left by specifying an angle angle turn left from the
	 * current position which is always added(clock wise) with the specified
	 * direction value and sets the direction in left quadrant by using the formula.
	 */
	@Override
	public void execute() {
		turtle.direction += angle;
		turtle.direction = (turtle.direction + 360) % 360;
	}

	@Override
	public String toString() {

		return "turnLeft " + angle;

	}
}
