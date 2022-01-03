package MyTurtlePackageUsingCommandDesignPattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
		 * Y and angle
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

	/**
	 * Gets the entire list of commands which are executed.
	 */
	protected void getList() {
		// System.out.println("Array Size is := " + this.arrayLog.size() + "\n" +
		// "Commands executed are : ");

		for (int i = 0; i < this.getCommands().size(); i++) {
			// String s1 = commands.getClass().getName();
			System.out.println(this.getCommands().get(i).toString());
		}
	}

	/**
	 * uses this command to execute the corresponding command class which
	 * implemented using a Command Interface and add the command name to Arraylist
	 * of commands
	 * 
	 * @param name an Interface to Command
	 */

	public void doCommand(Command name) {
		name.execute();
		commands.add(name);
	}

	/**
	 * uses this command to execute the reply command only to execute and but not
	 * store sub sequence of commands to an arraylist of commands
	 * 
	 * @param name an Interface Command
	 */
	public void doReplayCommand(Command name) {

		name.execute();
	}

}
