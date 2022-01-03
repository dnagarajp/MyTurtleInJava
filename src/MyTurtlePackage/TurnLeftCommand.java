package MyTurtlePackage;
public class TurnLeftCommand implements Command {

	private Turtle turtle;
	int angle;
	public TurnLeftCommand(Turtle turtle2, int angle) {
		this.turtle = turtle2;
		this.angle = angle;

	}

	@Override
	public void execute() {
		turtle.direction += angle;
		turtle.direction = (turtle.direction + 360) % 360;
	}

	@Override
	public String toString() {
		
		return "turnLeft " + angle ;
		 
	}
}
