package MyTurtlePackage;

import java.util.ArrayList;

class Turtle {

	public static void main(String[] args) {

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
	public int getXPosition() {
		return this.x;

	}

	// Return the current y position
	public int getYPosition() {
		return this.y;

	}

	// Return the current direction or angle
	public int getDirection() {
		return this.direction;
	}

	// method to log all values in an array list.
	public void Log(String methodName, int parameter1, int parameter2) {
		arrayLog.add(methodName + " " + parameter1 + " " + parameter2);
	}

	/**
	 * set the direction in [0-359]
	 * 
	 * @param direction positive numbers goes with clockwise direction, Negative
	 *                  numbers goes with backward direction
	 */
	public void setDirection(int direction) {
		Log("setDirection()", direction, 0);

		direction = (direction % 360);
		if (direction < 0) {
			direction = direction + 360;
		}

		this.direction = direction;
	}

	/**
	 * Move to Specified location by specifying the newX and newY values.
	 * 
	 * @param x new value for x position
	 * @param y new value for y position
	 */
	public void moveTo(int x, int y) {
		Log("moveTo()", x, y);

		this.x = x;
		this.y = y;

	}

	/**
	 * Makes a turtle move forward with respect to its current angle
	 * 
	 * @param amount The distance for the turtle to move. This number is taken and
	 *               conversion from degree to radius is stored and used to
	 *               calculate the x and y positions by adding the old x and y
	 *               values.
	 */
	public void moveForward(int step) {
		Log("moveForward()", step, 0);
		double dirRads = Math.PI * (this.direction / 180.0);
		int xStep = x + (int) Math.round(Math.cos(dirRads) * step);
		int yStep = y + (int) Math.round(Math.sin(dirRads) * step);
		this.x = xStep;
		this.y = yStep;
	}

	/**
	 * Makes a turtle move backward with respect to its current angle
	 * 
	 * @param amount The distance for the turtle to move. This number is taken and
	 *               conversion from degree to radius is stored and used to
	 *               calculate the x and y positions by subtracting the old x and
	 *               old y values.
	 */
	public void moveBackward(int step) {
		Log("moveBackward()", step, 0);
		double dirRads = Math.PI * (this.direction / 180.0);
		int endXStep = x - (int) Math.round(Math.cos(dirRads) * step);
		int endYStep = y - (int) Math.round(Math.sin(dirRads) * step);
		this.x = endXStep;
		this.y = endYStep;

	}

	/**
	 * Makes a turtle move Right by specifying an angle
	 * 
	 * @param angle turn right from the current position which is always
	 *              subtracted(anti clockwise) with the specified direction value
	 *              and set the direction in right quadrant by using the formula.
	 */
	public void turnRight(int angle) {
		Log("turnRight()", angle, 0);
		direction -= angle;
		direction = (direction + 360) % 360;
	}

	/**
	 * Makes a turtle move Left by specifying an angle
	 * 
	 * @param angle turn left from the current position which is always added(clock
	 *              wise) with the specified direction value and sets the direction
	 *              in left quadrant by using the formula.
	 */
	public void turnLeft(int angle) {
		Log("turnLeft()", angle, 0);
		direction += angle;
		direction = (direction + 360) % 360;
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
	public void replay(int startNumber, int endNumber) {

		Log("replay()", startNumber, endNumber);
		if (endNumber < this.arrayLog.size() && startNumber >= 0) {
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
			System.out.println("Ensure of the StartNumber is always > 0  and EnnNumber < current Index");
		}
	}

	/**
	 * CommonMethod for Searching the methodName
	 * 
	 */
	public void searchMethodToInvoke(String methodName, int attribute1, int attribute2) {

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

	public void yalper(int endNumber, int startNumber) {
		Log("yalper()", endNumber, startNumber);

		if (endNumber < this.arrayLog.size()) {
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
			System.out.println("End Number is greater than the arrayLog size");
			System.out.println("Ensure of the EndNumber is always < array size  and startNumber greater or equal to 0");
		}
	}

	/**
	 * Gets the entire list of commands which are executed.
	 */
	public void getList() {
		System.out.println("Array Size is :=  " + this.arrayLog.size() + "\n" + "Commands executed are : ");
		for (int i = 0; i < this.arrayLog.size(); i++) {
			System.out.println(this.arrayLog.get(i));
		}
		System.out.println("\n");

	}

}
