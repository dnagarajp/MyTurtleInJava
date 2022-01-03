package MyTurtlePackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Turtle {

	// Declare variables
	protected int x;
	protected int y;
	protected int direction;
	ArrayList<Command> commands;
	protected ArrayList<String> arrayLog;

	/**
	 * Default constructor calls another parameterized constructor.
	 */
	public Turtle() {
		this(0, 0, 0);
	}

	public static void main(String[] args) throws FileNotFoundException {

		Turtle t1 = new Turtle();

		/**
		 * Reads commands from text file and executes them prints the current value of X
		 * , Y and angle
		 */
		File file = new File("/Users/deepa/eclipse-workspace/TurtleSimple/src/File1.txt");

		if ((file.length() == 0)) {
			System.out.println("File is empty");
		}

		else {
			Scanner scanner = new Scanner((file));
			while (scanner.hasNextLine()) {
				String string = scanner.nextLine();
				Command newFileCommand = CommandFactory.fromString(t1, string);
				t1.doCommand(newFileCommand);

			}
			scanner.close();
			t1.getList();
			System.out.println("x = " + t1.x + " " + "y = " + t1.y + " " + "angle = " + t1.direction + "\n");
		}

	}

	/**
	 * Object Constructor initialization based on Parameters
	 * 
	 * @param x         position value
	 * @param y         position value
	 * @param direction or angle of the circle in degrees
	 */
	public Turtle(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		commands = new ArrayList<Command>();

	}

	public ArrayList<Command> getCommands() {
		return commands;
	}

	// Return the current x position
	protected int getXPosition() {
		return this.x;

	}

	// Return the current y position
	protected int getYPosition() {
		return this.y;

	}

	// Return the current direction or angle
	protected int getDirection() {
		return this.direction;
	}
	
	
	public void setDirection(int i) {
		Command command = new SetDirectionCommand(this, i);
		command.execute();
		
	}

	/**
	 * Move to Specified location by specifying the newX and newY values.
	 * 
	 * @param x new value for x position
	 * @param y new value for y position
	 */
	protected void moveTo(int x, int y) {
		Command command = new MoveToCommand(this, x, y);
		command.execute();
	}

	/**
	 * Makes a turtle move forward with respect to its current angle
	 * 
	 * @param amount The distance for the turtle to move. This number is taken and
	 *               conversion from degree to radius is stored and used to
	 *               calculate the x and y positions by adding the old x and y
	 *               values.
	 */
	protected void moveForward(int steps) {
		Command command = new MoveForwardCommand(this, steps);
		command.execute();
	}

	/**
	 * Makes a turtle move backward with respect to its current angle
	 * 
	 * @param amount The distance for the turtle to move. This number is taken and
	 *               conversion from degree to radius is stored and used to
	 *               calculate the x and y positions by subtracting the old x and
	 *               old y values.
	 */

	protected void moveBackward(int steps) {
		Command command = new MoveBackwardCommand(this, steps);
		command.execute();
	}

	/**
	 * Makes a turtle move Right by specifying an angle
	 * 
	 * @param angle turn right from the current position which is always
	 *              subtracted(anti clockwise) with the specified direction value
	 *              and set the direction in right quadrant by using the formula.
	 */
	protected void turnRight(int angle) {
		// Log("turnRight()", angle, 0);

		Command command = new TurnRightCommand(this, angle);
		command.execute();
	}

	/**
	 * Makes a turtle move Left by specifying an angle
	 * 
	 * @param angle turn left from the current position which is always added(clock
	 *              wise) with the specified direction value and sets the direction
	 *              in left quadrant by using the formula.
	 */
	protected void turnLeft(int angle) {

		// Log("turnLeft()", angle, 0);
		Command command = new TurnLeftCommand(this, angle);
		command.execute();

	}
	

	protected void replay(int s, int e) {
		Command command = new ReplayCommand(this, s, e);
		command.execute();
	}
	
	protected void yalper(int e, int s) {
		Command command = new ReplayCommand(this, e, s);
		command.execute();
	}
	
	
	/**
	 * Gets the entire list of commands which are executed.
	 */
	protected void getList() {
		// System.out.println("Array Size is := " + this.arrayLog.size() + "\n" +
		// "Commands executed are : ");

		for (int i = 0; i < this.commands.size(); i++) {
			// String s1 = commands.getClass().getName();
			System.out.println(this.commands.get(i).getClass().getName());
		}
	}

	public void doCommand(Command name) {
		name.execute();
		commands.add(name);
	}

	public void doReplayCommand(Command name) {
		name.execute();
	}



	
}
