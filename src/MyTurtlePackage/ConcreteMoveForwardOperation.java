package MyTurtlePackage;
public class ConcreteMoveForwardOperation implements Command {

	private Turtle turtle;

	public ConcreteMoveForwardOperation(Turtle turtle2) {
		this.turtle = turtle2;

	}

	@Override
	public void execute() {
		turtle.moveForward(10);
	//	turtle.undoTheseCommands.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
