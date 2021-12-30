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
	 * Constructor with values are initialized. you can create objects with default
	 * or parameter constructor. as you choose
	 */
	protected Turtle() {
		this.x = 0;
		this.y = 0;
		this.direction = 0;
		arrayLog = new ArrayList<String>();
	}

	/**
	 * Object Constructor initialization based on Parameters
	 * 
	 * @param x         position value
	 * @param y         position value
	 * @param direction or angle of the circle in degrees
	 */
	protected Turtle(int x, int y, int direction) {
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

	/**
	 * set the direction in [0-359]
	 * 
	 * @param direction positive numbers goes with clockwise direction, Negative
	 *                  numbers goes with backward direction
	 */
	protected void setDirection(int direction) {
		arrayLog.add("setDirection()" + " " + direction);
		direction = (direction % 360);
		if (direction < 0) {
			direction = direction + 360;
		}

		this.direction = direction;
	}

	protected void moveTo(int x, int y) {
		arrayLog.add("moveTo()" + " " + x + " " + y);
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
	protected void moveForward(int step) {
		arrayLog.add("moveForward()" + " " + step);
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
	protected void moveBackward(int step) {
		arrayLog.add("moveBackward()" + " " + step);
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
	protected void turnRight(int angle) {
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
	protected void turnLeft(int angle) {
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
	protected void replay(int startNumber, int endNumber) {

		arrayLog.add("replay()" + " " + startNumber + " " + endNumber);
		if (endNumber < this.arrayLog.size()) {
			for (int i = startNumber; i <= endNumber; i++) {
				String string = this.arrayLog.get(i);
				String[] parts = string.split(" ");
				String methodName = parts[0];
				String attributeValue = parts[1];
				int attribute = Integer.parseInt(attributeValue);

				/**
				 * Finds the right methodName and invokes it by passing the right attribute
				 * values
				 */
				switch (methodName) {

				case "setDirection()":
					this.setDirection(attribute);
					break;
				case "moveTo()":
					String getPosition2 = parts[2];
					int position2 = Integer.parseInt(getPosition2);
					this.moveTo(attribute, position2);
					break;
				case "moveForward()":
					this.moveForward(attribute);
					break;
				case "moveBackward()":
					this.moveBackward(attribute);
					break;
				case "replay()":
					String attributeValue2 = parts[2];
					int attribute2 = Integer.parseInt(attributeValue2);
					this.replay(attribute, attribute2);
					break;
				case "yalper()":
					String attributeVal = parts[2];
					int attr2 = Integer.parseInt(attributeVal);
					this.yalper(attribute, attr2);
					break;
				default:
					System.out.println("Invalid method name");
				}
			}
		} else {
			System.out.println("End Number is greater than the arrayLog size");
		}
	}

	/**
	 * Gets the entire list of commands which are executed.
	 */
	protected void getList() {
		System.out.println("Array Size is :=  " + this.arrayLog.size() + "\n" + "Commands executed are : ");
		for (int i = 0; i < this.arrayLog.size(); i++) {
			System.out.println(this.arrayLog.get(i));
		}
		System.out.println("\n");

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
		arrayLog.add("yalper()" + " " + endNumber + " " + startNumber);
		if (endNumber < this.arrayLog.size()) {
			for (int i = endNumber; i >= startNumber; i--) {
				String string = this.arrayLog.get(i);
				String[] parts = string.split(" ");
				String methodName = parts[0];
				String attributeValue = parts[1];
				int attribute = Integer.parseInt(attributeValue);

				/**
				 * Finds the right methodName and invokes it by passing the right attribute
				 * values
				 */
				switch (methodName) {

				case "setDirection()":
					this.setDirection(attribute);
					break;
				case "moveTo()":
					String getPosition2 = parts[2];
					int position2 = Integer.parseInt(getPosition2);
					this.moveTo(attribute, position2);
					break;
				case "moveForward()":
					this.moveForward(attribute);
					break;
				case "moveBackward()":
					this.moveBackward(attribute);
					break;
				case "replay()":
					String attributeValue2 = parts[2];
					int attribute2 = Integer.parseInt(attributeValue2);
					this.replay(attribute, attribute2);
					break;
				case "yalper()":
					String attributeVal = parts[2];
					int attr2 = Integer.parseInt(attributeVal);
					this.yalper(attribute, attr2);
					break;
				default:
					System.out.println("Invalid method name");

				}
			}
		} else {
			System.out.println("End Number is greater than the arrayLog size");
		}
	}

}