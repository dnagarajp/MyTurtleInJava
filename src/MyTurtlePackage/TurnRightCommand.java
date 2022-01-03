package MyTurtlePackage;

public class TurnRightCommand implements Command {

	private Turtle turtle;
	int angle;

	public TurnRightCommand(Turtle turtle2, int angle) {
		this.turtle = turtle2;
		this.angle = angle;
	}

	/**
	 * Makes a turtle move Right by specifying an angle angle turn right from the
	 * current position which is always subtracted(anti clockwise) with the
	 * specified direction value and set the direction in right quadrant by using
	 * the formula.
	 */
	@Override
	public void execute() {
		turtle.direction -= angle;
		turtle.direction = (turtle.direction + 360) % 360;

	}

	@Override
	public String toString() {

		return "turnRight " + angle;

	}
}
