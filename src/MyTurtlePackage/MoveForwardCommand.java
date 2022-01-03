package MyTurtlePackage;
public class MoveForwardCommand implements Command {

	private Turtle turtle;
	int steps;
	public MoveForwardCommand(Turtle turtle2, int steps) {
		this.turtle = turtle2;
		this.steps = steps;

	}

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
		
		return "moveForward " + steps ;
		 
	}
}
