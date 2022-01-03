package MyTurtlePackage;

public class TurtleApplication {
	public static void main(String[] args) {
	    TurtleExecutor turtleExecutor = new TurtleExecutor();
	    turtleExecutor.executeOperation( new ConcreteMoveForwardOperation(new Turtle(0,0,0)));
	        
	}
	}


