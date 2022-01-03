package MyTurtlePackage;

public class SetDirectionCommand implements Command {
	private Turtle turtle;
	int angle;

	public SetDirectionCommand(Turtle turtle2, int angle) {
		this.turtle = turtle2;
		this.angle = angle;
	}

	/**
	 * Sets the direction as specified by angle
	 */
	@Override
	public void execute() {
		this.angle = (this.angle % 360);
		if (this.angle < 0) {
			this.angle = this.angle + 360;
		}

		turtle.direction = this.angle;

	}
	
	@Override
	public String toString() {
		
		return "setDirection " + angle ;
		 
	}

}
