package MyTurtlePackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Turtle {

	public static void main(String[] args) {

		Turtle t1 = new Turtle();
		try {
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
					String[] parts = string.split(" ");
					String methodName = parts[0];
					int value1 = Integer.parseInt(parts[1]);
					if (methodName.compareTo("setDirection") == 0) {

						t1.setDirection(Integer.valueOf(value1));
					} else if (methodName.compareTo("moveForward") == 0) {
						t1.moveForward(Integer.valueOf(value1));
					} else if (methodName.compareTo("moveBackward") == 0) {
						t1.moveBackward(Integer.valueOf(value1));
					} else if (methodName.compareTo("turnLeft") == 0) {
						t1.turnLeft(Integer.valueOf(value1));
					} else if (methodName.compareTo("turnRight") == 0) {
						t1.turnRight(Integer.valueOf(value1));
					} else if (methodName.compareTo("moveTo") == 0) {
						int value2 = Integer.parseInt(parts[2]);
						t1.moveTo(Integer.valueOf(value1), Integer.valueOf(value2));
					} else if (methodName.compareTo("replay") == 0) {
						int value2 = Integer.parseInt(parts[2]);
						t1.replay(Integer.valueOf(value1), Integer.valueOf(value2));
					} else if (methodName.compareTo("yalper") == 0) {
						int value2 = Integer.parseInt(parts[2]);
						t1.yalper(Integer.valueOf(value1), Integer.valueOf(value2));
					} else if (methodName.compareTo("getList") == 0) {
						t1.getList();
					} else {
						System.out.println("Invalid method name");
					}
				}
				scanner.close();
				t1.getList();
				System.out.println("x = " + t1.x + " " + "y = " + t1.y + " " + "angle = " + t1.direction + "\n");
			}

		} catch (FileNotFoundException e) {

			System.out.println("File not found exception occurred look at the trace here");
			e.printStackTrace();
		} catch (NumberFormatException e) {

			System.out.println("Number Format Exception exception occurred look at the trace here");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Array out of bound exception occurred look at the trace here");
			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("There is an expection occurred look at the trace here");
			e.printStackTrace();
		}

		finally {
			System.out.println("Your program is completed");
		}
	}

	// Declare variables
	protected int x;
	protected int y;
	protected int direction;
	protected ArrayList<String> arrayLog;

	/**
	 * Default constructor calls another parameterized constructor.
	 */
	public Turtle() {
		this(0, 0, 0);
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
		arrayLog = new ArrayList<String>();

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

	// method to log all values in an array list.
	protected void Log(String methodName, int parameter1, int parameter2) {
		arrayLog.add(methodName + " " + parameter1 + " " + parameter2);
		// System.out.println(methodName + " " + parameter1 + " " + parameter2);
	}

	/**
	 * set the direction in [0-359]
	 * 
	 * @param direction positive numbers goes with clockwise direction, Negative
	 *                  numbers goes with backward direction
	 */
	public void setDirection(int direction) {
		Log("setDirection()", direction, 0);
		try {
			direction = (direction % 360);
			if (direction < 0) {
				direction = direction + 360;
			}

			this.direction = direction;
		} catch (Exception e) {
			System.out.println("Ensure you enter a integer values");
		}
	}

	/**
	 * Move to Specified location by specifying the newX and newY values.
	 * 
	 * @param x new value for x position
	 * @param y new value for y position
	 */
	protected void moveTo(int x, int y) {
		Log("moveTo()", x, y);
		try {
			this.x = x;
			this.y = y;
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException exception occurred : try to enter integer values");
			e.printStackTrace();
		}

	}

	/**
	 * Makes a turtle move forward with respect to its current angle
	 * 
	 * @param amount The distance for the turtle to move. This number is taken and
	 *               conversion from degree to radius is stored and used to
	 *               calculate the x and y positions by adding the old x and y
	 *               values.
	 */
	protected void moveForward(int step) {
		Log("moveForward()", step, 0);
		try {
			double dirRads = Math.PI * (this.direction / 180.0);
			int xStep = x + (int) Math.round(Math.cos(dirRads) * step);
			int yStep = y + (int) Math.round(Math.sin(dirRads) * step);
			this.x = xStep;
			this.y = yStep;
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException exception occurred : try to enter integer values");
			e.printStackTrace();
		}
	}

	/**
	 * Makes a turtle move backward with respect to its current angle
	 * 
	 * @param amount The distance for the turtle to move. This number is taken and
	 *               conversion from degree to radius is stored and used to
	 *               calculate the x and y positions by subtracting the old x and
	 *               old y values.
	 */
	protected void moveBackward(int step) {
		Log("moveBackward()", step, 0);
		try {
			double dirRads = Math.PI * (this.direction / 180.0);
			int endXStep = x - (int) Math.round(Math.cos(dirRads) * step);
			int endYStep = y - (int) Math.round(Math.sin(dirRads) * step);
			this.x = endXStep;
			this.y = endYStep;
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException exception occurred : try to enter integer values");
			e.printStackTrace();
		}

	}

	/**
	 * Makes a turtle move Right by specifying an angle
	 * 
	 * @param angle turn right from the current position which is always
	 *              subtracted(anti clockwise) with the specified direction value
	 *              and set the direction in right quadrant by using the formula.
	 */
	protected void turnRight(int angle) {
		Log("turnRight()", angle, 0);
		try {
			direction -= angle;
			direction = (direction + 360) % 360;
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException exception occurred : try to enter integer values");
			e.printStackTrace();
		}
	}

	/**
	 * Makes a turtle move Left by specifying an angle
	 * 
	 * @param angle turn left from the current position which is always added(clock
	 *              wise) with the specified direction value and sets the direction
	 *              in left quadrant by using the formula.
	 */
	protected void turnLeft(int angle) {

		Log("turnLeft()", angle, 0);
		try {
			direction += angle;
			direction = (direction + 360) % 360;
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException exception occurred : try to enter integer values");
			e.printStackTrace();
		}
	}

	/**
	 * Performs a iteration loop from startNumber to endNumber.
	 * 
	 * @param startNumber starting command value, to be remember in java index start
	 *                    from 0 in array
	 * @param endNumber   ending command value checks and ensures the last element
	 *                    of command cannot be possible to execute. which is current
	 *                    method replay()s
	 */
	protected void replay(int startNumber, int endNumber) {

		Log("replay()", startNumber, endNumber);
		try {
			if (startNumber <= endNumber && startNumber >= 0 && startNumber <= this.arrayLog.size()
					&& endNumber < this.arrayLog.size() - 1 && this.arrayLog.size() != 1) {
				for (int i = startNumber; i <= endNumber; i++) {
					String string = this.arrayLog.get(i);
					String[] parts = string.split(" ");
					String methodName = parts[0];
					String attributeValue1 = parts[1];
					int attribute1 = Integer.parseInt(attributeValue1);
					String attributeValue2 = parts[2];
					int attribute2 = Integer.parseInt(attributeValue2);
					searchMethodToInvoke(methodName, attribute1, attribute2);

				}
			} else {
				throw new MyCustomException();

			}
		} catch (MyCustomException e) {
			System.out.println(
					" Exception occurred when these conditions weren't met startNumber<=endNumber && startNumber >= 0 && startNumber <= this.arrayLog.size() && endNumber < this.arrayLog.size()-1 && this.arrayLog.size()!=1");

			e.printStackTrace();
		}
	}

	/**
	 * CommonMethod for Searching the methodName
	 * 
	 */
	protected void searchMethodToInvoke(String methodName, int attribute1, int attribute2) {
		try {
			int index = arrayLog.size();
			switch (methodName) {

			case "setDirection()":
				this.setDirection(attribute1);
				arrayLog.remove(index);
				break;
			case "moveTo()":
				this.moveTo(attribute1, attribute2);
				arrayLog.remove(index);
				break;
			case "moveForward()":
				this.moveForward(attribute1);
				arrayLog.remove(index);
				break;
			case "moveBackward()":
				this.moveBackward(attribute1);
				arrayLog.remove(index);
				break;

			case "turnRight()":
				this.turnRight(attribute1);
				arrayLog.remove(index);
				break;

			case "turnLeft()":
				this.turnLeft(attribute1);
				arrayLog.remove(index);
				break;

			case "replay()":
				this.replay(attribute1, attribute2);
				arrayLog.remove(index);
				break;

			case "yalper()":
				this.yalper(attribute1, attribute2);
				arrayLog.remove(index);
				break;

			default:
				System.out.println("Invalid method name");
			}
		} catch (Exception e) {
			System.out.println("Method not found");
			e.printStackTrace();
		}
	}

	/**
	 * Performs a iteration loop from endNnumber to startNumber. in a reverse
	 * commands way.
	 * 
	 * @param endNumber   ending command value, to be remember in java index start
	 *                    from 0 in array.starting command checks and ensures the
	 *                    last element of command cannot be possible to execute.
	 *                    which is current method yalper().
	 * @param startNumber traverse from endNumber to greater or equal to startNumber
	 *                    and gets the array values in order to perform reverse of
	 *                    reply method.
	 */
	protected void yalper(int endNumber, int startNumber) {
		Log("yalper()", endNumber, startNumber);
		try {

			if (endNumber >= startNumber && endNumber < this.arrayLog.size() - 1 && startNumber >= 0
					&& this.arrayLog.size() != 1) {
				for (int i = endNumber; i >= startNumber; i--) {
					String string = this.arrayLog.get(i);
					String[] parts = string.split(" ");
					String methodName = parts[0];
					String attributeValue1 = parts[1];
					int attribute1 = Integer.parseInt(attributeValue1);
					String attributeValue2 = parts[2];
					int attribute2 = Integer.parseInt(attributeValue2);
					searchMethodToInvoke(methodName, attribute1, attribute2);

				}
			} else {
				throw new MyCustomException();
			}
		} catch (MyCustomException e) {
			System.out.println("Exception caught when endNumber > arraySize and startNumber > 0 ");
			e.printStackTrace();

		}
	}

	/**
	 * Gets the entire list of commands which are executed.
	 */
	protected void getList() {
		// System.out.println("Array Size is := " + this.arrayLog.size() + "\n" +
		// "Commands executed are : ");
		try {

			for (int i = 0; i < this.arrayLog.size(); i++) {
				System.out.println(this.arrayLog.get(i));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("ArrayIndexOutOfBoundsException trying to access non index element");
		}

	}

}
