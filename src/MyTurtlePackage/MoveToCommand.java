package MyTurtlePackage;

public class MoveToCommand implements Command {

	private Turtle turtle;
	int xNew, yNew;

	public MoveToCommand(Turtle turtle2, int x, int y) {
		this.turtle = turtle2;
		this.xNew = x;
		this.yNew = y;

	}

	@Override
	public void execute() {
		
		turtle.x = xNew;
		turtle.y = yNew;
		 
	}
	
	@Override
	public String toString() {
		
		return "moveTo " + xNew + " " + yNew;
		 
	}

}
