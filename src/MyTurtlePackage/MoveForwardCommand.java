package MyTurtlePackage;

public class MoveForwardCommand implements Command {

	private Turtle turtle;
	int steps;

	public MoveForwardCommand(Turtle turtle2, int steps) {
		this.turtle = turtle2;
		this.steps = steps;

	}

	/**
	 * Makes a turtle move forward with respect to its current angle
	 * The distance for the turtle to move. This number is taken and conversion from
	 * degree to radius is stored and used to calculate the x and y positions by
	 * adding the old x and y values.
	 */
	@Override
	public void execute() {
		double dirRads = Math.PI * (turtle.direction / 180.0);
		int xStep = turtle.x + (int) Math.round(Math.cos(dirRads) * steps);
		int yStep = turtle.y + (int) Math.round(Math.sin(dirRads) * steps);
		turtle.x = xStep;
		turtle.y = yStep;
	}

	@Override
	public String toString() {

		return "moveForward " + steps;

	}
}
