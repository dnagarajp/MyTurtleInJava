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
		
		int xOld = turtle.x;
		int yOld = turtle.y;
		turtle.x = xNew;
		turtle.y = yNew;
		 
	}

}
